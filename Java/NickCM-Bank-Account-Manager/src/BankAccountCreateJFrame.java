import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BankAccountCreateJFrame extends JFrame implements ActionListener{
	String[] riskLvls = {"Low", "Medium", "High"};

	JTextField nameTxt = new JTextField(28);
	JTextField accNTxt = new JTextField(20);
	JTextField emailTxt = new JTextField(30);
	JTextField phoneNumTxt = new JTextField(15);
	JTextField iRateTxt = new JTextField(4);
	JTextField odLimitTxt = new JTextField(10);
	JTextField iBalTxt = new JTextField(16);
	JTextField crypBalTxt = new JTextField(15);
	JTextField crypTTxt = new JTextField(15);
	JComboBox riskLvlCBox = new JComboBox(riskLvls);
	JButton createBut = new JButton("Create Account");
	String type;




	
	public BankAccountCreateJFrame(String type) 
	{
		this.type = type;
		setTitle("Bank Management System | Create "+type+" Account");
		setSize(360, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		FlowLayout layout = new FlowLayout();
		
		JLabel nameLbl = new JLabel("Name: ");
		JLabel accNLbl = new JLabel("Account Number: ");
		JLabel emailLbl = new JLabel("Email: ");
		JLabel phoneNumLbl = new JLabel("Phone Number: ");
		JLabel iRateLbl = new JLabel("Interest Rate: ");
		JLabel odLimitLbl = new JLabel("Overdraft Limit: ");
		JLabel iBalLbl = new JLabel("Investment Balance: ");
		JLabel riskLevelLbl = new JLabel("Risk Level: ");
		JLabel crypBalLbl = new JLabel("Crypto Balance: ");
		JLabel crypTLbl = new JLabel("Crypto Type: ");
		JPanel rowSeparator = new JPanel();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		createBut.addActionListener(this);
		
		setLayout(layout);
		add(nameLbl);
		add(nameTxt);
		add(rowSeparator);
		add(accNLbl);
		add(accNTxt);
		add(rowSeparator);
		add(rowSeparator);
		add(emailLbl);
		add(emailTxt);
		add(rowSeparator);
		add(phoneNumLbl);
		add(phoneNumTxt);
		add(rowSeparator);
		
		switch(type) 
		{
		case "Checking" :
			add(odLimitLbl);
			add(odLimitTxt);
			break;
		case "Savings" :
			add(iRateLbl);
			add(iRateTxt);
			break;
		case "Mutual Fund" :
			add(iBalLbl);
			add(iBalTxt);
			add(riskLevelLbl);
			add(riskLvlCBox);
			break;
		case "Crypto" :
			add(crypBalLbl);
			add(crypBalTxt);
			add(crypTLbl);
			add(crypTTxt);
			break;
		
		}
		
		add(createBut);
		setVisible(true);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try {
		BankAccountsJFrame create;
		BankAccount newAcc = new BankAccount();
		String name = nameTxt.getText();
		String accN = accNTxt.getText();
		String email = emailTxt.getText();
		String phoneN = phoneNumTxt.getText();
		
		if(!email.contains("@")) {
			BankErrorJFrame errorE = new BankErrorJFrame("NO @****.com IN EMAIL \n... ADDING @GMAIL.COM !!");
			email = email + "@gmail.com";
		}
		
		
		if(e.getSource() == createBut) 
		{
			
			switch(type) 
			{
			case "Checking" :
				double odL = Double.parseDouble(odLimitTxt.getText());
				if(odL < 0) {
					BankErrorJFrame lowIR = new BankErrorJFrame("Minimum $0 Overdraft Limit Needed\n.... Setting Od Limit to $0 !!");
					odL = 0;
				}
				
				newAcc = new CheckingAccount(name, accN, email, phoneN, odL);
				break;
			case "Savings" :
				double iRate = Double.parseDouble(iRateTxt.getText());
				if(iRate < 0) {
					BankErrorJFrame lowIR = new BankErrorJFrame("Minimum 0.1% Interest Rate Needed\n.... Setting Int Rate to 0.1% !!");
					iRate = 0.1;
				}else if(iRate >= 15.7){
					BankErrorJFrame limit = new BankErrorJFrame("The max interest rate is 15.7% !!");
					iRate = 15.7;
				}
				
				newAcc = new SavingsAccount(name, accN, email, phoneN, iRate);
				break;	
			case "Crypto" :
				double crypB = Double.parseDouble(crypBalTxt.getText());
				if(crypB <= 0) {
					BankErrorJFrame lowC = new BankErrorJFrame("Minimum $1 Crypto Balance Needed\n.... Setting Balance to $1 !!");
					crypB = 1;
				}
				newAcc = new CryptoAccount(name, accN, email, phoneN, crypB, crypTTxt.getText());
				break;	
			case "Mutual Fund" :
				double iBal = Double.parseDouble(iBalTxt.getText());
				if(iBal < 0) {
					BankErrorJFrame lowiB = new BankErrorJFrame("Minimum $0 Investment Balance Needed \n .... Setting Inv Balance to $0!!");
					iBal = 0;
				}
				
				
				newAcc = new MutualFundAccount(name, accN, email, phoneN, iBal, riskLvlCBox.getSelectedItem().toString());
				break;	
			
			}
		
			BankData.accounts.add(newAcc);
			this.dispose();
			BankAccountsJFrame accs = new BankAccountsJFrame();
		}
		}catch(Exception er) 
		{
			BankErrorJFrame error = new BankErrorJFrame(" "+er.getMessage());
		}
		
	
  }
}
