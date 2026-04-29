using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace NChapman_Miller_Final_Project_244
{
    public class Movie
    {
        public int Rank { get; set; }
        public string Title { get; set; }
        public int Year { get; set; }
        public double Rating { get; set; }
        public string Duration { get; set; }
        public string Genres { get; set; }
        public string Certificate { get; set; }
        public string Description { get; set; }
        public string IMBDUrl { get; set; }
        public string ImageUrl { get; set; }

        public Movie(int rank, string title, int year, double rating, string duration, string genres, string certificate, string description, string iMBDUrl, string imageUrl)
        {
            Rank = rank;
            Title = title;
            Year = year;
            Rating = rating;
            Duration = duration;
            Genres = genres;
            Certificate = certificate;
            Description = description;
            IMBDUrl = iMBDUrl;
            ImageUrl = imageUrl;

        }
    }
}
