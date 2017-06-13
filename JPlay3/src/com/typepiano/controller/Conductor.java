package com.typepiano.controller;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jnativehook.keyboard.NativeKeyEvent;

import com.typepiano.keys.KeyContract;
import com.typepiano.keys.KeyDemon;
import com.typepiano.reference.MusicFile;
import com.typepiano.sound.Player;
import com.typepiano.sound.Players;
import com.typepiano.util.Mapper;

/**
 * The main controller for this application.
 * It summons the KeyDemon, maps keys to notes
 * and loads all the players.
 * 
 * @category Controller
 * @version 2.0 (added logic to exit) 
 * @version 1.0
 * @since May 2017
 * @author saurabh.parihar
 * @see com.typepiano.keys.KeyContract
 * @see com.typepiano.util.Mapper
 */
public class Conductor implements KeyContract {

	private KeyDemon keyDemon;
	private Map<String, Player> players;
	private Set<String> pressedKeys;
	private boolean shiftPressed = false;	
	
	private Class<?> player;

	public Conductor(Players player) {
		this.setPlayer(player.getClassName());
		MusicFile.fileExtension = player.getExtension();
		this.initKeys();
		this.initPlayers();
	}
	
	public void start() {
		this.initKeyDemon();
	}
	
	@Override
	public void onKeyPressed(int keyCode) {
		if (isExitKey(keyCode)) {
			this.conclude();
		}
		checkShiftPressed(keyCode);
		String keyMap = Mapper.mapKey(keyCode, shiftPressed);
		if(!pressedKeys.contains(keyMap)) {
			pressedKeys.add(keyMap);
			Player note = players.get(keyMap);
			if(note != null) {
				note.play();
			}			
		}
	}

	@Override
	public void onKeyReleased(int keyCode) {
		checkShiftReleased(keyCode);
		String keyMap = Mapper.mapKey(keyCode, shiftPressed);
		if(pressedKeys.contains(keyMap)) {
			pressedKeys.remove(keyMap);
		}
	}

	@Override
	public void onKeyTyped(int keyCode) {
		// keyTyped listener not working..
	}
	
	private void initPlayers() {
		players = new HashMap<String, Player>();
		Mapper.mapPlayers(players, this.player);
	}
	
	private void initKeys() {
		pressedKeys = new HashSet<String>();
	}
	
	private void initKeyDemon() {
		this.keyDemon = new KeyDemon();
		keyDemon.summon();
		keyDemon.bind(this);
	}
	
	private void checkShiftPressed(int keyCode) {
		if (keyCode == NativeKeyEvent.VC_SHIFT_L || 
				keyCode == NativeKeyEvent.VC_SHIFT_R) {
			shiftPressed = true;
		}
	}
	
	private void checkShiftReleased(int keyCode) {
		if (keyCode == NativeKeyEvent.VC_SHIFT_L || 
				keyCode == NativeKeyEvent.VC_SHIFT_R) {
			shiftPressed = false;
		}
	}
	
	private boolean isExitKey(int keyCode) {
		return keyCode == NativeKeyEvent.VC_F9;
	}
	
	private void conclude() {
		this.keyDemon.dismiss();
	}
	
	public Class<?> getPlayer() {
		return player;
	}

	public void setPlayer(Class<?> player) {
		this.player = player;
	}
}
