using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NChapman_Miller_Final_Project_244
{
   
    public partial class Suggestion : Form
    {
        public Movie moviePick;
        public Suggestion(Movie suggestedMovie)
        {
            InitializeComponent();
            moviePick = suggestedMovie;
            string coverUrl = moviePick.ImageUrl;

            if (ValidateUrl(coverUrl))
            {
                pBoxMovie.LoadAsync(coverUrl);
            }
            else
            {
                MessageBox.Show("Movie cover image URL is invalid. Please check excel sheet.");
            }

            lblMovieTitle.Text = moviePick.Title;
            lblDescription.Text = moviePick.Description;
            lblRating.Text = "IMDB Rating: " +moviePick.Rating;
            lblCert.Text = "Age Rating: "+ moviePick.Certificate;
            lblDuration.Text = "Duration: "+moviePick.Duration;
            
        }

        public static bool ValidateUrl(string url)
        {
            var success = Uri.IsWellFormedUriString(url, UriKind.RelativeOrAbsolute);

            return success;
        }

        private void butIMDBLink_Click(object sender, EventArgs e)
        {
            if (ValidateUrl(moviePick.IMBDUrl))
            {
                System.Diagnostics.Process.Start(moviePick.IMBDUrl);
            }
            else
            {
                MessageBox.Show("Movie IMDB URL is invalid. Please check excel sheet.");
            }
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (ValidateUrl(moviePick.ImageUrl))
            {
                System.Diagnostics.Process.Start(moviePick.ImageUrl);
            }
            else
            {
                MessageBox.Show("Movie IMDB URL is invalid. Please check excel sheet.");
            }
        }
    }
}
