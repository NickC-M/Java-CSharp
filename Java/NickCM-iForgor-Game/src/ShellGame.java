import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Panel;
import java.util.function.DoubleToIntFunction;

import javax.swing.*;

public class ShellGame extends JFrame{
	enum GameState { //enum for gamestate. use to control different stages of game
	    IDLE,
	    SHUFFLE,
	    REVEAL,
	    RESULT,
	    SHOW_BALL

	}
	private GameState state = GameState.IDLE;
	private Shell[] shells = new Shell[3];
	private JPanel panel;
	private Timer gLoop;
	private Ball ball;
	private Shell ballShell;
	private int shuffleStepsLeft = -1;
	private JLabel hand;
	private ImageIcon armIcon;
	private ImageIcon armShellIcon;
	private int revealShellIndex = -1;

	private double revealProgress = 0;
	private Shell resetBut;
	private double showProgress = 0;
	private double showPauseTimer = 0;
	
	private double originalY;
	private int showPhase = 0;
	private Letter[] letters = new Letter[10];
	private int resultTimer = 0;
	private Letter exitBut = new Letter(875, 15, 'X');
	
	public ShellGame() {
		
		addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                
                new MainMenu();
                
            }
        });
		
		setResizable(false);
		setTitle("iFogor || Shell Game");
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		ImageIcon background = new ImageIcon(getClass().getResource("/shellBack.png"));
		JLabel backLbl = new JLabel(background);
		backLbl.setLayout(null);
		setContentPane(backLbl);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(0, 0, 1000, 800);
		backLbl.add(panel);
		
		//letters
		for(int i = 0; i < letters.length; i++) {
			
			
			
			switch(i) {
			
			case 0: 
				letters[i] = new Letter(75, 100, 'Y');
				break;
			case 1: 
				letters[i] = new Letter(175, 100, 'O');
				break;
			case 2: 
				letters[i] = new Letter(275, 100, 'U');
				break;
			case 3: 
				letters[i] = new Letter(475, 100, 'W');
				break;
			case 4: 
				letters[i] = new Letter(575, 100, 'I');
				break;
			case 5: 
				letters[i] = new Letter(635, 100, 'N');
				break;
			case 6: 
				letters[i] = new Letter(475, 100, 'L');
				break;
			case 7: 
				letters[i] = new Letter(575, 100, 'O');
				break;
			case 8: 
				letters[i] = new Letter(675, 100, 'S');
				break;
			case 9: 
				letters[i] = new Letter(775, 100, 'E');
				break;
		
				
			}
			if(i == 4) {
				letters[i].setBounds(letters[i].x, letters[i].y, 60, 100);
			}else {
				letters[i].setBounds(letters[i].x, letters[i].y, 100, 100);
			}
			panel.add(letters[i]);
		}
		//Exit button
		exitBut.setBounds(exitBut.x, exitBut.y, 100, 100);
		exitBut.setVisible(true);
		exitBut.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent e) {
		        dispose();
		    }

		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	setCursor(state == GameState.IDLE ? Cursor.getDefaultCursor() : Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		    }
		});
		panel.add(exitBut);
		
		
		//shells
		for(int i = 0; i < 3; i++) {
			shells[i] = new Shell(i, this);
			
			shells[i].x = 200 +i*200;
			shells[i].y = 250;
			shells[i].setBounds((int)shells[i].x, (int)shells[i].y, 180, 150);
			shells[i].addMouseListener(new java.awt.event.MouseAdapter() {

			    @Override
			    public void mouseEntered(java.awt.event.MouseEvent e) {
			    	setCursor(state == GameState.IDLE && shuffleStepsLeft >= 0 ? Cursor.getPredefinedCursor(Cursor.HAND_CURSOR) : Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			    }

			    @Override
			    public void mouseExited(java.awt.event.MouseEvent e) {
			    	setCursor(state == GameState.IDLE ? Cursor.getDefaultCursor() : Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			    }
			});
			panel.add(shells[i]);
			
		}
		resetBut = new Shell();
		resetBut.addActionListener(e -> {menuShellClicked();});
		resetBut.setText("Reset");
		resetBut.setHorizontalTextPosition(JButton.CENTER);
		resetBut.setVerticalTextPosition(JButton.CENTER);
		resetBut.setFont(new Font("Serif", Font.BOLD, 24));
		resetBut.setForeground(Color.WHITE);
		resetBut.setLocation(400, 450);
		resetBut.addMouseListener(new java.awt.event.MouseAdapter() {

		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	setCursor(state == GameState.IDLE ? Cursor.getPredefinedCursor(Cursor.HAND_CURSOR) : Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	setCursor(state == GameState.IDLE ? Cursor.getDefaultCursor() : Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		    }
		});
		
		
		panel.add(resetBut);
		ball = new Ball(250, 350);
		panel.add(ball);
		panel.setComponentZOrder(ball, panel.getComponentCount() - 1); //keeps ball behind shell!!!!!
		ballShell = shells[1];
		updateBallPosition();
		
		armIcon = new ImageIcon(getClass().getResource("/arm.png"));
		armShellIcon = new ImageIcon(getClass().getResource("/armshell.png"));
		
		hand = new JLabel(armIcon);
		hand.setSize(250, 150);
		hand.setVisible(false);
		panel.add(hand);
		panel.setComponentZOrder(hand, 0);
		
		gLoop = new Timer(16, e -> update());
		gLoop.start();
		
		setVisible(true);
		
		startGameFlow(); //starts game
	}
	
	
	 


	 private void update() {
		 
		 switch (state) {

	        case SHUFFLE:
	            updateShuffle();
	            break;

	        case REVEAL:
	            updateReveal();
	            break;

	        case RESULT:
	            updateResult();
	            break;

	        case IDLE:
	        default:
	            updateIdle();
	            break;
	        case SHOW_BALL:
	        	updateShowBall();
	        	break;
	       
	    }
	     
	 }
	 
	 public void animateSwap(int a, int b) {
		 
		 	Shell s1 = shells[a];
		    Shell s2 = shells[b];

		    
		    double s1StartX = s1.x;
		    double s1StartY = s1.y;

		    double s2StartX = s2.x;
		    double s2StartY = s2.y;

		    
		    

		    
		    s1.startX = s1StartX;
		    s1.startY = s1StartY;

		    s2.startX = s2StartX;
		    s2.startY = s2StartY;

		   
		    s1.targetX = s2StartX;
		    s1.targetY = s2StartY;

		    s2.targetX = s1StartX;
		    s2.targetY = s1StartY;

		    s1.progress = 0;
		    s2.progress = 0;

		    s1.moving = true;
		    s2.moving = true;
		   
	    }

    
    
    
    public void startShuffle(int steps) {
    
    	 shuffleStepsLeft = steps;
    	 setState(GameState.SHUFFLE);
    	 nextShuffleStep();
    }
    
    
    private void nextShuffleStep() {
    	
    	if (shuffleStepsLeft <= 0) {
    		setState(GameState.IDLE);
            return;
        }

        int a = (int)(Math.random() * 3);
        int b = (int)(Math.random() * 3);

        while (b == a) {
            b = (int)(Math.random() * 3);
        }

     
        
        animateSwap(a, b);
        shuffleStepsLeft--;
        
       
        
        
    }
    
    //checks if the shells are finished moving
    private boolean allShellsStopped() {
        for (Shell s : shells) {
            if (s.moving) return false;
        }
        return true;
    }
    
    private void updateBallPosition() {
    	 if (ballShell == null) return;

    	    double bx = ballShell.x + (ballShell.getWidth() / 2.0) - 25;
    	    double by = ballShell.y + (ballShell.getHeight() / 2.0) - 25;

    	    ball.setLocation((int)bx, (int)by);

    	   
    }
    
    
    private void setState(GameState newState) {
        state = newState;
        
        if (newState == GameState.RESULT) {
            resultTimer = 0;
        }
        resetBut.setEnabled(newState == GameState.IDLE);
        setCursor(state == GameState.IDLE ? Cursor.getDefaultCursor() : Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }
    
    private void updateIdle() {
        updateBallPosition();
    }
    
    
    private void updateShuffle() {

    	 for (Shell shell : shells) {
    	        if (shell.moving) {

    	            shell.progress += 0.05;

    	            double t = shell.progress;
    	            t = t * t * (3 - 2 * t);

    	            shell.x = shell.startX + t * (shell.targetX - shell.startX);
    	            shell.y = shell.startY + t * (shell.targetY - shell.startY);

    	            shell.setLocation((int)shell.x, (int)shell.y);

    	            if (shell.progress >= 1) {
    	                shell.moving = false;
    	            }
    	        }
    	    }

    	    updateBallPosition();

    	    if (allShellsStopped()) {
    	        if (shuffleStepsLeft > 0) {
    	            nextShuffleStep();
    	        } else {
    	            setState(GameState.IDLE);
    	        }
    	    }
    }
    
    private void updateReveal() {

        revealProgress += 0.015;

        double t = revealProgress;
        t = t * t * (3 - 2 * t);

        Shell s = shells[revealShellIndex];
        double startY = -250;
        double grabY = s.y -40;
        double hx = s.x ;
        double hy;
        if(t < .7) {
        	
        	double t1 = t / 0.7;
        	hy = startY + t1 * (grabY - startY);
        	hand.setLocation((int)hx, (int)hy);
            hand.setIcon(armIcon);
        }else if (t < 0.8) {
            hand.setIcon(armShellIcon);
            s.setVisible(false);
            ball.setVisible(true);
        }
        else{
        	 double t2 = (t - 0.8) / 0.2;
        	 t2 = t2 * t2;
             
             double endY = s.y - 350; 

             hy = grabY + t2 * (endY - grabY);

             hand.setLocation((int)hx, (int)hy);
            
        }
        

        
        
      

        if (revealProgress >= 1) {
            setState(GameState.RESULT);

            
        }
    }
    
    public void startReveal(int index) {
    	
    	if(shuffleStepsLeft < 0) {
    		return;
    	}
	    revealShellIndex = index;
	    revealProgress = 0;

	    Shell clickedShell = shells[index];

	    hand.setLocation((int)clickedShell.x + 50, -250);
	    hand.setVisible(true);
	    hand.setIcon(armIcon);

	   

	    setState(GameState.REVEAL);
    }
    
    private void startGameFlow() {
        new Timer(1000, e -> {
            ((Timer)e.getSource()).stop();
            startShowBall();
            


        }).start();
    }
    
    
    private void updateResult() {
       
    	boolean win = (shells[revealShellIndex] == ballShell);
 	    if(win) {
 	    	for(int i = 0; i < 6; i++) {
 	    		letters[i].setVisible(true);
 	    	}
 	    }else {
 	    	for(int i = 0; i < 3; i++) {
 	    		letters[i].setVisible(true);
 	    	}
 	    	for(int i = 6; i < 10; i++) {
 	    		letters[i].setVisible(true);
 	    	}
 	    }
        
 	    resultTimer++;
 	    
 	   if (resultTimer > 60) { 
 	        setState(GameState.IDLE);
 	    }
 	    
    }
    
    private void startShowBall() {
    	
    	Shell s = ballShell;
    	
    	originalY = s.y;
    	showProgress = 0;
    	showPauseTimer = 0;
    	
    	
    	ball.setVisible(true);
       
        setState(GameState.SHOW_BALL);
    }
    
    private void updateShowBall() {
    	
    	Shell s = ballShell;
        double liftHeight = 120;

        if (showPhase == 0) {	//up
            showProgress += 0.03;

            double t = showProgress;
            t = t * t * (3 - 2 * t);

            s.y = originalY - (t * liftHeight);
            s.setLocation((int)s.x, (int)s.y);

            if (showProgress >= 1) {
                showProgress = 1;
                showPhase = 1;
                showPauseTimer = 0;
            }

        }  if (showPhase == 1) {	//pause
            showPauseTimer++;

            if (showPauseTimer >= 40) {
                showPhase = 2;
            }

        } else if (showPhase == 2) {	//down
            showProgress -= 0.03;

            if (showProgress < 0) showProgress = 0;

            double t = showProgress;
            t = t * t * (3 - 2 * t);

            s.y = originalY - (t * liftHeight);
            s.setLocation((int)s.x, (int)s.y);

            if (showProgress <= 0 && state == GameState.SHOW_BALL) {
                s.y = originalY;
                s.setLocation((int)s.x, (int)s.y);

                ball.setVisible(false);

                startShuffle(10);
                showProgress = 0;
                showPauseTimer = 0;
                showPhase = 0;
            }
        }
        
        
        //updateBallPosition();
    }
    
    //CLICK METHODS FOR SHELLS
    public void shellClicked(int index) {
    	
    	if (state != GameState.IDLE || shuffleStepsLeft < 0) return; 
    	
        setState(GameState.REVEAL);
        startReveal(index);
        shuffleStepsLeft = -1;
    }
    
    public void menuShellClicked() {
    	
    	if (state != GameState.IDLE) {
    		
    		return; 
    		}

        for (int i = 0; i < shells.length; i++) {
            shells[i].x = 200 + i * 200;
            shells[i].y = 250;

            shells[i].setLocation((int)shells[i].x, (int)shells[i].y);
            shells[i].setVisible(true);
            shells[i].moving = false;
            shells[i].progress = 0;
        }

       for(int i = 0; i < letters.length; i++) {
    	   letters[i].setVisible(false);
       }
  
        ball.setVisible(true);
        updateBallPosition();


        hand.setVisible(false);
        revealProgress = 0;
        revealShellIndex = -1;

    
        shuffleStepsLeft = -1;
        startShowBall();
    }
    
    
    
}
