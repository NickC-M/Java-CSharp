import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;



public class MainMenu extends JFrame {
	 private static int highscore;
	
	 Timer menuLoop;

	 double angle = 0;
	 double direction = 1;
	 boolean green = false;
	 int flashCounter = 0;
	 public static void main(String[] args) {
	        new MainMenu(); 
	    }
	 
	public MainMenu() {
		loadHighscore();
        setTitle("iForgor");
        JLabel titleLabel = new JLabel("************ Welcome to iForgor ************", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        setSize(500, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JButton patBut = new JButton("Pattern Game");
        patBut.setBackground(Color.LIGHT_GRAY);
        patBut.setPreferredSize(new Dimension(150, 150));
        patBut.setFont(new Font("Serif", Font.BOLD, 18));
        patBut.setFocusPainted(false);
        patBut.addMouseListener(new java.awt.event.MouseAdapter() {

		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	setCursor(Cursor.getDefaultCursor());
		    }
		});
        
        Shell shellBut = new Shell();
        shellBut.addActionListener(e -> {menuShellClicked();});
        shellBut.setText("Shell Game");
        shellBut.setHorizontalTextPosition(JButton.CENTER);
        shellBut.setVerticalTextPosition(JButton.CENTER);
        shellBut.setForeground(Color.WHITE);
        shellBut.setFont(new Font("Serif", Font.BOLD, 24));
        shellBut.addMouseListener(new java.awt.event.MouseAdapter() {

		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	setCursor(Cursor.getDefaultCursor());
		    }
		});
        JLabel highscoreLabel = new JLabel("High Score: " + highscore, SwingConstants.CENTER);
        highscoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        setLayout(new FlowLayout());
        patBut.addActionListener(e -> {
        	if(e.getSource() == patBut) {
        		PatternGame pGame = new PatternGame(highscore);
        		setVisible(false);
        		
        	}
        });
        add(titleLabel);
        add(patBut);
        add(highscoreLabel);
        add(shellBut);
        setVisible(true);
       
        startLoop(patBut, shellBut);
       
        
    }
	
	 private static void loadHighscore() {
	        try (BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"))) {
	            String line = reader.readLine();
	            if (line != null) {
	                highscore = Integer.parseInt(line);
	            }
	        } catch (IOException | NumberFormatException e) {
	           
	            highscore = 0;
	        }
	    }
	 
	 public void menuShellClicked() {
		 new ShellGame();
		 setVisible(false);
		 
		 
		 
	 }
	 
	 
	 public void startLoop(JButton patBut, Shell shellBut) {
		    menuLoop = new Timer(32, e -> update(patBut, shellBut));
		    menuLoop.start();
		}
	 
	 
	 private void update(JButton patBut, Shell shellBut) {
		    
		    flashCounter++;

		    if (flashCounter >= 20) { 
		        green = !green;
		        flashCounter = 0;

		        patBut.setBackground(green ? Color.GREEN : Color.LIGHT_GRAY);
		    }

		    
		    angle += 0.05 * direction;

		    if (angle > 0.3 || angle < -0.3) {
		        direction *= -1;
		    }

		    shellBut.setAngle(angle);
		}
}
