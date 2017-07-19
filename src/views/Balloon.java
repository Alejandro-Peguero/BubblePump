package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Balloon extends JButton{
	public int position;
	public Balloon up, down, left, right;
	public Icon icon;
	public int index;
	public BalloonFrame frame;
	public Balloon(final BalloonFrame frame, Icon icon, int index) {
		setSize(60, 80);
		setIcon(icon);
		setContentAreaFilled(false);
		setBorder(null);
		setFocusable(false);
		this.icon = icon;
		this.index = index;
		this.frame = frame;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frame.dragging = true;
				clicked();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				frame.dragging = false;
				frame.explode();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(frame.dragging){
					clicked();
				}
			}
		});
	}
	
	@Override
	public void setIcon(Icon defaultIcon) {
		icon = defaultIcon;
		super.setIcon(defaultIcon);
	}
	
	private void clicked(){
		//System.out.println("Clicked");
		if(!frame.explode.contains(this) && (frame.explode.isEmpty() || frame.explode.get(0).icon.equals(this.icon))){
			//System.out.println("Cond 1");
			Balloon last = null;
			if(!frame.explode.isEmpty()) last = frame.explode.get(frame.explode.size()-1);
			if(last==null || (this.equals(last.up) || this.equals(last.down) || this.equals(last.left) || this.equals(last.right))){
				frame.explode.add(this);
				setContentAreaFilled(true);
			}
		}
		System.out.println("Size: "+frame.explode.size());
		/*if(icon!=null && up!=null && icon.equals(up.icon) && !frame.explode.contains(up)){ frame.explode.add(up); /*up.clicked(); }
		if(icon!=null && down!=null && icon.equals(down.icon) && !frame.explode.contains(down)){ frame.explode.add(down); /*down.clicked(); }
		if(icon!=null && left!=null && icon.equals(left.icon) && !frame.explode.contains(left)){ frame.explode.add(left); /*left.clicked(); }
		if(icon!=null && right!=null && icon.equals(right.icon) && !frame.explode.contains(right)){ frame.explode.add(right); /*right.clicked(); }*/
	}
	
	@Override
	public int hashCode() {
		return index;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj!=null && hashCode() == obj.hashCode();
	}
}











