package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BalloonFrame extends JPanel{
	Balloon b;
	public static int SCORE = 0;
	public boolean dragging = false;
	private JPanel frame, clock, pointsPanel;
	public List<Balloon> explode = new ArrayList<Balloon>();
	private ImageIcon[] images = {
		new ImageIcon(BalloonFrame.class.getResource("../img/green.png")),
		new ImageIcon(BalloonFrame.class.getResource("../img/red.png")),
		new ImageIcon(BalloonFrame.class.getResource("../img/yellow.png")),
		new ImageIcon(BalloonFrame.class.getResource("../img/blue.png"))
	};

	private static final long serialVersionUID = 1L;
	public BalloonFrame(){
		super(true);
		initialize();
	}	
	private void initialize(){
		setSize(480,480);
		setIgnoreRepaint(true);
		frame = new JPanel();
		clock = new JPanel();
		pointsPanel = new JPanel();
		setLayout(new GridLayout(6, 6));
		Balloon[] balloons = new Balloon[36];
		
		for(int i = 0; i<36; i++){
			b = new Balloon(this, images[(int) (Math.random()*4)], i);
			b.setBackground(Color.CYAN);
			balloons[i] = b;
			add(b);
		}
		
		for(int i = 0; i<balloons.length; i++){
			if((i-6)>=0) balloons[i].up = balloons[i-6];
			if((i+6)<36) balloons[i].down = balloons[i+6];
			if(i%6!=0 && (i-1)>=0) balloons[i].left = balloons[i-1];
			if((i+1)%6!=0) balloons[i].right = balloons[i+1];
		}
		
		
		setVisible(true);
		repaint();
	}
	
	public void explode(){
		/*if(explode.size()>2) for(Balloon balloon : explode){
			balloon.setIcon(images[(int) (Math.random()*4)]);
		}*/
		//System.err.println("Size: "+explode.size());
		if(explode.size()>1){
			for(Balloon balloon : explode){
				balloon.setContentAreaFilled(false);
				balloon.setIcon(images[(int) (Math.random()*4)]);
			}
			SCORE += explode.size();
		}
		else{
			for(Balloon balloon : explode) balloon.setContentAreaFilled(false);
		}
		
		explode.clear();
		System.out.println(SCORE);
		repaint();
	}
}

