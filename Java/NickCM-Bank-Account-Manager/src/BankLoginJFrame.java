import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class BankLoginJFrame extends JFrame implements ActionListener{
	
	
	JRadioButton checkAccBut = new JRadioButton("Checking Account");
	JRadioButton cryptoAccBut = new JRadioButton("Crypto Account");
	JRadioButton MutAccBut = new JRadioButton("Mutual Fund Account");
	JRadioButton SavAccBut = new JRadioButton("Savings Account");
	JButton submitBut = new JButton("Submit");
	ButtonGroup radGroup = new ButtonGroup();
	
	public BankLoginJFrame() 
	{
		setTitle("Bank Management System | Create Account");
		setSize(600, 150);
		setLocationRelativeTo(null);
		setResizable(false);
		FlowLayout layout = new FlowLayout();
		
		JPanel butPanel = new JPanel();
		
		

		JLabel accTypeLbl = new JLabel("Please choose an account type");
		
		
		checkAccBut.setMnemonic(KeyEvent.VK_C);
		cryptoAccBut.setMnemonic(KeyEvent.VK_P);
		MutAccBut.setMnemonic(KeyEvent.VK_M);
		SavAccBut.setMnemonic(KeyEvent.VK_S);
		
		checkAccBut.addActionListener(this);
		cryptoAccBut.addActionListener(this);
		MutAccBut.addActionListener(this);
		SavAccBut.addActionListener(this);
		submitBut.addActionListener(this);
		
		checkAccBut.setActionCommand("Checking");
		cryptoAccBut.setActionCommand("Crypto");
		MutAccBut.setActionCommand("Mutual Fund");
		SavAccBut.setActionCommand("Savings");
		
		submitBut.setEnabled(false);
		
		radGroup.add(checkAccBut);
		radGroup.add(cryptoAccBut);
		radGroup.add(MutAccBut);
		radGroup.add(SavAccBut);
		
		
		butPanel.add(checkAccBut);
		butPanel.add(cryptoAccBut);
		butPanel.add(MutAccBut);
		butPanel.add(SavAccBut);
		
		add(accTypeLbl);
		add(butPanel);
		add(submitBut);
		
		
		setResizable(false);
		
		
		setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(layout);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		BankAccountCreateJFrame create;
		if(e.getSource() instanceof JRadioButton ) 
		{
			submitBut.setEnabled(true);
		}
		
		if(e.getSource() == submitBut) 
		{
			switch(radGroup.getSelection().getActionCommand()) 
			{
			case "Checking" :
				this.dispose();
				 create = new BankAccountCreateJFrame("Checking");
				break;
			case "Savings" :
				this.dispose();
				 create = new BankAccountCreateJFrame("Savings");
				break;	
			case "Crypto" :
				this.dispose();

				 create = new BankAccountCreateJFrame("Crypto");
				break;	
			case "Mutual Fund" :
				this.dispose();
				 create = new BankAccountCreateJFrame("Mutual Fund");
				break;	
			
			}
		}
		
	}
}
