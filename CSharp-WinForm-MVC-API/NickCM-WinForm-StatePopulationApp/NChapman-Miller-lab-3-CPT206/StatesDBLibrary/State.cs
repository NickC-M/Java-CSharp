using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StatesDBLibrary
{
    public class State
    {
            public int ID { get; set; }
            public string Name { get; set; }
            public int Population { get; set; }
            public string FlagDesc { get; set; }
            public string FlagUrl { get; set; }
            public string Flower { get; set; }
            public string Bird { get; set; }
            public string Colors { get; set; }
            public string LargestCity { get; set; }
            public string SecondLargestCity { get; set; }
            public string ThirdLargestCity { get; set; }
            public string Capital { get; set; }
            public int MedianHouseholdIncome { get; set; }
            public decimal PercentofComputerJobs { get; set; }

            public State(int iD, string name, int population, string flagDesc, string flagUrl, string flower, string bird, string colors, string largestCity, string secondLargestCity, string thirdLargestCity, string capital, int medianHouseholdIncome, decimal percentofComputerJobs)
            {
                ID = iD;
                Name = name;
                Population = population;
                FlagDesc = flagDesc;
                FlagUrl = flagUrl;
                Flower = flower;
                Bird = bird;
                Colors = colors;
                LargestCity = largestCity;
                SecondLargestCity = secondLargestCity;
                ThirdLargestCity = thirdLargestCity;
                Capital = capital;
                MedianHouseholdIncome = medianHouseholdIncome;
                PercentofComputerJobs = percentofComputerJobs;
                

            }

            public State()
            {
    
            }
        
    }
}
