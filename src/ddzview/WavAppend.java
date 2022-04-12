package ddzview;

import java.io.File;
import java.io.IOException;
import java.io.SequenceInputStream;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
 
public class WavAppend {
    public static void main(String[] args) {
        String wavFile1 = "D:\\bgm1.wav";
        String wavFile2 = "D:\\bgm2.wav";
 
        try {
            AudioInputStream clip1 = AudioSystem.getAudioInputStream(new File(wavFile1));
            AudioInputStream clip2 = AudioSystem.getAudioInputStream(new File(wavFile2));
 
            AudioInputStream appendedFiles = 
                            new AudioInputStream(
                                new SequenceInputStream(clip1, clip2),     
                                clip1.getFormat(), 
                                clip1.getFrameLength() + clip2.getFrameLength());
 
            AudioSystem.write(appendedFiles, 
                            AudioFileFormat.Type.WAVE, 
                            new File("D:\\bgm.wav"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

