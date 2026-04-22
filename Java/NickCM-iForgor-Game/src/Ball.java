import javax.swing.*;
import java.awt.*;
public class Ball extends JLabel{
	
	double x; 
	double y;

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;

        ImageIcon ballIcon = new ImageIcon(getClass().getResource("/ballR.png"));
        setIcon(ballIcon);

        setSize(45, 45);
        setOpaque(false);
        setVisible(true);

        setLocation((int)x, (int)y);
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
        setLocation((int)x, (int)y);
    }
}
