import java.awt.Polygon;

public class King {

	 private int xPosition;
	    private int yPosition;
	    private String color;
	    private boolean isVisible;
	    private int height = 65;
	    private int width =80;

	    private int[] xpoints = {
	    	    148, 144, 118, 108, 113, 239, 244, 226, 203, 198, 
	    	    186, 203, 208, 187, 205, 194, 178, 177, 194, 194, 
	    	    177, 178, 161, 161, 144, 146, 161, 162, 148, 139, 
	    	    161, 147, 134, 139, 153
	    	};

	    	private int[] ypoints = {
	    	    201, 264, 301, 321, 340, 339, 319, 300, 267, 199, 
	    	    116, 113, 104, 101, 60, 51, 50, 37, 38, 22, 22, 
	    	    6, 5, 22, 22, 38, 37, 49, 49, 60, 101, 102, 108, 115, 114
	    	};
	    	
	    private int npoints = xpoints.length;

	    public King(int x, int y, String color) {
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
