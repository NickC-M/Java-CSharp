import java.awt.Polygon;

public class Bishop {
	 private int xPosition;
	    private int yPosition;
	    private String color;
	    private boolean isVisible;
	    private int height = 70;
	    private int width =90;

	    private int[] xpoints = {
	    	    122, 103, 93, 108, 216, 233, 226, 203, 190, 
	    	    210, 187, 174, 178, 164, 147, 159, 141, 118, 137
	    	};

	    	private int[] ypoints = {
	    	    308, 316, 333, 345, 344, 332, 318, 306, 142, 111, 76, 
	    	    59, 48, 38, 46, 57, 76, 110, 144
	    	};
	    	
	    	//polygon(121.67px 308.00px,102.58px 316.37px,92.50px 332.74px,108.33px 345.47px,215.67px 344.47px,233.00px 331.74px,226.33px 318.00px,203.50px 305.94px,189.67px 141.88px,210.00px 111.76px,186.67px 75.53px,174.43px 59.45px,178.19px 48.37px,163.71px 38.22px,146.75px 45.90px,158.83px 57.28px,141.00px 76.03px,118.33px 112.53px,137.50px 144.26px)
	    	
	    private int npoints = xpoints.length;

	    public Bishop(int x, int y, String color) {
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
