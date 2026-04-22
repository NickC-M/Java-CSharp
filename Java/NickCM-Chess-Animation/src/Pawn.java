import java.awt.Polygon;

public class Pawn {
	private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    private int height = 90;
    private int width = 75;

    private int[] xpoints = {
        136, 159, 142, 125, 144, 160, 171, 177, 177, 161, 143, 127, 139, 258, 271, 255,
        240, 221, 214, 223, 227, 248, 264, 248, 229, 252, 233, 194, 152
    };
    
    private int[] ypoints = {
        137, 176, 175, 184, 194, 195, 214, 230, 269, 299, 304, 314, 327, 326, 314, 302,
        298, 270, 230, 213, 193, 193, 184, 174, 173, 129, 97, 74, 91
    };
    
    private int npoints = xpoints.length;


    public Pawn(int x, int y, String color)
    {
        this.xPosition = x;
        this.yPosition = y;
        this.color = color;
        this.isVisible = false;
    }


    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

 
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

    public void moveRight(int i)
    {
    	
        moveHorizontal(60*i);
    }

 
    public void moveLeft()
    {
        moveHorizontal(-60);
    }

 
    public void moveUp()
    {
        moveVertical(-60);
    }

    public void moveDown()
    {
        moveVertical(60);
    }


    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }


    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }


    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if (distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for (int i = 0; i < distance; i++) 
        {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the person vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }
    
    public void slowMoveVerticalSquare(boolean down)
    {
    	
        int delta;
        int distance = 60;
        if(!down) {
        	distance = -60;
        }
        
        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }
    
    public void slowMoveHorizontalSquare(boolean right)
    {
        int delta;
        int distance = 60;
        if(!right) distance = -60;
        if (distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for (int i = 0; i < distance; i++) 
        {
            xPosition += delta;
            draw();
        }
    }
    
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    private void draw()
    {
        if (isVisible) 
        {
            Canvas canvas = Canvas.getCanvas();
     
            int[] xShifted = new int[npoints];
            int[] yShifted = new int[npoints];
            for (int i = 0; i < npoints; i++) 
            {
                
                xShifted[i] = (int)((xpoints[i] - 152) * (width / 256.0)) + xPosition;  
                yShifted[i] = (int)((ypoints[i] - 200) * (height / 426.0)) + yPosition;  
            }

            
            canvas.draw(this, color, new Polygon(xShifted, yShifted, npoints));
            canvas.wait(10);
        }
    }


    private void erase()
    {
        if (isVisible) 
        {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
