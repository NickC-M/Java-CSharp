using StatesDBLibrary;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

/*
 * Nicholas Chapman-Miller
 * Lab 3 State Database
 * 
 */

namespace NChapman_Miller_lab_3_CPT206
{
    public partial class Form1 : Form
    {
        //location of state data
        public static string filePath = "statedata.csv";
        //list of all states with info
        public List<State> states = new List<State>();
        // object from class library to use methods
        public DBMethods dbm = new DBMethods();
        private Boolean dataLoaded = false;

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            

            string conString = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=|DataDirectory|\StateInfo.mdf;Integrated Security=True;";

            using (SqlConnection connection = new SqlConnection(conString))
            {
                connection.Open();
                using (SqlCommand cmd = new SqlCommand("DELETE FROM dbo.StateInfo", connection))
                {
                    cmd.ExecuteNonQuery(); //remove rows so data isn't duplicated in database
                }
                using (SqlCommand resetCmd = new SqlCommand("DBCC CHECKIDENT('dbo.StateInfo', RESEED, 0)", connection)) //reset identitynum back to 0 so state ID is correct
                {
                    resetCmd.ExecuteNonQuery(); 
                }

                connection.Close();
            }

            this.stateInfoTableAdapter.Fill(this.stateInfoDataSet.StateInfo);



        


        
        }


        private void stateInfoBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.stateInfoBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.stateInfoDataSet);

        }

        private void butInsertData_Click(object sender, EventArgs e)
        {
            loadTableData();
            //enable buttons so user can search/sort
            butHighPop.Enabled = true;
            butLowPop.Enabled = true ;
            butSearch.Enabled = true ;
            butSortPopAsc.Enabled = true ;
            butSortPopDesc.Enabled = true ;
            butStagePage.Enabled = true ;
            butInsertData.Enabled = false;

    }



        public void loadTableData()
        {
            if (!dataLoaded) //if data loaded once already it wont
            {
                states = dbm.FetchStateData(filePath);
                //query to put data into a row in database
                string insertQry = "INSERT INTO dbo.StateInfo (Name, Population, FlagDescription, FlagURL, Flower, Bird, Colors, LargestCity, SecondLargestCity, ThirdLargestCity, Capital, MedianHouseholdIncome, PercentofComputerJobs) VALUES (@Name, @Population, @FlagDescription, @FlagURL, @Flower, @Bird, @Colors, @LargestCity, @SecondLargestCity, @ThirdLargestCity, @Capital, @MedianHouseholdIncome, @PercentofComputerJobs)";
                //connection string to db
                string conString = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=|DataDirectory|\StateInfo.mdf;Integrated Security=True;";

                try
                {
                    using (SqlConnection connection = new SqlConnection(conString))
                    {

                        connection.Open();
                        foreach (State state in states)
                        {
                            //populate combo box for state page
                            cBoxStates.Items.Add(state.Name);

                            using (SqlCommand command = new SqlCommand(insertQry, connection)) //command to do insertQry on stateinfo database
                            {

                                // add all info for each state into the row as parameters for the insertQry

                                command.Parameters.AddWithValue("@Name", state.Name);
                                command.Parameters.AddWithValue("@Population", state.Population);
                                command.Parameters.AddWithValue("@FlagDescription", state.FlagDesc);
                                command.Parameters.AddWithValue("@FlagURL", state.FlagUrl);
                                command.Parameters.AddWithValue("@Flower", state.Flower);
                                command.Parameters.AddWithValue("@Bird", state.Bird);
                                command.Parameters.AddWithValue("@Colors", state.Colors);
                                command.Parameters.AddWithValue("@LargestCity", state.LargestCity);
                                command.Parameters.AddWithValue("@SecondLargestCity", state.SecondLargestCity);
                                command.Parameters.AddWithValue("@ThirdLargestCity", state.ThirdLargestCity);
                                command.Parameters.AddWithValue("@Capital", state.Capital);
                                command.Parameters.AddWithValue("@MedianHouseholdIncome", state.MedianHouseholdIncome);
                                command.Parameters.AddWithValue("@PercentofComputerJobs", state.PercentofComputerJobs);

                                command.ExecuteNonQuery();




                            }


                        }
                        connection.Close();
                        MessageBox.Show("Data inserted successfully!");
                        this.stateInfoTableAdapter.Fill(this.stateInfoDataSet.StateInfo);
                        dataLoaded = true; //boolean to stop data from being loaded multiple times
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error inserting data: " + ex.Message);
                }
            }
            else
            {
                MessageBox.Show("DATA IS ALREADY LOADED!!");
            }
        }

        private void butStagePage_Click(object sender, EventArgs e)
        {
            int ind = Math.Max(cBoxStates.SelectedIndex, 0);


            StatePage resultPage = new StatePage(states[ind]); //pass state from list with corressponding combobox choice
            resultPage.Show(); 
        }

        private void butSortPopAsc_Click(object sender, EventArgs e)
        {
            this.stateInfoTableAdapter.SortPopASC(this.stateInfoDataSet.StateInfo); //query to sort table by population ascending
        }

        private void butSortPopDesc_Click(object sender, EventArgs e)
        {
            this.stateInfoTableAdapter.SortPopDesc(this.stateInfoDataSet.StateInfo); //query to sort table by population descending
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.stateInfoTableAdapter.TopPop(this.stateInfoDataSet.StateInfo); //query to find highest pop
        }

        private void butLowPop_Click(object sender, EventArgs e)
        {
            this.stateInfoTableAdapter.LowPop(this.stateInfoDataSet.StateInfo); //query to find lowest pop
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            int minPop = 0;

            int.TryParse(txtBoxMin.Text, out minPop);
           //try to parse min population textbox to see if user entered criteria if not minimum populatin is 0


            try
            {
                this.stateInfoTableAdapter.Search(this.stateInfoDataSet.StateInfo, txtBoxName.Text, minPop.ToString(), txtBoxBird.Text, txtBoxCap.Text); //sql query to search for any of the four criteria, state name, minimum population, state bird, and state capital
            }
            catch (Exception ex)
            { 
                MessageBox.Show("ERROR: \n" + ex.Message);
            }
        }

        private void butExit_Click(object sender, EventArgs e)
        {
            MessageBox.Show("****** THANK YOU ******");
            this.Close();
        }
    }
}
