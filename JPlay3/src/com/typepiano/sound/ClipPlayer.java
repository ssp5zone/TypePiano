package com.typepiano.sound;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * A ClipPlayer. The simplest of all, uses inbuilt sound library.
 * Plays notes smoothly. Can only play WAV files.
 * Sometimes notes are missed.
 * Sound is crispiest of all.
 * 
 * @version 2.0 (get file as resource. JAR fix.)
 * @version 1.0
 * @category Player 
 * @since May 2017
 * @author saurabh.parihar
 *
 */
public class ClipPlayer implements Player {

	private Clip clip;
	private AudioInputStream ais;
	private String file; // only for debugging
	
	public ClipPlayer() {
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			System.err.println("Unable to init Clip!");
			e.printStackTrace();
		}
	}
	
	// an optional file can be passed
	public ClipPlayer(String file) {
		this();
		this.file = file;
		if (file!=null) {
			this.setAudioInputStream(file);
			this.openClip(this.ais);
		}		
	}
	
	@Override
	public void play(String file) {
		this.multiPlay(file);
	}

	@Override
	public void simplePlay(String file) {
		this.setAudioInputStream(file);
		this.openClip(this.ais);
		this.simplePlay();
	}

	@Override
	public void multiPlay(String file) {
		// TODO Auto-generated method stub
		this.multiPlay();
	}

	@Override
	public void play() {
		this.multiPlay();		
	}
	
	// same player for another file behaves weirdly
	@Override
	public void simplePlay() {
		clip.start();
		while(clip.getMicrosecondLength() != clip.getMicrosecondPosition()){}
	}

	@Override
	public void multiPlay() {
		run();
	}
	
	private void setAudioInputStream(String source) {
		try {
			this.ais = AudioSystem.getAudioInputStream(getClass().getResource(source));
		} catch (UnsupportedAudioFileException e) {
			System.err.println("This jar is probably corrupt!");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unable to open Clip!");
			e.printStackTrace();
		}
	}
	
	private void openClip(AudioInputStream ais) {
		try 
		{
			if(clip.isOpen()) {
				clip.close();
			}
			clip.open(ais);
			
			// didn't work
			//clip.addLineListener(new LineListener() {
			//	@Override
			//	public void update(LineEvent e) {
			//		if (e.getType() == LineEvent.Type.STOP) {
			//			e.getLine().close();
			//		}	
			//	}
			//});
			
		} catch (IOException e) 
		{
			System.err.println("Unable to fetch file.");
			e.printStackTrace();
		} catch (LineUnavailableException e) 
		{
			System.err.println("Unable to play clip.");
			e.printStackTrace();
		}
	}

	public void run() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				//clip.stop();
				clip.setFramePosition(0);
				System.out.println("Thread: " + this.hashCode() + 
						", playing file: " + file +
						", with clip running: " + clip.isRunning() +
						", active: " + clip.isActive() +
						", avaiable: " + clip.available() +
						", length:" + clip.getFrameLength() +
						", position: " + clip.getFramePosition() +
						", buffer: " + clip.getBufferSize());
				clip.start();	
			}
			
		}).start();		
	}

}
