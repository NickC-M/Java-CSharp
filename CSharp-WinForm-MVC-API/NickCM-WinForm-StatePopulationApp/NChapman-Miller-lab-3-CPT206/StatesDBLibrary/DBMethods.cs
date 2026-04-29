using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.VisualBasic.FileIO;
namespace StatesDBLibrary
{
    public class DBMethods
    {


        public List<State> FetchStateData(string filePath)
        {
            List<State> states = new List<State>();
            string[] columns = new string[14];
            using (TextFieldParser parser = new TextFieldParser(filePath))
            {
                parser.TextFieldType = FieldType.Delimited;
                parser.SetDelimiters(",");
                parser.HasFieldsEnclosedInQuotes = true;  //description parses fully now

                //get rid of headings
                parser.ReadLine();

                while (!parser.EndOfData)
                {
                    columns = parser.ReadFields();

                    if (columns.Length < 9) { continue; }

                    int iD = 0;
                    int pop = 0;
                    int medInc = 0;
                    decimal compJobs = 0;

                    int.TryParse(columns[0].Trim(), out iD);
                    int.TryParse(columns[2].Trim(), out pop);
                    int.TryParse(columns[12].Trim(), out medInc);
                    decimal.TryParse(columns[13].Trim(), out compJobs);


                    State state = new State(iD, columns[1].Trim(), pop, columns[3].Trim(), columns[4].Trim(), columns[5].Trim(), columns[6].Trim(), columns[7].Trim(), columns[8].Trim(), columns[9].Trim(), columns[10].Trim(), columns[11], medInc, compJobs);
                    states.Add(state);

                }
                return states;
            }
        }



        public static bool ValidateUrl(string url)
        {
            bool success = Uri.IsWellFormedUriString(url, UriKind.RelativeOrAbsolute);

            return success;
        }

    }
}
