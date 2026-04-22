import java.awt.Color;

import com.sun.jdi.event.MonitorWaitedEvent;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		 
		 ChessBoard board = new ChessBoard();
		 Pawn p = new Pawn(325, 510, "Black");
		 Pawn[] homePawns = new Pawn[8];
		 Pawn[] awayPawns = new Pawn[8];
		 King homeKing = new King(335, 517, "home");
		 King awayKing = new King(335, 217, "away");
		 Queen homeQueen = new Queen(335, 517, "home");
		 Queen awayQueen = new Queen(335, 217, "away");
		 Bishop[] homeBishops = new Bishop[2];
		 Bishop[] awayBishops = new Bishop[2];
		 Rook[] homeRooks = new Rook[2];
		 Rook[] awayRooks = new Rook[2];
		 Knight[] homeKnights = new Knight[2];
		 Knight[] awayKnights = new Knight[2];
		
		 board.draw();
		 
		 setKings(homeKing, awayKing);
		 setQueens(homeQueen, awayQueen);
		 setRooks(homeRooks, awayRooks);
		 setBishops(homeBishops, awayBishops);
		 setKnights(homeKnights, awayKnights);
		 setPawns(homePawns, awayPawns);
		 
	
		 turnOne(homePawns, awayPawns);
		 turnTwo(homePawns, awayPawns);
		 turnThree(homeQueen,awayKing);
		 
		
		
		 
		
		 
		 
	
		 
		 
		
		 
		
		 
		 
	
		 
		 
	}
	
	
	
	public static void setKings(King homeKing, King awayKing) {
		
		 homeKing.makeVisible();
		 awayKing.makeVisible();
		 pause();
		 pause();
		 homeKing.slowMoveDiagonally("downr");
		 awayKing.slowMoveDiagonally("upr");
		 homeKing.slowMoveHorizontalSquare(true);
		 awayKing.slowMoveHorizontalSquare(true);
		 homeKing.slowMoveHorizontalSquare(true);
		 awayKing.slowMoveHorizontalSquare(true);
		 homeKing.slowMoveHorizontalSquare(true);
		 awayKing.slowMoveHorizontalSquare(true);
		
	}
	
	public static void setQueens(Queen homeQueen, Queen awayQueen) {
		 homeQueen.makeVisible();
		 awayQueen.makeVisible();
		 pause();
		 homeQueen.slowMoveHorizontal(120);
		 awayQueen.slowMoveHorizontal(120);
		 homeQueen.slowMoveDiagonally("downr");
		 awayQueen.slowMoveDiagonally("upr");
		
	}
	
	public static void setPawns(Pawn[] homePawns, Pawn[] awayPawns) {
		
		 for(int i =0; i < 8; i++) {
			 if(i == 0) {
				 homePawns[i] = new Pawn(325, 510, "home");
			 }else {
			 homePawns[i] = new Pawn(325 +((i-1)*60), 510, "home");
			 }
			 homePawns[i].makeVisible();
			 if(i != 0) {
				 homePawns[i].slowMoveHorizontalSquare(true);;
			 }
			 if(i == 0) {
				 awayPawns[i] = new Pawn(325, 210, "away");
			 }else {
			 awayPawns[i] = new Pawn(325 +((i-1)*60), 210, "away");
			 }
			 awayPawns[i].makeVisible();
			 if(i != 0) {
				 awayPawns[i].slowMoveHorizontalSquare(true);;
			 }
		 }
		
	}
	
	public static void setKnights(Knight[] homeKnights, Knight[] awayKnights) {
		
		for(int i = 0; i < 2; i++) {
			 homeKnights[i] = new Knight(335, 515, "home");
			 homeKnights[i].makeVisible();
			 awayKnights[i] = new Knight(335, 217, "away");
			 awayKnights[i].makeVisible();
			 if(i == 0) {
				 pause();
				 homeKnights[i].slowMoveVerticalSquare(false);
				 homeKnights[i].slowMoveHorizontalSquare(true);
				 homeKnights[i].slowMoveHorizontalSquare(true);
				 
				 awayKnights[i].slowMoveVerticalSquare(true);
				 awayKnights[i].slowMoveHorizontalSquare(true);
				 awayKnights[i].slowMoveHorizontalSquare(true);
				 
				 homeKnights[i].slowMoveHorizontalSquare(false);
				 homeKnights[i].slowMoveVerticalSquare(true);
				 homeKnights[i].slowMoveVerticalSquare(true);
				 
				 
				 awayKnights[i].slowMoveHorizontalSquare(false);
				 awayKnights[i].slowMoveVerticalSquare(false);
				 awayKnights[i].slowMoveVerticalSquare(false);
				
				 
			 }else {
				 pause();
				 homeKnights[i].slowMoveVerticalSquare(false);
				 homeKnights[i].slowMoveHorizontalSquare(true);
				 homeKnights[i].slowMoveHorizontalSquare(true);
				 
				 awayKnights[i].slowMoveVerticalSquare(true);
				 awayKnights[i].slowMoveHorizontalSquare(true);
				 awayKnights[i].slowMoveHorizontalSquare(true);
				 
				 homeKnights[i].slowMoveVerticalSquare(true);
				 homeKnights[i].slowMoveHorizontalSquare(true);
				 homeKnights[i].slowMoveHorizontalSquare(true);
				 
				 awayKnights[i].slowMoveVerticalSquare(false);
				 awayKnights[i].slowMoveHorizontalSquare(true);
				 awayKnights[i].slowMoveHorizontalSquare(true);
				 
				 homeKnights[i].slowMoveHorizontalSquare(true);
				 homeKnights[i].slowMoveHorizontalSquare(true);
				 homeKnights[i].slowMoveVerticalSquare(true);
				 
				 awayKnights[i].slowMoveHorizontalSquare(true);
				 awayKnights[i].slowMoveHorizontalSquare(true);
				 awayKnights[i].slowMoveVerticalSquare(false);
			 }
			 
			 
		 }
		
	}
	
	
	public static void setBishops(Bishop[] homeBishops, Bishop[] awayBishops) {
		
		 
		 for(int i = 0; i < 2; i++) {
			 
			
			 if(i == 0) {
				 homeBishops[i] = new Bishop(335, 517, "home");
				 homeBishops[i].makeVisible();
				 awayBishops[i] = new Bishop(335, 217, "away");
				 awayBishops[i].makeVisible();
				 
				 try {
						Thread.sleep(450);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 pause();
				 homeBishops[i].slowMoveDiagonally("upr");
				 homeBishops[i].slowMoveDiagonally("upr");
				 
				 awayBishops[i].slowMoveDiagonally("downr");
				 awayBishops[i].slowMoveDiagonally("downr");
				 
				 homeBishops[i].slowMoveDiagonally("downr");
				 homeBishops[i].slowMoveDiagonally("downr");
				 homeBishops[i].slowMoveDiagonally("downr");
				
				 awayBishops[i].slowMoveDiagonally("upr");
				 awayBishops[i].slowMoveDiagonally("upr");
				 awayBishops[i].slowMoveDiagonally("upr");
			 }else {
				 homeBishops[i] = new Bishop(335, 457, "home");
				 homeBishops[i].makeVisible();
				 awayBishops[i] = new Bishop(335, 277, "away");
				 awayBishops[i].makeVisible();
				 pause();
				 homeBishops[i].slowMoveDiagonally("downr");
				 homeBishops[i].slowMoveDiagonally("downr");
				 awayBishops[i].slowMoveDiagonally("upr");
				 awayBishops[i].slowMoveDiagonally("upr");
			 }
			 
		 }
		
	}
	
	
	public static void setRooks(Rook[] homeRooks,Rook[] awayRooks) {
		
		 for(int i = 0; i < 2; i++) {
			 homeRooks[i] = new Rook(325, 517, "home");
			 homeRooks[i].makeVisible();
			 awayRooks[i] = new Rook(325, 217, "away");
			 awayRooks[i].makeVisible();
			 if(i == 0) {
				 pause();
				 homeRooks[i].slowMoveVerticalSquare(true);
				 awayRooks[i].slowMoveVerticalSquare(false);
			 }else {
				 pause();
				 homeRooks[i].slowMoveHorizontal(420);
				 awayRooks[i].slowMoveHorizontal(420);
				 homeRooks[i].slowMoveVerticalSquare(true);
				 awayRooks[i].slowMoveVerticalSquare(false);
			 }
		 }
		
		
	}
	
	public static void turnOne(Pawn[] homePawns,Pawn[] awayPawns) {
		pause();
		homePawns[4].slowMoveVertical(-120);
		pause();
		awayPawns[5].slowMoveVerticalSquare(true);
		pause();
	}
	
	public static void turnTwo(Pawn[] homePawns,Pawn[] awayPawns) {
		homePawns[3].slowMoveVertical(-120);
		pause();
		awayPawns[6].slowMoveVertical(120);
		pause();
	}
	
	public static void turnThree(Queen homeQueen, King awayKing) {
		homeQueen.slowMoveDiagonally("upr");
		homeQueen.slowMoveDiagonally("upr");
		homeQueen.slowMoveDiagonally("upr");
		homeQueen.slowMoveDiagonally("upr");
		
		awayKing.changeColor("red");
		pause();
	 	awayKing.changeColor("away");
	 	pause();
	
	 	awayKing.changeColor("red");
	 	pause();
		awayKing.changeColor("away");
		pause();
		
		awayKing.changeColor("red");
		 
	}
	
	public static void pause() {
		try {
			Thread.sleep(450);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
