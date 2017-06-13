package com.typepiano.keys;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 * The daemon thread that runs in the background and listens to all the keystrokes.
 * This class passes the keystrokes to anyone who has summoned the demon and made a contract.
 * 
 * @category Key Listener
 * @version 1.0
 * @since April 2017
 * @author saurabh.parihar
 *
 */
public class KeyDemon implements NativeKeyListener {

	private KeyContract contract;
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		this.contract.onKeyPressed(e.getKeyCode());
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		this.contract.onKeyReleased(e.getKeyCode());
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		this.contract.onKeyTyped(e.getKeyCode());
	}
	
	public void summon() {
		this.disableLoggers();
		try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
	}
	
	public void bind(KeyContract contract) {
		this.contract = contract;
		GlobalScreen.addNativeKeyListener(this);
	}
	
	public void dismiss()
	{
		try{
            GlobalScreen.unregisterNativeHook();
            System.out.println("KeyDemon dismissed...");
        }catch(Exception ex){
            System.err.println(ex);
        }  
	}
	
	private void disableLoggers() {
		// Clear previous logging configurations.
		LogManager.getLogManager().reset();
		// Get the logger for "org.jnativehook" and set the level to off.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
	}

}
