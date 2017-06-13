package com.typepiano.sound;

/**
 * This defines the contract that all Players must full-fill.
 * Most classes will only refer this interface.
 * 
 * @category Contract
 * @since May 2017
 * @version 1.0
 * @author saurabh.parihar
 *
 */
public interface Player {
	public void play(String file);
	public void simplePlay(String file);
	public void multiPlay(String file);
	public void play();
	public void simplePlay();
	public void multiPlay();
}
