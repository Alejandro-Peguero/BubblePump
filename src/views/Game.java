package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clock.Clock;

public class Game extends JFrame{
   
	private Thread thread;
	private static long sleep = 1000;
	private BalloonFrame ballonFrame;
	private JPanel clock;
	private JLabel time;
	private JPanel scorePanel;
	private JLabel score;
	
	
	public Game(){
	   super("BalloonGame!!");
	   initialize();
	   setVisible(true);
	   repaint();
		 thread.start();  
	   
   }
	@SuppressWarnings("static-access")
	public void initialize(){
		   setSize(480,720);
		   setDefaultCloseOperation(EXIT_ON_CLOSE);
		   setLayout(null);
		   setResizable(false);
		   ballonFrame = new BalloonFrame();
		   add(ballonFrame);
		   ballonFrame.setBounds(0, 0, 480, 620);
		   clock = new JPanel(true);
		   time = new JLabel("03 : 00");
		   clock.add(time);		   
		   scorePanel = new JPanel(true);
		   score = new JLabel("03 : 00");
		   scorePanel.add(score);
		   
		   addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					System.out.println("Pressed");
					ballonFrame.dragging = true;
				}
				
				@Override
				public void mouseReleased(MouseEvent e) {
					System.out.println("Released");
					ballonFrame.dragging = false;
				}
			});
		   
		   clock.setBackground(Color.cyan);
		   add(scorePanel);
		   add(clock);
		   clock.setBounds(0, 620, 240, 100);
		   scorePanel.setBounds(240, 620, 240, 100);
		   
		   thread = new Thread(){
			   public void run(){
				   while(true){
					   time.setText("Time: " + Clock.REGRESIVE_TIME);
					   score.setText("Score: " + BalloonFrame.SCORE);
					   
					   try {
			        		
							Thread.sleep(700);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				   }
			   };
		   };
		  
		   
	}
}
