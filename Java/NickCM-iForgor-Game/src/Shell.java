
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Shell extends JButton{
	double x;//current pos
	double y; 
    double startX; 
    double startY;
    double targetX; 
    double targetY;
    int id;
    boolean moving = false;
    double progress = 0; //0 to 1
    double angle = 0;

    
    public Shell(int id, ShellGame game) {
    	
    	this.id = id;
    	ImageIcon shell = new ImageIcon(getClass().getResource("/shell-clipped.png"));
    	    
    	ImageIcon shell2 = new ImageIcon(getClass().getResource("/shell-clipped2.png"));
    	ImageIcon shell3 = new ImageIcon(getClass().getResource("/shell-clipped3.png"));
    	
    	setIcon(shell);
    	
    	/*
    	 * no dif shells cause then user can see which has ball
    	 * if(id == 0) {
    		setIcon(shell);
    	}else if(id == 1) {
    		setIcon(shell2);
    	}else if(id == 2) {
    		setIcon(shell3);
    	}
    	
    	*/
    	setSize(120, 100);
    	setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        
        addActionListener(e -> {
            game.shellClicked(id);
        });
        
    }
        public Shell() {
        	
        	
        	
        	
        	
        	ImageIcon shell = new ImageIcon(getClass().getResource("/shell-clipped.png"));
        	    
        	ImageIcon shell2 = new ImageIcon(getClass().getResource("/shell-clipped2.png"));
        	ImageIcon shell3 = new ImageIcon(getClass().getResource("/shell-clipped3.png"));
        	
        	Image scaledImage = shell2.getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
        	
        	setIcon(new ImageIcon(scaledImage));
        	
        	/*
        	 * no dif shells cause then user can see which has ball
        	 * if(id == 0) {
        		setIcon(shell);
        	}else if(id == 1) {
        		setIcon(shell2);
        	}else if(id == 2) {
        		setIcon(shell3);
        	}
        	
        	*/
        	setSize(180, 150);
        	setBorderPainted(false);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setOpaque(false);
            
            
    }
        
    public void setAngle(double angle) {
        this.angle = angle;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        
        g2.rotate(angle, getWidth() / 2.0, getHeight() / 2.0);

        super.paintComponent(g2);
        g2.dispose();
    }
}
