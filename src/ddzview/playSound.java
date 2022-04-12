package ddzview;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.*;
public class playSound {

	public static void playmusic() {
		// TODO Auto-generated method stub
        try {
			Clip bgm =AudioSystem.getClip();
			
			InputStream is = playSound.class.getClassLoader().getResourceAsStream("sound/bgm2_1.wav");
			//InputStream is = this.getClass().getClassLoader().getResourceAsStream("sound/bgm2.wav");
			AudioInputStream ais= AudioSystem.getAudioInputStream(is);
			
			bgm.open(ais);
			bgm.start();
			bgm.loop(Clip.LOOP_CONTINUOUSLY);
			while(true) {
				
			}
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
