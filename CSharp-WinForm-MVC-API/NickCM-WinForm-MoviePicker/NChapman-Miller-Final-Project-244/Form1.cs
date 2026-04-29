using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;



namespace NChapman_Miller_Final_Project_244
{
    public partial class frmMain : Form
    {
        public List<Movie> allMovies;

       
        public frmMain()
        {
            InitializeComponent();

            string filePath = "imdb_top_movies.csv";

            allMovies = LoadMovies(filePath);

            FillGenres();
            FillCertificates();
            FillYears();
        }




        public static List<Movie> LoadMovies(string filePath)
        {
            List<Movie> movies = new List<Movie>();

            if (!File.Exists(filePath))
            {
                MessageBox.Show("ERROR: CSV FILE NOT FOUND!");
                return movies;
            }
            
            IEnumerable<string> lines = File.ReadLines(filePath).Skip(1);

            foreach (string line in lines)
            {
                string[] columns = line.Split(',');


                if (columns.Length < 9) { continue; }

                int rank = 0;
                int year = 0;
                double rating = 0.0;

                int.TryParse(columns[0].Trim(), out rank);
                int.TryParse(columns[2].Trim(), out year);
                double.TryParse(columns[3].Trim(), out rating);

                string[] genres = columns[6].Trim().Split('#').Select(g => g.Trim()).ToArray();
                string duration = columns[4].Trim();
                string certificate = columns[5].Trim();
                string description = columns[7].Trim();

                Movie movie = new Movie(rank, columns[1].Trim(), year, rating, duration, string.Join(", ", genres), certificate, description, columns[9].Trim(), columns[8].Trim());

             
                  
                

                movies.Add(movie);
            }
            return movies;
        }

        public List<Movie> FilterMovies(List<Movie> allMovies, double? minRating, double? maxRating, string selectedGenre, string selectedCert, string selectedYear)
        {
            List<Movie> filteredMovies = allMovies;

            //rating filter
            if (minRating.HasValue)
            {
                filteredMovies = filteredMovies.Where(movie => movie.Rating >= minRating.Value).ToList();
            }
            if (maxRating.HasValue)
            {
                filteredMovies = filteredMovies.Where(movie => movie.Rating <= maxRating.Value).ToList();
            }
            //genre filter
            if (!string.IsNullOrEmpty(selectedGenre) && selectedGenre != "All")
            {
                filteredMovies = filteredMovies.Where(movie => movie.Genres.Split(',').Any(genre => genre.Trim().Replace("\"", "").Equals(selectedGenre, StringComparison.OrdinalIgnoreCase))).ToList();
            }
            //age rating filter
            if (!string.IsNullOrEmpty(selectedCert) && selectedCert != "All")
            {
                filteredMovies = filteredMovies.Where(movie => movie.Certificate.Equals(selectedCert, StringComparison.OrdinalIgnoreCase)).ToList();
            }
            //year filter
            if (!string.IsNullOrEmpty(selectedYear) &&  selectedYear != "All")
            {
                filteredMovies = filteredMovies.Where(movie => movie.Year.ToString() == selectedYear).ToList();
            }


            return filteredMovies;
        }

        private void FillGenres()
        {
            List<string> genres = new List<string>();

            List<string> validGenres = new List<string>
            {
                "Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Drama", "Fantasy", "Horror", "Music", "Mystery", "Romance", "Sci-Fi", "Thriller", "War", "Western", "Family", "Film-Noir"
            };

            foreach (Movie movie in allMovies)
            {
               
                string[] movieGenres = movie.Genres.Split(',').Select(g => g.Trim().Replace("\"", "")).ToArray();

                foreach (string genre in movieGenres)
                {
                   
                    if (!genres.Contains(genre) && validGenres.Contains(genre))
                    {
                        genres.Add(genre);
                    }
                }
            }

          
            genres.Insert(0, "All");

         
            cBoxGenre.Items.Clear();
            cBoxGenre.Items.AddRange(genres.ToArray());
            cBoxGenre.SelectedIndex = 0;
        }

        private void butFilter_Click(object sender, EventArgs e)
        {
            string selectedGenre = cBoxGenre.SelectedItem.ToString();
            string selectedCertificate = cBoxCert.SelectedItem.ToString();
            string selectedYear = cBoxYear.SelectedItem.ToString();
            double minRating = 0.0;
            double maxRating = 0.0;

            if(!string.IsNullOrEmpty(txtBoxRating.Text))
            {
                double.TryParse(txtBoxRating.Text, out minRating);
            }
            if (!string.IsNullOrEmpty(txtBoxMax.Text))
            {
                double.TryParse(txtBoxMax.Text, out maxRating);
            }

            List<Movie> filteredMovies = FilterMovies(allMovies, minRating, maxRating, selectedGenre, selectedCertificate, selectedYear);

            DisplayFilterResults(filteredMovies);

        }

        private void FillCertificates()
        {
            List<string> certificates = allMovies.Select(movie => movie.Certificate).Where(cert => !string.IsNullOrEmpty(cert)&& !cert.Contains("h")&& !cert.Contains("m")).Distinct().OrderBy(c => c).ToList();
            certificates.Insert(0, "All");
            cBoxCert.Items.Clear();
            cBoxCert.Items.AddRange(certificates.ToArray());
            cBoxCert.SelectedIndex = 0;
        }

        private void FillYears()
        {
            List<int> years = allMovies.Select(movie => movie.Year).Distinct().OrderBy(y => y).ToList();

            cBoxYear.Items.Clear();
            cBoxYear.Items.Add("All");
            cBoxYear.Items.AddRange(years.Cast<object>().ToArray());
            cBoxYear.SelectedIndex = 0;
        }

        private void DisplayFilterResults(List<Movie> filteredMovies)
        {
            lstBoxResults.Visible = true;
            lstBoxResults.Items.Clear();
            foreach(Movie movie in filteredMovies)
            {
                lstBoxResults.Items.Add(movie.Title.Replace("\"", ""));
            }
        }

        private void butSuggest_Click(object sender, EventArgs e)
        {
            string selectedGenre = cBoxGenre.SelectedItem.ToString();
            string selectedCertificate = cBoxCert.SelectedItem.ToString();
            string selectedYear = cBoxYear.SelectedItem.ToString();
            double minRating = 0.0;
            double maxRating = 10;

            if (!string.IsNullOrEmpty(txtBoxRating.Text))
            {
                double.TryParse(txtBoxRating.Text, out minRating);
            }
            if (!string.IsNullOrEmpty(txtBoxMax.Text))
            {
                double.TryParse(txtBoxMax.Text, out maxRating);
            }

            List<Movie> filteredMovies = FilterMovies(allMovies, minRating, maxRating, selectedGenre, selectedCertificate, selectedYear);

            Random rng = new Random();
            int movieNum = rng.Next(0, filteredMovies.Count-1);

            Suggestion result = new Suggestion(filteredMovies[movieNum]);
            result.ShowDialog();
        }
    }
}
