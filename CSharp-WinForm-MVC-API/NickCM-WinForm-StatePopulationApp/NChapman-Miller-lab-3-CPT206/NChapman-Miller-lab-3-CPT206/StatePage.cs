using StatesDBLibrary;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NChapman_Miller_lab_3_CPT206
{
    public partial class StatePage : Form
    {

        public DBMethods DBMethods;
        public State userState;
        public string flagUrl;
        public StatePage(State statePicked)
        {
            
            InitializeComponent();
            DBMethods = new DBMethods();

            userState = statePicked;
            flagUrl = userState.FlagUrl;

            
                //test if Url valid with method from class library
                if (DBMethods.ValidateUrl(flagUrl))
                {
                    pBoxFlag.Load(flagUrl);
            }
            else
            {
                MessageBox.Show("URL INVALID");
            }

                //fill labels with stats from selected state
            lblName.Text = userState.Name;
            lblPop.Text = "Pop: "+userState.Population.ToString("N0");
            lblFlower.Text = "Flower: "+userState.Flower;
            lblBird.Text = "Bird: "+userState.Bird;
            lblCapital.Text = "Capital: " + userState.Capital;
            lblColors.Text = "Colors: " + userState.Colors;
            lblCompJobs.Text = "Percent of Computer Science Jobs: " + userState.PercentofComputerJobs.ToString();
            lblLargestCity.Text = "Largest City: " + userState.LargestCity;
            lblSecondLargestCity.Text = "2nd Largest City: " + userState.SecondLargestCity;
            lblThirdLargestCity.Text = "3rd Largest City: " + userState.ThirdLargestCity;
            lblMedianHouseholdIncome.Text = "Median Household Income: " + userState.MedianHouseholdIncome.ToString("C");
        }

        private void butExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
