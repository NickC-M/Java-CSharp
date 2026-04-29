namespace NChapman_Miller_Final_Project_244
{
    partial class Suggestion
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.pBoxMovie = new System.Windows.Forms.PictureBox();
            this.lblMovieTitle = new System.Windows.Forms.Label();
            this.lblDescription = new System.Windows.Forms.Label();
            this.lblRating = new System.Windows.Forms.Label();
            this.lblCert = new System.Windows.Forms.Label();
            this.lblDuration = new System.Windows.Forms.Label();
            this.butIMDBLink = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.pBoxMovie)).BeginInit();
            this.SuspendLayout();
            // 
            // pBoxMovie
            // 
            this.pBoxMovie.Location = new System.Drawing.Point(255, 12);
            this.pBoxMovie.Name = "pBoxMovie";
            this.pBoxMovie.Size = new System.Drawing.Size(243, 303);
            this.pBoxMovie.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pBoxMovie.TabIndex = 0;
            this.pBoxMovie.TabStop = false;
            // 
            // lblMovieTitle
            // 
            this.lblMovieTitle.AutoSize = true;
            this.lblMovieTitle.Font = new System.Drawing.Font("Maiandra GD", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblMovieTitle.ForeColor = System.Drawing.Color.White;
            this.lblMovieTitle.Location = new System.Drawing.Point(306, 328);
            this.lblMovieTitle.Name = "lblMovieTitle";
            this.lblMovieTitle.Size = new System.Drawing.Size(128, 25);
            this.lblMovieTitle.TabIndex = 1;
            this.lblMovieTitle.Text = "Movie Title";
            // 
            // lblDescription
            // 
            this.lblDescription.Font = new System.Drawing.Font("Maiandra GD", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblDescription.ForeColor = System.Drawing.Color.White;
            this.lblDescription.Location = new System.Drawing.Point(12, 353);
            this.lblDescription.Name = "lblDescription";
            this.lblDescription.Size = new System.Drawing.Size(776, 76);
            this.lblDescription.TabIndex = 2;
            this.lblDescription.Text = "Description";
            this.lblDescription.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // lblRating
            // 
            this.lblRating.AutoSize = true;
            this.lblRating.Font = new System.Drawing.Font("Maiandra GD", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblRating.ForeColor = System.Drawing.Color.White;
            this.lblRating.Location = new System.Drawing.Point(230, 444);
            this.lblRating.Name = "lblRating";
            this.lblRating.Size = new System.Drawing.Size(122, 19);
            this.lblRating.TabIndex = 3;
            this.lblRating.Text = "IMDB Rating: ";
            // 
            // lblCert
            // 
            this.lblCert.AutoSize = true;
            this.lblCert.Font = new System.Drawing.Font("Maiandra GD", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblCert.ForeColor = System.Drawing.Color.White;
            this.lblCert.Location = new System.Drawing.Point(390, 444);
            this.lblCert.Name = "lblCert";
            this.lblCert.Size = new System.Drawing.Size(113, 19);
            this.lblCert.TabIndex = 4;
            this.lblCert.Text = "Age Rating:  ";
            // 
            // lblDuration
            // 
            this.lblDuration.AutoSize = true;
            this.lblDuration.Font = new System.Drawing.Font("Maiandra GD", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblDuration.ForeColor = System.Drawing.Color.White;
            this.lblDuration.Location = new System.Drawing.Point(266, 476);
            this.lblDuration.Name = "lblDuration";
            this.lblDuration.Size = new System.Drawing.Size(104, 19);
            this.lblDuration.TabIndex = 5;
            this.lblDuration.Text = "Duration:   ";
            // 
            // butIMDBLink
            // 
            this.butIMDBLink.Location = new System.Drawing.Point(622, 71);
            this.butIMDBLink.Name = "butIMDBLink";
            this.butIMDBLink.Size = new System.Drawing.Size(79, 40);
            this.butIMDBLink.TabIndex = 6;
            this.butIMDBLink.Text = "&Go to IMDB page";
            this.butIMDBLink.UseVisualStyleBackColor = true;
            this.butIMDBLink.Click += new System.EventHandler(this.butIMDBLink_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(640, 264);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(79, 40);
            this.button1.TabIndex = 7;
            this.button1.Text = "&Go to IMDB page";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Suggestion
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.DarkRed;
            this.ClientSize = new System.Drawing.Size(800, 516);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.butIMDBLink);
            this.Controls.Add(this.lblDuration);
            this.Controls.Add(this.lblCert);
            this.Controls.Add(this.lblRating);
            this.Controls.Add(this.lblDescription);
            this.Controls.Add(this.lblMovieTitle);
            this.Controls.Add(this.pBoxMovie);
            this.Name = "Suggestion";
            this.Text = "Suggestion";
            ((System.ComponentModel.ISupportInitialize)(this.pBoxMovie)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox pBoxMovie;
        private System.Windows.Forms.Label lblMovieTitle;
        private System.Windows.Forms.Label lblDescription;
        private System.Windows.Forms.Label lblRating;
        private System.Windows.Forms.Label lblCert;
        private System.Windows.Forms.Label lblDuration;
        private System.Windows.Forms.Button butIMDBLink;
        private System.Windows.Forms.Button button1;
    }
}