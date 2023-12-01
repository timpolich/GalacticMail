import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class GameSound {

    Clip clip;
    URL soundURL[] = new URL[5];

    public GameSound() {
        soundURL[0] = getClass().getResource("Bonus.wav");
        soundURL[1] = getClass().getResource("Explosion.wav");
        soundURL[2] = getClass().getResource("Launch.wav");
        soundURL[3] = getClass().getResource("GalacticMailTheme.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(audio);
        }
        catch(Exception e) {

        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }

}
