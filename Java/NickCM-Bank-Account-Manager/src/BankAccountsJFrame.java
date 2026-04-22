import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BankAccountsJFrame extends JFrame implements ActionListener{
	
	JComboBox<String> accsCBox = new JComboBox<>();
    JButton openBut = new JButton("Open Account");
    JButton createBut = new JButton("Create");
	public BankAccountsJFrame()
	{
		setTitle("Bank Management System | All Accounts");
	        setSize(400, 400);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLayout(new FlowLayout());
	        setResizable(false);
	       
	        
	        
	        JLabel accsLbl = new JLabel("Select an account # from the dropdown: ");
	        JLabel createLbl = new JLabel("Click here to create a new account: ");
	        openBut.addActionListener(this);
	        createBut.addActionListener(this);
	        
	        
	       
	        for (BankAccount acc : BankData.accounts) {
	            add(new JLabel(acc.getSummary()));
	            accsCBox.addItem(acc.getType()+","+acc.getAccN());
	        }
	        add(accsLbl);
	        add(accsCBox);
	        add(openBut);
	        add(createLbl);
	        add(createBut);
	        

	        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == createBut) 
		{
			this.dispose();
			BankLoginJFrame createAcc = new BankLoginJFrame();
		}
		
		if(e.getSource() == openBut) 
		{
			String selectedItem = (String) accsCBox.getSelectedItem();
			String[] accInfo = selectedItem.split(",");
			String accNum = accInfo[1].trim();
			int selectedAcc = findAcc(accNum, BankData.accounts);
			this.dispose();
			BankPInfoJFrame info = new BankPInfoJFrame(selectedAcc);
		}
		
	}
	
	public int findAcc(String accN, ArrayList<BankAccount> accounts) 
	{
		for(int i = 0; i < accounts.size(); i++) 
		{
			if(accounts.get(i).getAccN().equals(accN)) 
			{
				return i;
			}
		}
		
		return -1;
	}
}
