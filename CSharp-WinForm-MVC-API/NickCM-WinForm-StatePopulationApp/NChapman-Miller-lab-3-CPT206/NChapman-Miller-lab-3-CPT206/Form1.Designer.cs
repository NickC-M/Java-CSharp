namespace NChapman_Miller_lab_3_CPT206
{
    partial class Form1
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
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.stateInfoBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorCountItem = new System.Windows.Forms.ToolStripLabel();
            this.bindingNavigatorDeleteItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveFirstItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMovePreviousItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorPositionItem = new System.Windows.Forms.ToolStripTextBox();
            this.bindingNavigatorSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorMoveNextItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveLastItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.stateInfoBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.lblName = new System.Windows.Forms.Label();
            this.butInsertData = new System.Windows.Forms.Button();
            this.stateInfoDataGridView = new System.Windows.Forms.DataGridView();
            this.butStagePage = new System.Windows.Forms.Button();
            this.cBoxStates = new System.Windows.Forms.ComboBox();
            this.txtBoxName = new System.Windows.Forms.TextBox();
            this.butSortPopAsc = new System.Windows.Forms.Button();
            this.butSortPopDesc = new System.Windows.Forms.Button();
            this.butHighPop = new System.Windows.Forms.Button();
            this.butLowPop = new System.Windows.Forms.Button();
            this.txtBoxBird = new System.Windows.Forms.TextBox();
            this.lblBirds = new System.Windows.Forms.Label();
            this.txtBoxMin = new System.Windows.Forms.TextBox();
            this.lblMin = new System.Windows.Forms.Label();
            this.txtBoxCap = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.butSearch = new System.Windows.Forms.Button();
            this.dataGridViewTextBoxColumn1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn5 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn6 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn7 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn8 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn9 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn10 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn11 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn12 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn13 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn14 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.stateInfoBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.stateInfoDataSet = new NChapman_Miller_lab_3_CPT206.StateInfoDataSet();
            this.stateInfoTableAdapter = new NChapman_Miller_lab_3_CPT206.StateInfoDataSetTableAdapters.StateInfoTableAdapter();
            this.tableAdapterManager = new NChapman_Miller_lab_3_CPT206.StateInfoDataSetTableAdapters.TableAdapterManager();
            this.butExit = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.stateInfoBindingNavigator)).BeginInit();
            this.stateInfoBindingNavigator.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.stateInfoDataGridView)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.stateInfoBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.stateInfoDataSet)).BeginInit();
            this.SuspendLayout();
            // 
            // stateInfoBindingNavigator
            // 
            this.stateInfoBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.stateInfoBindingNavigator.BindingSource = this.stateInfoBindingSource;
            this.stateInfoBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.stateInfoBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.stateInfoBindingNavigator.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.stateInfoBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.bindingNavigatorMoveFirstItem,
            this.bindingNavigatorMovePreviousItem,
            this.bindingNavigatorSeparator,
            this.bindingNavigatorPositionItem,
            this.bindingNavigatorCountItem,
            this.bindingNavigatorSeparator1,
            this.bindingNavigatorMoveNextItem,
            this.bindingNavigatorMoveLastItem,
            this.bindingNavigatorSeparator2,
            this.bindingNavigatorAddNewItem,
            this.bindingNavigatorDeleteItem,
            this.stateInfoBindingNavigatorSaveItem});
            this.stateInfoBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.stateInfoBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.stateInfoBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.stateInfoBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.stateInfoBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.stateInfoBindingNavigator.Name = "stateInfoBindingNavigator";
            this.stateInfoBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.stateInfoBindingNavigator.Size = new System.Drawing.Size(1156, 27);
            this.stateInfoBindingNavigator.TabIndex = 0;
            this.stateInfoBindingNavigator.Text = "bindingNavigator1";
            // 
            // bindingNavigatorAddNewItem
            // 
            this.bindingNavigatorAddNewItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorAddNewItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorAddNewItem.Image")));
            this.bindingNavigatorAddNewItem.Name = "bindingNavigatorAddNewItem";
            this.bindingNavigatorAddNewItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorAddNewItem.Size = new System.Drawing.Size(29, 24);
            this.bindingNavigatorAddNewItem.Text = "Add new";
            // 
            // bindingNavigatorCountItem
            // 
            this.bindingNavigatorCountItem.Name = "bindingNavigatorCountItem";
            this.bindingNavigatorCountItem.Size = new System.Drawing.Size(45, 24);
            this.bindingNavigatorCountItem.Text = "of {0}";
            this.bindingNavigatorCountItem.ToolTipText = "Total number of items";
            // 
            // bindingNavigatorDeleteItem
            // 
            this.bindingNavigatorDeleteItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorDeleteItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorDeleteItem.Image")));
            this.bindingNavigatorDeleteItem.Name = "bindingNavigatorDeleteItem";
            this.bindingNavigatorDeleteItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorDeleteItem.Size = new System.Drawing.Size(29, 24);
            this.bindingNavigatorDeleteItem.Text = "Delete";
            // 
            // bindingNavigatorMoveFirstItem
            // 
            this.bindingNavigatorMoveFirstItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveFirstItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveFirstItem.Image")));
            this.bindingNavigatorMoveFirstItem.Name = "bindingNavigatorMoveFirstItem";
            this.bindingNavigatorMoveFirstItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveFirstItem.Size = new System.Drawing.Size(29, 24);
            this.bindingNavigatorMoveFirstItem.Text = "Move first";
            // 
            // bindingNavigatorMovePreviousItem
            // 
            this.bindingNavigatorMovePreviousItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMovePreviousItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMovePreviousItem.Image")));
            this.bindingNavigatorMovePreviousItem.Name = "bindingNavigatorMovePreviousItem";
            this.bindingNavigatorMovePreviousItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMovePreviousItem.Size = new System.Drawing.Size(29, 24);
            this.bindingNavigatorMovePreviousItem.Text = "Move previous";
            // 
            // bindingNavigatorSeparator
            // 
            this.bindingNavigatorSeparator.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator.Size = new System.Drawing.Size(6, 27);
            // 
            // bindingNavigatorPositionItem
            // 
            this.bindingNavigatorPositionItem.AccessibleName = "Position";
            this.bindingNavigatorPositionItem.AutoSize = false;
            this.bindingNavigatorPositionItem.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.bindingNavigatorPositionItem.Name = "bindingNavigatorPositionItem";
            this.bindingNavigatorPositionItem.Size = new System.Drawing.Size(65, 27);
            this.bindingNavigatorPositionItem.Text = "0";
            this.bindingNavigatorPositionItem.ToolTipText = "Current position";
            // 
            // bindingNavigatorSeparator1
            // 
            this.bindingNavigatorSeparator1.Name = "bindingNavigatorSeparator1";
            this.bindingNavigatorSeparator1.Size = new System.Drawing.Size(6, 27);
            // 
            // bindingNavigatorMoveNextItem
            // 
            this.bindingNavigatorMoveNextItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveNextItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveNextItem.Image")));
            this.bindingNavigatorMoveNextItem.Name = "bindingNavigatorMoveNextItem";
            this.bindingNavigatorMoveNextItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveNextItem.Size = new System.Drawing.Size(29, 24);
            this.bindingNavigatorMoveNextItem.Text = "Move next";
            // 
            // bindingNavigatorMoveLastItem
            // 
            this.bindingNavigatorMoveLastItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveLastItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveLastItem.Image")));
            this.bindingNavigatorMoveLastItem.Name = "bindingNavigatorMoveLastItem";
            this.bindingNavigatorMoveLastItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveLastItem.Size = new System.Drawing.Size(29, 24);
            this.bindingNavigatorMoveLastItem.Text = "Move last";
            // 
            // bindingNavigatorSeparator2
            // 
            this.bindingNavigatorSeparator2.Name = "bindingNavigatorSeparator2";
            this.bindingNavigatorSeparator2.Size = new System.Drawing.Size(6, 27);
            // 
            // stateInfoBindingNavigatorSaveItem
            // 
            this.stateInfoBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.stateInfoBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("stateInfoBindingNavigatorSaveItem.Image")));
            this.stateInfoBindingNavigatorSaveItem.Name = "stateInfoBindingNavigatorSaveItem";
            this.stateInfoBindingNavigatorSaveItem.Size = new System.Drawing.Size(29, 24);
            this.stateInfoBindingNavigatorSaveItem.Text = "Save Data";
            this.stateInfoBindingNavigatorSaveItem.Click += new System.EventHandler(this.stateInfoBindingNavigatorSaveItem_Click);
            // 
            // lblName
            // 
            this.lblName.AutoSize = true;
            this.lblName.Location = new System.Drawing.Point(741, 376);
            this.lblName.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblName.Name = "lblName";
            this.lblName.Size = new System.Drawing.Size(47, 16);
            this.lblName.TabIndex = 2;
            this.lblName.Text = "Name:";
            // 
            // butInsertData
            // 
            this.butInsertData.Location = new System.Drawing.Point(40, 362);
            this.butInsertData.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.butInsertData.Name = "butInsertData";
            this.butInsertData.Size = new System.Drawing.Size(163, 64);
            this.butInsertData.TabIndex = 3;
            this.butInsertData.Text = "&Insert Data";
            this.butInsertData.UseVisualStyleBackColor = true;
            this.butInsertData.Click += new System.EventHandler(this.butInsertData_Click);
            // 
            // stateInfoDataGridView
            // 
            this.stateInfoDataGridView.AutoGenerateColumns = false;
            this.stateInfoDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.stateInfoDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn1,
            this.dataGridViewTextBoxColumn2,
            this.dataGridViewTextBoxColumn3,
            this.dataGridViewTextBoxColumn4,
            this.dataGridViewTextBoxColumn5,
            this.dataGridViewTextBoxColumn6,
            this.dataGridViewTextBoxColumn7,
            this.dataGridViewTextBoxColumn8,
            this.dataGridViewTextBoxColumn9,
            this.dataGridViewTextBoxColumn10,
            this.dataGridViewTextBoxColumn11,
            this.dataGridViewTextBoxColumn12,
            this.dataGridViewTextBoxColumn13,
            this.dataGridViewTextBoxColumn14});
            this.stateInfoDataGridView.DataSource = this.stateInfoBindingSource;
            this.stateInfoDataGridView.Location = new System.Drawing.Point(40, 47);
            this.stateInfoDataGridView.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.stateInfoDataGridView.Name = "stateInfoDataGridView";
            this.stateInfoDataGridView.RowHeadersWidth = 51;
            this.stateInfoDataGridView.Size = new System.Drawing.Size(1069, 286);
            this.stateInfoDataGridView.TabIndex = 3;
            // 
            // butStagePage
            // 
            this.butStagePage.Enabled = false;
            this.butStagePage.Location = new System.Drawing.Point(230, 462);
            this.butStagePage.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.butStagePage.Name = "butStagePage";
            this.butStagePage.Size = new System.Drawing.Size(133, 44);
            this.butStagePage.TabIndex = 4;
            this.butStagePage.Text = "&Show State Page";
            this.butStagePage.UseVisualStyleBackColor = true;
            this.butStagePage.Click += new System.EventHandler(this.butStagePage_Click);
            // 
            // cBoxStates
            // 
            this.cBoxStates.FormattingEnabled = true;
            this.cBoxStates.Location = new System.Drawing.Point(40, 473);
            this.cBoxStates.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.cBoxStates.Name = "cBoxStates";
            this.cBoxStates.Size = new System.Drawing.Size(160, 24);
            this.cBoxStates.TabIndex = 5;
            // 
            // txtBoxName
            // 
            this.txtBoxName.Location = new System.Drawing.Point(812, 371);
            this.txtBoxName.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtBoxName.Name = "txtBoxName";
            this.txtBoxName.Size = new System.Drawing.Size(93, 22);
            this.txtBoxName.TabIndex = 6;
            // 
            // butSortPopAsc
            // 
            this.butSortPopAsc.Enabled = false;
            this.butSortPopAsc.Location = new System.Drawing.Point(540, 362);
            this.butSortPopAsc.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.butSortPopAsc.Name = "butSortPopAsc";
            this.butSortPopAsc.Size = new System.Drawing.Size(133, 44);
            this.butSortPopAsc.TabIndex = 7;
            this.butSortPopAsc.Text = "Sort by Pop &ASC";
            this.butSortPopAsc.UseVisualStyleBackColor = true;
            this.butSortPopAsc.Click += new System.EventHandler(this.butSortPopAsc_Click);
            // 
            // butSortPopDesc
            // 
            this.butSortPopDesc.Enabled = false;
            this.butSortPopDesc.Location = new System.Drawing.Point(540, 417);
            this.butSortPopDesc.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.butSortPopDesc.Name = "butSortPopDesc";
            this.butSortPopDesc.Size = new System.Drawing.Size(133, 44);
            this.butSortPopDesc.TabIndex = 8;
            this.butSortPopDesc.Text = "Sort by Pop &DESC";
            this.butSortPopDesc.UseVisualStyleBackColor = true;
            this.butSortPopDesc.Click += new System.EventHandler(this.butSortPopDesc_Click);
            // 
            // butHighPop
            // 
            this.butHighPop.Enabled = false;
            this.butHighPop.Location = new System.Drawing.Point(398, 362);
            this.butHighPop.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.butHighPop.Name = "butHighPop";
            this.butHighPop.Size = new System.Drawing.Size(133, 44);
            this.butHighPop.TabIndex = 9;
            this.butHighPop.Text = "&Highest Pop";
            this.butHighPop.UseVisualStyleBackColor = true;
            this.butHighPop.Click += new System.EventHandler(this.button1_Click);
            // 
            // butLowPop
            // 
            this.butLowPop.Enabled = false;
            this.butLowPop.Location = new System.Drawing.Point(398, 417);
            this.butLowPop.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.butLowPop.Name = "butLowPop";
            this.butLowPop.Size = new System.Drawing.Size(133, 44);
            this.butLowPop.TabIndex = 10;
            this.butLowPop.Text = "&Lowest Pop";
            this.butLowPop.UseVisualStyleBackColor = true;
            this.butLowPop.Click += new System.EventHandler(this.butLowPop_Click);
            // 
            // txtBoxBird
            // 
            this.txtBoxBird.Location = new System.Drawing.Point(812, 429);
            this.txtBoxBird.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtBoxBird.Name = "txtBoxBird";
            this.txtBoxBird.Size = new System.Drawing.Size(93, 22);
            this.txtBoxBird.TabIndex = 12;
            // 
            // lblBirds
            // 
            this.lblBirds.AutoSize = true;
            this.lblBirds.Location = new System.Drawing.Point(741, 432);
            this.lblBirds.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblBirds.Name = "lblBirds";
            this.lblBirds.Size = new System.Drawing.Size(34, 16);
            this.lblBirds.TabIndex = 11;
            this.lblBirds.Text = "Bird:";
            // 
            // txtBoxMin
            // 
            this.txtBoxMin.Location = new System.Drawing.Point(989, 371);
            this.txtBoxMin.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtBoxMin.Name = "txtBoxMin";
            this.txtBoxMin.Size = new System.Drawing.Size(93, 22);
            this.txtBoxMin.TabIndex = 14;
            // 
            // lblMin
            // 
            this.lblMin.AutoSize = true;
            this.lblMin.Location = new System.Drawing.Point(919, 375);
            this.lblMin.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblMin.Name = "lblMin";
            this.lblMin.Size = new System.Drawing.Size(59, 16);
            this.lblMin.TabIndex = 13;
            this.lblMin.Text = "Min Pop:";
            // 
            // txtBoxCap
            // 
            this.txtBoxCap.Location = new System.Drawing.Point(989, 429);
            this.txtBoxCap.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtBoxCap.Name = "txtBoxCap";
            this.txtBoxCap.Size = new System.Drawing.Size(93, 22);
            this.txtBoxCap.TabIndex = 16;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(919, 432);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(55, 16);
            this.label3.TabIndex = 15;
            this.label3.Text = "Capital: ";
            // 
            // butSearch
            // 
            this.butSearch.Enabled = false;
            this.butSearch.Location = new System.Drawing.Point(855, 489);
            this.butSearch.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.butSearch.Name = "butSearch";
            this.butSearch.Size = new System.Drawing.Size(133, 44);
            this.butSearch.TabIndex = 17;
            this.butSearch.TabStop = false;
            this.butSearch.Text = "&Search";
            this.butSearch.UseVisualStyleBackColor = true;
            this.butSearch.Click += new System.EventHandler(this.button1_Click_1);
            // 
            // dataGridViewTextBoxColumn1
            // 
            this.dataGridViewTextBoxColumn1.DataPropertyName = "ID";
            this.dataGridViewTextBoxColumn1.HeaderText = "ID";
            this.dataGridViewTextBoxColumn1.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn1.Name = "dataGridViewTextBoxColumn1";
            this.dataGridViewTextBoxColumn1.ReadOnly = true;
            this.dataGridViewTextBoxColumn1.Width = 125;
            // 
            // dataGridViewTextBoxColumn2
            // 
            this.dataGridViewTextBoxColumn2.DataPropertyName = "Name";
            this.dataGridViewTextBoxColumn2.HeaderText = "Name";
            this.dataGridViewTextBoxColumn2.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn2.Name = "dataGridViewTextBoxColumn2";
            this.dataGridViewTextBoxColumn2.Width = 125;
            // 
            // dataGridViewTextBoxColumn3
            // 
            this.dataGridViewTextBoxColumn3.DataPropertyName = "Population";
            this.dataGridViewTextBoxColumn3.HeaderText = "Population";
            this.dataGridViewTextBoxColumn3.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn3.Name = "dataGridViewTextBoxColumn3";
            this.dataGridViewTextBoxColumn3.Width = 125;
            // 
            // dataGridViewTextBoxColumn4
            // 
            this.dataGridViewTextBoxColumn4.DataPropertyName = "FlagDescription";
            this.dataGridViewTextBoxColumn4.HeaderText = "FlagDescription";
            this.dataGridViewTextBoxColumn4.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn4.Name = "dataGridViewTextBoxColumn4";
            this.dataGridViewTextBoxColumn4.Width = 125;
            // 
            // dataGridViewTextBoxColumn5
            // 
            this.dataGridViewTextBoxColumn5.DataPropertyName = "FlagURL";
            this.dataGridViewTextBoxColumn5.HeaderText = "FlagURL";
            this.dataGridViewTextBoxColumn5.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn5.Name = "dataGridViewTextBoxColumn5";
            this.dataGridViewTextBoxColumn5.Width = 125;
            // 
            // dataGridViewTextBoxColumn6
            // 
            this.dataGridViewTextBoxColumn6.DataPropertyName = "Flower";
            this.dataGridViewTextBoxColumn6.HeaderText = "Flower";
            this.dataGridViewTextBoxColumn6.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn6.Name = "dataGridViewTextBoxColumn6";
            this.dataGridViewTextBoxColumn6.Width = 125;
            // 
            // dataGridViewTextBoxColumn7
            // 
            this.dataGridViewTextBoxColumn7.DataPropertyName = "Bird";
            this.dataGridViewTextBoxColumn7.HeaderText = "Bird";
            this.dataGridViewTextBoxColumn7.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn7.Name = "dataGridViewTextBoxColumn7";
            this.dataGridViewTextBoxColumn7.Width = 125;
            // 
            // dataGridViewTextBoxColumn8
            // 
            this.dataGridViewTextBoxColumn8.DataPropertyName = "Colors";
            this.dataGridViewTextBoxColumn8.HeaderText = "Colors";
            this.dataGridViewTextBoxColumn8.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn8.Name = "dataGridViewTextBoxColumn8";
            this.dataGridViewTextBoxColumn8.Width = 125;
            // 
            // dataGridViewTextBoxColumn9
            // 
            this.dataGridViewTextBoxColumn9.DataPropertyName = "LargestCity";
            this.dataGridViewTextBoxColumn9.HeaderText = "LargestCity";
            this.dataGridViewTextBoxColumn9.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn9.Name = "dataGridViewTextBoxColumn9";
            this.dataGridViewTextBoxColumn9.Width = 125;
            // 
            // dataGridViewTextBoxColumn10
            // 
            this.dataGridViewTextBoxColumn10.DataPropertyName = "SecondLargestCity";
            this.dataGridViewTextBoxColumn10.HeaderText = "SecondLargestCity";
            this.dataGridViewTextBoxColumn10.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn10.Name = "dataGridViewTextBoxColumn10";
            this.dataGridViewTextBoxColumn10.Width = 125;
            // 
            // dataGridViewTextBoxColumn11
            // 
            this.dataGridViewTextBoxColumn11.DataPropertyName = "ThirdLargestCity";
            this.dataGridViewTextBoxColumn11.HeaderText = "ThirdLargestCity";
            this.dataGridViewTextBoxColumn11.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn11.Name = "dataGridViewTextBoxColumn11";
            this.dataGridViewTextBoxColumn11.Width = 125;
            // 
            // dataGridViewTextBoxColumn12
            // 
            this.dataGridViewTextBoxColumn12.DataPropertyName = "Capital";
            this.dataGridViewTextBoxColumn12.HeaderText = "Capital";
            this.dataGridViewTextBoxColumn12.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn12.Name = "dataGridViewTextBoxColumn12";
            this.dataGridViewTextBoxColumn12.Width = 125;
            // 
            // dataGridViewTextBoxColumn13
            // 
            this.dataGridViewTextBoxColumn13.DataPropertyName = "MedianHouseholdIncome";
            this.dataGridViewTextBoxColumn13.HeaderText = "MedianHouseholdIncome";
            this.dataGridViewTextBoxColumn13.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn13.Name = "dataGridViewTextBoxColumn13";
            this.dataGridViewTextBoxColumn13.Width = 125;
            // 
            // dataGridViewTextBoxColumn14
            // 
            this.dataGridViewTextBoxColumn14.DataPropertyName = "PercentofComputerJobs";
            this.dataGridViewTextBoxColumn14.HeaderText = "PercentofComputerJobs";
            this.dataGridViewTextBoxColumn14.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn14.Name = "dataGridViewTextBoxColumn14";
            this.dataGridViewTextBoxColumn14.Width = 125;
            // 
            // stateInfoBindingSource
            // 
            this.stateInfoBindingSource.DataMember = "StateInfo";
            this.stateInfoBindingSource.DataSource = this.stateInfoDataSet;
            // 
            // stateInfoDataSet
            // 
            this.stateInfoDataSet.DataSetName = "StateInfoDataSet";
            this.stateInfoDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // stateInfoTableAdapter
            // 
            this.stateInfoTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.Connection = null;
            this.tableAdapterManager.StateInfoTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = NChapman_Miller_lab_3_CPT206.StateInfoDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // butExit
            // 
            this.butExit.Location = new System.Drawing.Point(472, 480);
            this.butExit.Margin = new System.Windows.Forms.Padding(4);
            this.butExit.Name = "butExit";
            this.butExit.Size = new System.Drawing.Size(133, 44);
            this.butExit.TabIndex = 18;
            this.butExit.Text = "&Exit";
            this.butExit.UseVisualStyleBackColor = true;
            this.butExit.Click += new System.EventHandler(this.butExit_Click);
            // 
            // Form1
            // 
            this.AcceptButton = this.butSearch;
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(234)))), ((int)(((byte)(249)))), ((int)(((byte)(232)))));
            this.CancelButton = this.butExit;
            this.ClientSize = new System.Drawing.Size(1156, 544);
            this.Controls.Add(this.butExit);
            this.Controls.Add(this.butSearch);
            this.Controls.Add(this.txtBoxCap);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.txtBoxMin);
            this.Controls.Add(this.lblMin);
            this.Controls.Add(this.txtBoxBird);
            this.Controls.Add(this.lblBirds);
            this.Controls.Add(this.butLowPop);
            this.Controls.Add(this.butHighPop);
            this.Controls.Add(this.butSortPopDesc);
            this.Controls.Add(this.butSortPopAsc);
            this.Controls.Add(this.txtBoxName);
            this.Controls.Add(this.cBoxStates);
            this.Controls.Add(this.butStagePage);
            this.Controls.Add(this.stateInfoDataGridView);
            this.Controls.Add(this.butInsertData);
            this.Controls.Add(this.lblName);
            this.Controls.Add(this.stateInfoBindingNavigator);
            this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "State Info Database Program";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.stateInfoBindingNavigator)).EndInit();
            this.stateInfoBindingNavigator.ResumeLayout(false);
            this.stateInfoBindingNavigator.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.stateInfoDataGridView)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.stateInfoBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.stateInfoDataSet)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private StateInfoDataSet stateInfoDataSet;
        private System.Windows.Forms.BindingSource stateInfoBindingSource;
        private System.Windows.Forms.BindingNavigator stateInfoBindingNavigator;
        private System.Windows.Forms.ToolStripButton bindingNavigatorAddNewItem;
        private System.Windows.Forms.ToolStripLabel bindingNavigatorCountItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorDeleteItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveFirstItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMovePreviousItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator;
        private System.Windows.Forms.ToolStripTextBox bindingNavigatorPositionItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator1;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveNextItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveLastItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator2;
        private System.Windows.Forms.ToolStripButton stateInfoBindingNavigatorSaveItem;
        private System.Windows.Forms.Label lblName;
        private System.Windows.Forms.Button butInsertData;
        private StateInfoDataSetTableAdapters.StateInfoTableAdapter stateInfoTableAdapter;
        private StateInfoDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.DataGridView stateInfoDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn3;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn4;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn5;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn6;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn7;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn8;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn9;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn10;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn11;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn12;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn13;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn14;
        private System.Windows.Forms.Button butStagePage;
        private System.Windows.Forms.ComboBox cBoxStates;
        private System.Windows.Forms.TextBox txtBoxName;
        private System.Windows.Forms.Button butSortPopAsc;
        private System.Windows.Forms.Button butSortPopDesc;
        private System.Windows.Forms.Button butHighPop;
        private System.Windows.Forms.Button butLowPop;
        private System.Windows.Forms.TextBox txtBoxBird;
        private System.Windows.Forms.Label lblBirds;
        private System.Windows.Forms.TextBox txtBoxMin;
        private System.Windows.Forms.Label lblMin;
        private System.Windows.Forms.TextBox txtBoxCap;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button butSearch;
        private System.Windows.Forms.Button butExit;
    }
}

