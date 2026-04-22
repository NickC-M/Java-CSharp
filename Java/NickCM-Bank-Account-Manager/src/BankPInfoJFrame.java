import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankPInfoJFrame extends JFrame implements ActionListener{
	JButton accountsBut = new JButton("All Accounts");
	JButton withdrawBut = new JButton("Withdraw");
	JButton depositBut = new JButton("Deposit");
	JTextField depositTxt = new JTextField(10);
	JTextField withdrawTxt = new JTextField(10);
	int accI = 0;
	JLabel accDetails;

	public BankPInfoJFrame(int accountIndex) 
	{
		accI = accountIndex;
		setTitle("Bank Management System | Account Info");
		setSize(900, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		FlowLayout layout = new FlowLayout();
		accDetails = new JLabel(BankData.accounts.get(accI).displayAccountInfo());
		JLabel titleLbl = new JLabel("ACCOUNT");
		JLabel depoLbl = new JLabel("Click here to deposit the entered amount: ");
		JLabel withdrawLbl = new JLabel("Click here to withdraw the entered amount: ");

		
		depositBut.addActionListener(this);
		accountsBut.addActionListener(this);
		withdrawBut.addActionListener(this);
		
		setLayout(layout);
		add(titleLbl);
		add(accDetails);
		add(depoLbl);
		add(depositTxt);
		add(depositBut);
		add(withdrawLbl);
		add(withdrawTxt);
		add(withdrawBut);
		add(accountsBut);
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try {
		if(e.getSource() == depositBut) 
		{
			double amt = Double.parseDouble(depositTxt.getText());
			BankData.accounts.get(accI).deposit(amt);
			accDetails.setText(BankData.accounts.get(accI).displayAccountInfo());
			depositTxt.setText(null);
			
			
			
		}
		
		if(e.getSource() == withdrawBut) 
		{
			double amt = Double.parseDouble(withdrawTxt.getText());
			BankData.accounts.get(accI).withdraw(amt);
			accDetails.setText(BankData.accounts.get(accI).displayAccountInfo());
			withdrawTxt.setText(null);
		}
		} catch (NumberFormatException ex) {
			BankErrorJFrame error = new BankErrorJFrame(" "+ex.getMessage());
		}
		
		if(e.getSource() == accountsBut) 
		{
			BankAccountsJFrame accs = new BankAccountsJFrame();
			this.dispose();
		}
	}

}
