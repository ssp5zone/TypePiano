package com.typepiano.sound;

import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;


/**
 * A Tiny Player. Doesn't require threading for multiPlay(). 
 * Works relatively good. Jitters sometimes.
 * 
 * @version 2.0 (get file as resource. JAR fix.)
 * @version 1.0
 * @category Player
 * @since June 2017
 * @author saurabh.parihar
 *
 */
public class TinyPlayer implements Player {

	private Sound sound;
	
	public TinyPlayer() {
		TinySound.init();
	}
	
	public TinyPlayer(String file) {
		this();
		this.loadFile(file);
	}
	
	@Override
	public void play(String file) {
		this.loadFile(file);
		this.play();
	}

	@Override
	public void simplePlay(String file) {
		this.loadFile(file);
		this.simplePlay();
	}

	@Override
	public void multiPlay(String file) {
		this.loadFile(file);
		this.multiPlay();
	}

	@Override
	public void play() {
		this.sound.play();
	}

	@Override
	public void simplePlay() {
		this.sound.play();
	}

	@Override
	public void multiPlay() {
		this.play();
	}

	private void loadFile(String file) {
		this.sound = TinySound.loadSound(getClass().getResource(file));
	}
	
}
