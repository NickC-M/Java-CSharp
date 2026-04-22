import java.awt.Image;

import javax.swing.*;
public class Letter extends JLabel{
	
	int x; 
	int y;

    public Letter(int x, int y, char letter) {
        this.x = x;
        this.y = y;
        letter = Character.toUpperCase(letter);
        
        ImageIcon letterIcon = new ImageIcon(getClass().getResource("/letter"+letter+".png"));
        Image scaledImage;
        if(letter == 'I') {
        	scaledImage = letterIcon.getImage().getScaledInstance(60, 100, Image.SCALE_SMOOTH);
        	setIcon(new ImageIcon(scaledImage));
        	setSize(60, 100);
        }else {
        	scaledImage = letterIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        	setIcon(new ImageIcon(scaledImage));
        	setSize(100, 100);
        }
        
        
        
        
        setOpaque(false);
        setVisible(false);

        setLocation(x, y);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        setLocation(x, y);
    }
}