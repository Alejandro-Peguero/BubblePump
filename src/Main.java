
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JOptionPane;

//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
import views.Game;
import clock.Clock;


public class Main {

	public static void main(String [] args)throws Exception{
		//new BalloonFrame();
		Clock clock = new Clock();
			
		new Game();
 	
		//String sonido=Main.class.getResource("assets/juego_sonido.wav").getPath();
		//InputStream in = new FileInputStream(sonido);
		/***************Este error lo da la libreria debido a file restrictiction
		 *PERO, este error es ignorado ya que la funcion del audio es llevada a cabo de todos modos.**********************/
		//AudioStream audio = new AudioStream(in);
		//AudioPlayer.player.start(audio);

	}
}
