import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PatternGame extends JFrame {
	
	private JButton[][] buttons = new JButton[5][5];
	private ArrayList<Integer> pattern = new ArrayList<>();
	private ArrayList<Integer> userInput = new ArrayList<>();
	private Random rng = new Random();
	private boolean stageTwo = false;
	private int step = 0;
	private boolean playerTurn = false;
	private int gridSize = 3;
	private JLabel roundLabel;
	private int highscore;
	
	public PatternGame(int Highscore) {
		highscore = Highscore;

		addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                
                new MainMenu();
                
            }
        });
		
		setTitle("iForgor || Pattern Game");
		setSize(600, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		roundLabel = new JLabel("Round: 1", SwingConstants.CENTER);
		roundLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(roundLabel, BorderLayout.NORTH);
		
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(5, 5));
		add(gridPanel, BorderLayout.CENTER);
		
		
		for(int i = 0; i < 25; i++) {
			JButton but = new JButton();
			but.setBackground(Color.LIGHT_GRAY);
			final int index = i;
			but.addActionListener(e -> playerClick(index));
			but.setPreferredSize(new Dimension(100,100));
			but.setFocusPainted(false);
			but.addMouseListener(new java.awt.event.MouseAdapter() {

			    @Override
			    public void mouseEntered(java.awt.event.MouseEvent e) {
			    	setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			    }

			    @Override
			    public void mouseExited(java.awt.event.MouseEvent e) {
			    	setCursor(Cursor.getDefaultCursor());
			    }
			});
			buttons[i / 5][i % 5] = but;
			
			gridPanel.add(but);
			
			
		}
		
		setVisible(true);
		startGame();
	}


    private void highlightButton(int index) {
    	int r = index / gridSize;
    	int c = index % gridSize;

    	int off = offset();
    	JButton but = buttons[r + off][c + off];
        but.setBackground(Color.GREEN);
    }
    
    private void resetButton(int index) {
    	int r = index / gridSize;
    	int c = index % gridSize;

    	int off = offset();
    	JButton but = buttons[r + off][c + off];
        but.setBackground(Color.LIGHT_GRAY);
    }
    
    private void playerClick(int index) {
    	if(!playerTurn) {
    		return;
    	}
    	int row = index / 5;
    	int col = index % 5;

    	int off = offset();

    	if (row < off || col < off || row >= off + gridSize || col >= off + gridSize) { //ignores clicks on locked boxes
    	    return;
    	}

    	
    	int gridRow = row - off;
    	int gridCol = col - off;
    	int gridIndex = gridRow * gridSize + gridCol;
    	highlightButton(gridIndex);
    	
    	Timer time = new Timer(200, e -> resetButton(gridIndex));
    	time.setRepeats(false);
    	time.start();
    	
    	userInput.add(gridIndex);
    	int curStep = userInput.size()-1;
    	
    	if(!userInput.get(curStep).equals(pattern.get(curStep))) {
    		gameOver();
    		return;
    	}
    	
    	if(userInput.size() == pattern.size()) {
    		playerTurn= false;
    		Timer delay = new Timer(800, e-> nextRound());
    		delay.setRepeats(false);
    		delay.start();
    		
    	}
    	
    }
    
    private void startGame() {
    	 pattern.clear();
    	 gridSize = 3;
    	 stageTwo = false;
    	 updateGrid();

    	 nextRound();
    	
    }
    
    private void nextRound() {
    	playerTurn = false;
        userInput.clear();
        int score;
        if(stageTwo) {
        	score = pattern.size() + 4;
        }else {
        	score = pattern.size();
        }
        
        if (pattern.size() >= 5 && !stageTwo) {
            gridSize = 5;
            stageTwo = true;
            setSize(600, 600);
            //stagetwo animation here
            stageTwoAnimation();
            
            Timer delay = new Timer(5000, e -> {
                updateGrid();
                int choice = JOptionPane.showConfirmDialog(null, "READY FOR STAGE 2? ", "STAGE 2", JOptionPane.YES_NO_OPTION);
                if(choice == 0) {
                	pattern.clear();
                	pattern.add(12);
                continueNextRound();
                }else {
                	dispose();
                }
            });
            delay.setRepeats(false);
            delay.start();

            return; 
        }

        int max = gridSize * gridSize;

        int newStep;
        do {
        	newStep = rng.nextInt(max);
        }while(!pattern.isEmpty() && newStep == pattern.get(pattern.size()-1));

        pattern.add(newStep);
        
        if(stageTwo) { 
        	do{
            newStep = rng.nextInt(max);
        	} while (!pattern.isEmpty() && newStep == pattern.get(pattern.size() - 1));

	        pattern.add(newStep);
        }
       
        roundLabel.setText("Round " + (pattern.size()+4)+" | High Score: " + highscore+" | Score: " + score);
            
            	
        
        playPattern();
    	
    }
    
    private void playPattern() {
    	step = 0;
    	
    	Timer time = new Timer(700,  null);
    	
    	time.addActionListener(e -> {
    		if(step > 0) {
    			resetButton(pattern.get(step-1));
    		}
    		
    		if(step < pattern.size()) {
    			highlightButton(pattern.get(step));
    			step++;
    		}else {
    			time.stop();
    			playerTurn = true;
    		}
    	});
    	
    	time.setInitialDelay(500);
    	time.start();
    }
    
    private void gameOver() {
        playerTurn = false;
        showPat();
        int score;
        if(stageTwo) {
        	score = pattern.size() + 4;
        }else {
        	score = pattern.size();
        }
        
        updateHighscore(score);
       

        Timer msgTimer = new Timer(3100, e->{
        	JOptionPane.showMessageDialog(this, "YOU LOSE! SCORE: " + score + "\nHIGH SCORE: " + highscore);
        	((Timer) e.getSource()).stop();
            setSize(600, 600);
            
            int choice =  JOptionPane.showConfirmDialog(null, "TRY AGAIN?", "TRY AGAIN",JOptionPane.YES_NO_OPTION);
            if(choice == 0) {
            startGame();
            }else {
            	
            	dispose();
            	
            	
            }
            
        });
        msgTimer.setRepeats(false);
        msgTimer.start();
        
    }
    
    private void updateGrid() {
    	  for (int i = 0; i < 25; i++) {
    	        int row = i / 5;
    	        int col = i % 5;

    	        JButton but = buttons[row][col];

    	        int off = offset();

    	        if (row >= off && row < off + gridSize &&
    	            col >= off && col < off + gridSize) {
    	            but.setBackground(Color.LIGHT_GRAY);
    	            but.setText(null);
    	            but.setForeground(Color.BLACK);
    	        } else {
    	        	but.setBackground(Color.DARK_GRAY);
    				but.setText("LOCKED");
    				but.setForeground(Color.RED);
    	        }
    	        }
    	revalidate();
    	repaint();
    
    }
    
    private void showPat() {
    	int step = 1;
    	for (int index : pattern) {
    		int r = index / gridSize;
        	int c = index % gridSize;

        	int off = offset();
        	
        	
            buttons[r + off][c + off].setBackground(Color.GREEN);
            
            String prevStep = buttons[r + off][c + off].getText();
            
            if(prevStep != null) {
            	
            	buttons[r + off][c + off].setText(prevStep+"+"+(step));
            }else {
            buttons[r + off][c + off].setText(""+(step));
            }
            
            step++;
        }

        
        Timer resetTimer = new Timer(3000, e -> {
            for (int index : pattern) {
            	int r = index / gridSize;
            	int c = index % gridSize;

            	int off = offset();
            	
                buttons[r + off][c + off].setBackground(Color.LIGHT_GRAY);
                buttons[r + off][c + off].setText(null);
            }
            ((Timer) e.getSource()).stop(); 
            playerTurn = true; 
        });

        resetTimer.setRepeats(false);
        resetTimer.start();
    }
    
    private int offset() {
        return (5 - gridSize) / 2;
    }
    
    private void stageTwoAnimation() {
    	
    	
    	 int[][] ringOrder = {
    		        {1,0},{2,0},{3,0}, // top row
    		        {4,1},{4,2},{4,3}, // right column
    		        {3,4},{2,4},{1,4}, // bottom row
    		        {0,3},{0,2},{0,1}, // left column

    		        {0,0},{4,0},{4,4},{0,4} // corners for last
    		    };

    		 
    		    final int[] step = {0};
    		    
    		    Timer centerFlash = new Timer(700, null);
    		    centerFlash.addActionListener(e -> {
    		        for (int r = 1; r <= 3; r++) {
    		            for (int c = 1; c <= 3; c++) {
    		                JButton but = buttons[r][c];
    		                
    		                if (but.getBackground() == Color.BLUE) {
    		                    but.setBackground(Color.LIGHT_GRAY);
    		                } else {
    		                    but.setBackground(Color.BLUE);
    		                    but.setText("STAGE 2");
    		                    but.setForeground(Color.WHITE);
    		                }
    		            }
    		        }
    		    });

    		    
    		    centerFlash.setInitialDelay(300);
    		    centerFlash.start();
    		    

    		    Timer expandTimer = new Timer(250, null);

    		    expandTimer.addActionListener(e -> {

    		        if (step[0] < ringOrder.length) {

    		            int r = ringOrder[step[0]][0];
    		            int c = ringOrder[step[0]][1];

    		            JButton but = buttons[r][c];

    		           
    		            but.setBackground(Color.GREEN);
    		            but.setText("UNLOCK");
    		            but.setForeground(Color.BLACK);

    		            step[0]++;

    		        } else {
    		            expandTimer.stop();
    		            centerFlash.stop();
    		            
    		            
    		            Timer finish = new Timer(600, ev -> {
    		            	
    		            	for (int r = 1; r <= 3; r++) { //reset center
    		                    for (int c = 1; c <= 3; c++) {
    		                        JButton but = buttons[r][c];
    		                        but.setBackground(Color.LIGHT_GRAY);
    		                        but.setText(null); 
    		                    }
    		                }

    		            	
    		                for (int i = 0; i < 25; i++) {
    		                    buttons[i / 5][i % 5].setText(null);
    		                }
    		            });
    		            finish.setRepeats(false);
    		            finish.start();
    		        }
    		    });

    		    expandTimer.setInitialDelay(500);
    		    expandTimer.start();
    		    }
    
    private void continueNextRound() {
        int max = gridSize * gridSize;
        int score;
        if(stageTwo) {
        	score = pattern.size() + 4;
        }else {
        	score = pattern.size();
        }
        int newStep;
        do {
            newStep = rng.nextInt(max);
        } while (!pattern.isEmpty() && newStep == pattern.get(pattern.size() - 1));

        pattern.add(newStep);
       
        do {
            newStep = rng.nextInt(max);
        } while (!pattern.isEmpty() && newStep == pattern.get(pattern.size() - 1));

        pattern.add(newStep);
        
        if(stageTwo) {
        roundLabel.setText("Round " + (pattern.size()+4)+" | High Score: " + highscore+" | Score: " + score);
        }
        playPattern();
    }
    
    private void updateHighscore(int currentScore) {
        if (currentScore > highscore) {
            highscore = currentScore;
            saveHighscore();  
        }
    }

    private void saveHighscore() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("highscore.txt"))) {
            writer.write(String.valueOf(highscore));
        } catch (IOException e) {
            System.out.println("Error saving high score.");
        }
    }
    
}


