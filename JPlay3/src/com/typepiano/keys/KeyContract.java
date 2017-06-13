package com.typepiano.keys;

/**
 * The contract given by KeyDemon. Anyone who wants to get the super-power of listening 
 * to all the keystrokes in background has to make this contract.
 * 
 * @category Key Listener
 * @version 1.0
 * @since April 2017
 * @author saurabh.parihar
 * @see KeyDemon
 *
 */
public interface KeyContract {
	public void onKeyPressed(int keyCode);
	public void onKeyReleased(int keyCode);
	public void onKeyTyped(int keyCode);
}
