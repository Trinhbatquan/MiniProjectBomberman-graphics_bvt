package uet.oop.bomberman.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Audio {

    Clip ListenToGame;
    int value;


    /**
     * author me.
     * @param other other coodinate
     */
    public Audio(int other ){
        value = other;
    }

    public void playMeme(){
        try{
            AudioInputStream inputAudio = AudioSystem.getAudioInputStream(new File("res\\sound\\soundtrack.wav"));
            ListenToGame = AudioSystem.getClip();
            ListenToGame.open(inputAudio);
            ListenToGame.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception e){e.printStackTrace();}
    }

    public void stopGame(){
        ListenToGame.stop();
    }


    public static void playEntinyDie(){
        try{
            AudioInputStream inputAudio = AudioSystem.getAudioInputStream(new File("res\\sound\\AA126_11.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(inputAudio);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void playBombDrop(){
        try{
            AudioInputStream inputAudio = AudioSystem.getAudioInputStream(new File("res\\sound\\BOM_SET.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(inputAudio);
            clip.start();
            System.out.println(clip.getMicrosecondLength());
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void playBombExplode(){
        try{
            AudioInputStream inputAudio = AudioSystem.getAudioInputStream(new File("res\\sound\\BOM_11_M.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(inputAudio);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void playBomberWalk(){
        try{
            AudioInputStream inputAudio = AudioSystem.getAudioInputStream(new File("res\\sound\\walk.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(inputAudio);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void playWin(){
        try{
            AudioInputStream inputAudio = AudioSystem.getAudioInputStream(new File("res\\sound\\Victory (mp3cut.net) (1).wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(inputAudio);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void EntityEat(){
        try{
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("res\\sound\\eat.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public void playItemCollected()
    {
        try
        {
            AudioInputStream inputAudio = AudioSystem.getAudioInputStream(new File("res\\sound\\Item.wav"));
            ListenToGame = AudioSystem.getClip();
            ListenToGame.open(inputAudio);
            ListenToGame.start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void playMenuSelected()
    {
        try
        {
            AudioInputStream inputAudio = AudioSystem.getAudioInputStream(new File("res\\sound\\MenuSelect.wav"));
            ListenToGame = AudioSystem.getClip();
            ListenToGame.open(inputAudio);
            ListenToGame.start();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Audio.playWin();
        Thread.sleep(5000);
    }
}

