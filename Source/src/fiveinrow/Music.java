/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fiveinrow;

import java.io.File;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author Hussain
 */
public class Music {
    AudioInputStream audioInputStream;
    Clip clip;
    
    Music(String FILE)
    { 
        try{
        audioInputStream = AudioSystem.getAudioInputStream(new File(FILE));
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        }
        catch(Exception e){}
    }
    
    void play(int loop)
    {
        try{
        
        clip.loop(loop);
        clip.start();

        
        }
        catch(Exception e){}
    }
    void stop()
    {
        try {clip.stop();
        clip.drain();}
        catch (Exception e){}
    }
    
    void volume(float decibals)
    {   try{
        FloatControl gainControl = 
       (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        
        gainControl.setValue(decibals); 
    }
    catch (Exception a){}
    }
}
