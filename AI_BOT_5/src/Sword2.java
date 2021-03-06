import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * @Author: Asif Mohaimen
 * @Reg. No. : 2012331054
 * @Class: This class controls the audio handling of the successful hit.
 */

public class Sword2 implements Runnable
{
    /**
     * Constructor.
     * Initiates the Thread.
     */
    Sword2()
    {
        Thread t = new Thread(this, "Sowrd2");
        t.setPriority(9);
        t.start();
    }
    
    /**
     * Run method
     * Plays the clip.
     */
    public void run()
    {
            try 
            {
                 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Files/Sound/Sword2.wav").getAbsoluteFile());
                 Clip clip = AudioSystem.getClip();
                 clip.open(audioInputStream);
                 clip.start();
            }
            catch(Exception ex){}
    }
}
