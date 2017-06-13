package com.typepiano.sound;

import jaco.mp3.player.MP3Player;

/**
 * JaCo player. A player based on jLayer library. 
 * A slight improvement over JfxPlayer. Latency issue still remains.
 * 
 * @version 2.0 (get file as resource. JAR fix.)
 * @version 1.0
 * @category Player
 * @since June 2017
 * @author saurabh.parihar
 *
 */
public class JaCoPlayer implements Player {

	MP3Player player;
	
	public JaCoPlayer() {
		
	}
	
	public JaCoPlayer(String file) {
		this();
		this.setPlayer(file);
	}
	
	@Override
	public void play(String file) {
		this.setPlayer(file);
		this.play();
	}

	@Override
	public void simplePlay(String file) {
		this.setPlayer(file);
		this.simplePlay();
	}

	@Override
	public void multiPlay(String file) {
		this.setPlayer(file);
		this.multiPlay();
	}

	@Override
	public void play() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				player.stop();
				player.play();
			}
			
		}).start();	
	}

	@Override
	public void simplePlay() {
		this.player.play();
	}

	@Override
	public void multiPlay() {
		this.play();
	}

	private void setPlayer(String file) {
		this.player = new MP3Player(getClass().getResource(file));
	}
	
}
