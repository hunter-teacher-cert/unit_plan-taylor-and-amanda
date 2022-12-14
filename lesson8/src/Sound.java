
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


/**
 *
 * @author Amanda
 */
public class Sound {
    
    // used to use audio file
    Clip clip;
    
    // used to sore sound path
    URL soundURL[] = new URL[30];
    
    public Sound()
    {
        soundURL[0] = getClass().getResource("/sound/notification.wav");
        soundURL[1] = getClass().getResource("/sound/intro.wav");
    }
    
    public void setFile(int i)
    {
        try{
            // format for audio files in java
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            
        }catch(Exception e){
            
        }
    }
    public void play()
    {
        clip.start();
    }
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop()
    {
        clip.stop();
    }
}
