package clock;

import javax.swing.JOptionPane;

 public class Clock extends Thread{
	
    public static int REGRESIVE_TIME= 179;
    
	public Clock(){
		start();
	}

	@Override
	public void run() {
	     
	       while(REGRESIVE_TIME > 0){
	    	  
	    	   try {
		    	   REGRESIVE_TIME--;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	     }
	       if(JOptionPane.showConfirmDialog(null, "GAME OVER :)") == JOptionPane.YES_NO_OPTION) System.exit(0);  
  
	}
	  
}
