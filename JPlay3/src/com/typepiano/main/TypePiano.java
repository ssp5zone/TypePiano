package com.typepiano.main;

import com.typepiano.controller.Conductor;
import com.typepiano.sound.Players;

/**
 * The entry point for the application.
 * To change the player, just change the passed parameter to Conductor.
 * 
 * @see Enum com.typepiano.sound.Players 
 * @category Main
 * @version 3.0
 * @author saurabh.parihar
 * 
 */
public class TypePiano {
	public static void main(String[] args) {
		Conductor mainConductor = new Conductor(Players.TINY_PLAYER);
		mainConductor.start();
	}

}
