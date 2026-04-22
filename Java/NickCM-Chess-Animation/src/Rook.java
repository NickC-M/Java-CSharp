import java.awt.Polygon;

public class Rook {
	 private int xPosition;
	    private int yPosition;
	    private String color;
	    private boolean isVisible;
	    private int height = 80;
	    private int width =70;

	    private int[] xpoints = {
	    	    124, 112, 124, 255, 266, 253, 232, 226, 241, 226, 
	    	    225, 247, 245, 222, 218, 196, 196, 162, 163, 142, 
	    	    142, 120, 122, 141, 143, 131, 149, 147
	    	};

	    	private int[] ypoints = {
	    	    274, 294, 309, 310, 294, 276, 215, 117, 112, 106, 
	    	   90, 92, 50, 52, 69, 68, 53, 52, 68, 68, 52, 
	    	    51, 91, 94, 108, 120, 121, 217
	    	};
	    	
	
	    	
	    	
	    private int npoints = xpoints.length;

	    public Rook(int x, int y, String color) {
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
