import java.awt.Color;

public class ChessBoard {
	
	private Square[] boardGrid;
	private Square board;

	public ChessBoard() {
		boardGrid = new Square[64];
		for(int i = 0; i < 64; i++) {
			  int row = i / 8;
			  int col = i % 8;
			  boardGrid[i] = new Square();
			  boardGrid[i].moveHorizontal(col * 60);
			  boardGrid[i].moveVertical(row * 60);		
		}
		board = new Square();
		board.changeSize(1400);
		
	}
	
	
	public void draw() {
		board.changeColor("board");
		board.moveHorizontal(-500);
		board.moveVertical(-400);
		board.makeVisible();
		
		for(int i = 0; i < 64; i++) {
			int row = i / 8;
		    int col = i % 8;
		    if ((row + col) % 2 == 0) {
		        boardGrid[i].changeColor("ChessSquareDark");
		    } else {
		        boardGrid[i].changeColor("ChessSquareLight");
		    }
		    boardGrid[i].makeVisible();
		}
		
		
		
	}
	

}
