namespace NChapman_Miller_Final_Project_244
{
    partial class frmMain
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
            this.butFilter = new System.Windows.Forms.Button();
            this.cBoxGenre = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.txtBoxRating = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.cBoxCert = new System.Windows.Forms.ComboBox();
            this.lblCert = new System.Windows.Forms.Label();
            this.cBoxYear = new System.Windows.Forms.ComboBox();
            this.lblYear = new System.Windows.Forms.Label();
            this.lstBoxResults = new System.Windows.Forms.ListBox();
            this.lblMax = new System.Windows.Forms.Label();
            this.txtBoxMax = new System.Windows.Forms.TextBox();
            this.butSuggest = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // butFilter
            // 
            this.butFilter.Location = new System.Drawing.Point(41, 251);
            this.butFilter.Name = "butFilter";
            this.butFilter.Size = new System.Drawing.Size(117, 39);
            this.butFilter.TabIndex = 0;
            this.butFilter.Text = "&Filter all movies and show Results";
            this.butFilter.UseVisualStyleBackColor = true;
            this.butFilter.Click += new System.EventHandler(this.butFilter_Click);
            // 
            // cBoxGenre
            // 
            this.cBoxGenre.FormattingEnabled = true;
            this.cBoxGenre.Location = new System.Drawing.Point(53, 70);
            this.cBoxGenre.Name = "cBoxGenre";
            this.cBoxGenre.Size = new System.Drawing.Size(105, 21);
            this.cBoxGenre.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 73);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(39, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "Genre:";
            // 
            // txtBoxRating
            // 
            this.txtBoxRating.Location = new System.Drawing.Point(103, 99);
            this.txtBoxRating.Name = "txtBoxRating";
            this.txtBoxRating.Size = new System.Drawing.Size(101, 20);
            this.txtBoxRating.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 102);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(85, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "Minimum Rating:";
            // 
            // cBoxCert
            // 
            this.cBoxCert.FormattingEnabled = true;
            this.cBoxCert.Location = new System.Drawing.Point(81, 146);
            this.cBoxCert.Name = "cBoxCert";
            this.cBoxCert.Size = new System.Drawing.Size(105, 21);
            this.cBoxCert.TabIndex = 5;
            // 
            // lblCert
            // 
            this.lblCert.AutoSize = true;
            this.lblCert.Location = new System.Drawing.Point(12, 149);
            this.lblCert.Name = "lblCert";
            this.lblCert.Size = new System.Drawing.Size(63, 13);
            this.lblCert.TabIndex = 6;
            this.lblCert.Text = "Age Rating:";
            // 
            // cBoxYear
            // 
            this.cBoxYear.FormattingEnabled = true;
            this.cBoxYear.Location = new System.Drawing.Point(53, 173);
            this.cBoxYear.Name = "cBoxYear";
            this.cBoxYear.Size = new System.Drawing.Size(105, 21);
            this.cBoxYear.TabIndex = 7;
            // 
            // lblYear
            // 
            this.lblYear.AutoSize = true;
            this.lblYear.Location = new System.Drawing.Point(12, 176);
            this.lblYear.Name = "lblYear";
            this.lblYear.Size = new System.Drawing.Size(32, 13);
            this.lblYear.TabIndex = 8;
            this.lblYear.Text = "Year:";
            // 
            // lstBoxResults
            // 
            this.lstBoxResults.FormattingEnabled = true;
            this.lstBoxResults.Location = new System.Drawing.Point(249, 23);
            this.lstBoxResults.Name = "lstBoxResults";
            this.lstBoxResults.Size = new System.Drawing.Size(299, 316);
            this.lstBoxResults.TabIndex = 9;
            this.lstBoxResults.Visible = false;
            // 
            // lblMax
            // 
            this.lblMax.AutoSize = true;
            this.lblMax.Location = new System.Drawing.Point(12, 128);
            this.lblMax.Name = "lblMax";
            this.lblMax.Size = new System.Drawing.Size(64, 13);
            this.lblMax.TabIndex = 11;
            this.lblMax.Text = "Max Rating:";
            // 
            // txtBoxMax
            // 
            this.txtBoxMax.Location = new System.Drawing.Point(103, 125);
            this.txtBoxMax.Name = "txtBoxMax";
            this.txtBoxMax.Size = new System.Drawing.Size(101, 20);
            this.txtBoxMax.TabIndex = 10;
            // 
            // butSuggest
            // 
            this.butSuggest.Location = new System.Drawing.Point(41, 310);
            this.butSuggest.Name = "butSuggest";
            this.butSuggest.Size = new System.Drawing.Size(117, 39);
            this.butSuggest.TabIndex = 12;
            this.butSuggest.Text = "&Suggest Movie";
            this.butSuggest.UseVisualStyleBackColor = true;
            this.butSuggest.Click += new System.EventHandler(this.butSuggest_Click);
            // 
            // frmMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(250)))), ((int)(((byte)(227)))), ((int)(((byte)(255)))));
            this.ClientSize = new System.Drawing.Size(589, 389);
            this.Controls.Add(this.butSuggest);
            this.Controls.Add(this.lblMax);
            this.Controls.Add(this.txtBoxMax);
            this.Controls.Add(this.lstBoxResults);
            this.Controls.Add(this.lblYear);
            this.Controls.Add(this.cBoxYear);
            this.Controls.Add(this.lblCert);
            this.Controls.Add(this.cBoxCert);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtBoxRating);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.cBoxGenre);
            this.Controls.Add(this.butFilter);
            this.Name = "frmMain";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Chapman-Miller Movie Suggester";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button butFilter;
        private System.Windows.Forms.ComboBox cBoxGenre;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtBoxRating;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox cBoxCert;
        private System.Windows.Forms.Label lblCert;
        private System.Windows.Forms.ComboBox cBoxYear;
        private System.Windows.Forms.Label lblYear;
        private System.Windows.Forms.ListBox lstBoxResults;
        private System.Windows.Forms.Label lblMax;
        private System.Windows.Forms.TextBox txtBoxMax;
        private System.Windows.Forms.Button butSuggest;
    }
}

