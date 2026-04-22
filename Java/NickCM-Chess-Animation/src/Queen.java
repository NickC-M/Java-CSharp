import java.awt.Polygon;

public class Queen {
	 private int xPosition;
	    private int yPosition;
	    private String color;
	    private boolean isVisible;
	    private int height = 80;
	    private int width =70;

	    private int[] xpoints = {
	    	    124, 117, 124, 255, 261, 253, 219, 204, 214, 218, 
	    	    234, 237, 223, 210, 196, 175, 158, 142, 131, 112, 
	    	    124, 141, 143, 156, 147
	    	};

	    	private int[] ypoints = {
	    	    274, 292, 309, 310, 293, 276, 216, 135, 107, 91, 
	    	   71, 35, 59, 36, 53, 8, 48, 37, 48, 26, 68, 
	    	    93, 107, 131, 217
	    	};
	    	
	// 233.67px 70.53px,236.54px 35.03px,222.83px 58.53px,209.97px 36.05px,196.11px 52.58px,175.39px 7.62px,157.95px 47.72px,142.06px 36.90px,131.28px 48.28px,111.73px 26.43px,123.63px 68.53px,141.42px 93.53px,143.00px 107.53px,156.17px 130.65px,147.00px 216.76px)
	    	
	    private int npoints = xpoints.length;

	    public Queen(int x, int y, String color) {
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
