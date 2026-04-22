import java.awt.Polygon;

public class Knight {
	 private int xPosition;
	    private int yPosition;
	    private String color;
	    private boolean isVisible;
	    private int height = 70;
	    private int width =60;

	    private int[] xpoints = {
	    			121,102,92,108,215,233,226,203,238,242,
	    			237,215,200,184,174,156,157,129,113,96,
	    			76,76,107,138,185,170,144
	    	};

	    	private int[] ypoints = {
	    			308, 316, 332, 345, 344, 331, 318, 305, 216, 144, 
	    			104, 80, 56, 41, 14, 15, 39, 53, 92, 142, 168, 
	    			188, 198, 192,  177, 226, 259
	    	};
	    	
	// 238.58px 216.91px,242.13px 144.40px,237.67px 104.88px,215.00px 80.76px,200.67px 56.53px,184.19px 41.37px,174.71px 14.22px,155.97px 15.14px,157.23px 39.06px,128.75px 53.90px,113.26px 92.49px,96.76px 142.08px,76.77px 168.25px,76.79px 188.59px,107.83px 198.28px,138.00px 192.03px,185.33px 177.53px,170.50px 226.26px,144.08px 259.13px)
	    	
	    private int npoints = xpoints.length;

	    public Knight(int x, int y, String color) {
	        this.xPosition = x;
	        this.yPosition = y;
	        this.color = color;
	        this.isVisible = false;
	    }

	    public void makeVisible() {
	        isVisible = true;
	        draw();
	    }

	    public void makeInvisible() {
	        erase();
	        isVisible = false;
	    }

	    public void moveRight() {
	        moveHorizontal(20);
	    }

	    public void moveLeft() {
	        moveHorizontal(-20);
	    }

	    public void moveUp() {
	        moveVertical(-20);
	    }

	    public void moveDown() {
	        moveVertical(20);
	    }

	    public void moveHorizontal(int distance) {
	        erase();
	        xPosition += distance;
	        draw();
	    }

	    public void moveVertical(int distance) {
	        erase();
	        yPosition += distance;
	        draw();
	    }

	    public void slowMoveHorizontal(int distance) {
	        int delta;

	        if (distance < 0) {
	            delta = -1;
	            distance = -distance;
	        } else {
	            delta = 1;
	        }

	        for (int i = 0; i < distance; i++) {
	            xPosition += delta;
	            draw();
	        }
	    }

	    public void slowMoveVertical(int distance) {
	        int delta;

	        if (distance < 0) {
	            delta = -1;
	            distance = -distance;
	        } else {
	            delta = 1;
	        }

	        for (int i = 0; i < distance; i++) {
	            yPosition += delta;
	            draw();
	        }
	    }

	    public void slowMoveVerticalSquare(boolean down) {
	        int delta;
	        int distance = 60;
	        if (!down) {
	            distance = -60;
	        }

	        if (distance < 0) {
	            delta = -1;
	            distance = -distance;
	        } else {
	            delta = 1;
	        }

	        for (int i = 0; i < distance; i++) {
	            yPosition += delta;
	            draw();
	        }
	    }
	    
	    public void slowMoveDiagonally(String direction) {
	        int deltaX = 0;
	        int deltaY = 0;

	        // direction of movement
	        if (direction.equalsIgnoreCase("upr")) {  // up right
	            deltaX = 1;
	            deltaY = -1;
	        } else if (direction.equalsIgnoreCase("upl")) {  // up left
	            deltaX = -1;
	            deltaY = -1;
	        } else if (direction.equalsIgnoreCase("downr")) {  // down right
	            deltaX = 1;
	            deltaY = 1;
	        } else if (direction.equalsIgnoreCase("downl")) {  // down left
	            deltaX = -1;
	            deltaY = 1;
	        }

	        for (int i = 0; i < 60; i++) {
	            xPosition += deltaX;
	            yPosition += deltaY;
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

	    public void changeColor(String newColor) {
	        color = newColor;
	        draw();
	    }

	    private void draw() {
	        if (isVisible) {
	            Canvas canvas = Canvas.getCanvas();

	            int[] xShifted = new int[npoints];
	            int[] yShifted = new int[npoints];
	            for (int i = 0; i < npoints; i++) {
	                xShifted[i] = (int)((xpoints[i] - 152) * (width / 256.0)) + xPosition;
	                yShifted[i] = (int)((ypoints[i] - 200) * (height / 426.0)) + yPosition;
	            }

	            canvas.draw(this, color, new Polygon(xShifted, yShifted, npoints));
	            canvas.wait(10);
	        }
	    }

	    private void erase() {
	        if (isVisible) {
	            Canvas canvas = Canvas.getCanvas();
	            canvas.erase(this);
	        }
	    }
}
