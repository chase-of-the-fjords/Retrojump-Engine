package com.chaseplays.engine.sound;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

public class Sound {

	public Clip clip;
	public Clip last_clip;
	
	public String path;
	
	public Sound (String path) {
		
		try {
			
			URL url = this.getClass().getClassLoader().getResource(path);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		this.path = path;
		
	}
	
	public void play () {
		
		if (clip.isActive()) clip.stop();
		
		try {
			
			URL url = this.getClass().getClassLoader().getResource(path);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			
			clip.start();
			
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
	}
	
	public void playInstance () {
		
		try {
			
			URL url = this.getClass().getClassLoader().getResource(path);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			
			Clip clipInstance = AudioSystem.getClip();
			clipInstance.open(audioIn);
			
			clipInstance.start();
			
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
	}
	
	public void stop () {
		
		try {
		
			clip.stop();
		
		} catch (NullPointerException e) {
			
		}
		
	}
	
	public void loop () {
		
		try {
			
			URL url = this.getClass().getClassLoader().getResource(path);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean active () {
		
		if (clip != null) {
			
			if (clip.isActive()) return true;
			
		}
		
		return false;
		
	}
	
	public void setVolume (double volume) {
		
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		 
		float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
		gainControl.setValue(dB);
		
	}
	
	public void fade_out (final int time) {
		
		new Thread() {
			
			public int t = time;
			
			public void run() {
				
				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				
				float starting_volume = gainControl.getValue();
				
				for (float i = starting_volume; i > -80f; i--) {
					
					float dB = i;
					gainControl.setValue(dB);
					
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				stop();
				
			}
			
		}.start();
		
	}
	
	public void setPan (double pan) {
		
	}
	
}