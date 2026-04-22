import javax.swing.*;
import java.awt.*;

public class BankErrorJFrame extends JFrame{
	
	public BankErrorJFrame(String error) 
	{
		setTitle("Bank Management System | Error");
		setSize(750, 100);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

		FlowLayout layout = new FlowLayout();
		
		JLabel errorLbl = new JLabel("ERROR: ");
		JLabel errorDescLbl = new JLabel(error);
		
		setLayout(layout);
		add(errorLbl);
		add(errorDescLbl);
		setVisible(true);

	}
}
