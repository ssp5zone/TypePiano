package com.typepiano.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.jnativehook.keyboard.NativeKeyEvent;

import com.typepiano.reference.KeyMap;
import com.typepiano.reference.Note;
import com.typepiano.sound.Player;

/**
 * The main purpose of this class is to Map keys to Notes.
 * 
 * @since May 2017
 * @version 2.0 - Used reflection class to initialize different players on the go.
 * @version 1.0 - Added basic Map 
 * @author saurabh.parihar
 * @see com.typepiano.reference.Map
 *
 */
public class Mapper {

	public static String mapKey(char key, boolean shiftPressed) {
		// to do
		return "";
	}
	
	public static String mapKey(int keyCode, boolean shiftPressed) {
		switch(keyCode) {
			case NativeKeyEvent.VC_0: return KeyMap.KEY_0;
			case NativeKeyEvent.VC_1: return shiftPressed ? KeyMap.KEY_s1 : KeyMap.KEY_1;
			case NativeKeyEvent.VC_2: return shiftPressed ? KeyMap.KEY_s2 : KeyMap.KEY_2;
			case NativeKeyEvent.VC_3: return KeyMap.KEY_3;
			case NativeKeyEvent.VC_4: return shiftPressed ? KeyMap.KEY_s4 : KeyMap.KEY_4;
			case NativeKeyEvent.VC_5: return shiftPressed ? KeyMap.KEY_s5 : KeyMap.KEY_5;
			case NativeKeyEvent.VC_6: return shiftPressed ? KeyMap.KEY_s6 : KeyMap.KEY_6;
			case NativeKeyEvent.VC_7: return KeyMap.KEY_7;
			case NativeKeyEvent.VC_8: return shiftPressed ? KeyMap.KEY_s8 : KeyMap.KEY_8;
			case NativeKeyEvent.VC_9: return shiftPressed ? KeyMap.KEY_s9 : KeyMap.KEY_9;
			case NativeKeyEvent.VC_A: return KeyMap.KEY_A;
			case NativeKeyEvent.VC_B: return shiftPressed ? KeyMap.KEY_sB : KeyMap.KEY_B;
			case NativeKeyEvent.VC_C: return shiftPressed ? KeyMap.KEY_sC : KeyMap.KEY_C;
			case NativeKeyEvent.VC_D: return shiftPressed ? KeyMap.KEY_sD : KeyMap.KEY_D;
			case NativeKeyEvent.VC_E: return shiftPressed ? KeyMap.KEY_sE : KeyMap.KEY_E;
			case NativeKeyEvent.VC_F: return KeyMap.KEY_F;
			case NativeKeyEvent.VC_G: return shiftPressed ? KeyMap.KEY_sG : KeyMap.KEY_G;
			case NativeKeyEvent.VC_H: return shiftPressed ? KeyMap.KEY_sH : KeyMap.KEY_H;
			case NativeKeyEvent.VC_I: return shiftPressed ? KeyMap.KEY_sI : KeyMap.KEY_I;
			case NativeKeyEvent.VC_J: return shiftPressed ? KeyMap.KEY_sJ : KeyMap.KEY_J;
			case NativeKeyEvent.VC_K: return KeyMap.KEY_K;
			case NativeKeyEvent.VC_L: return shiftPressed ? KeyMap.KEY_sL : KeyMap.KEY_L;
			case NativeKeyEvent.VC_M: return KeyMap.KEY_M;
			case NativeKeyEvent.VC_N: return KeyMap.KEY_N;
			case NativeKeyEvent.VC_O: return shiftPressed ? KeyMap.KEY_sO : KeyMap.KEY_O;
			case NativeKeyEvent.VC_P: return shiftPressed ? KeyMap.KEY_sP : KeyMap.KEY_P;
			case NativeKeyEvent.VC_Q: return shiftPressed ? KeyMap.KEY_sQ : KeyMap.KEY_Q;
			case NativeKeyEvent.VC_R: return KeyMap.KEY_R;
			case NativeKeyEvent.VC_S: return shiftPressed ? KeyMap.KEY_sS : KeyMap.KEY_S;
			case NativeKeyEvent.VC_T: return shiftPressed ? KeyMap.KEY_sT : KeyMap.KEY_T;
			case NativeKeyEvent.VC_U: return KeyMap.KEY_U;
			case NativeKeyEvent.VC_V: return shiftPressed ? KeyMap.KEY_sV : KeyMap.KEY_V;
			case NativeKeyEvent.VC_W: return shiftPressed ? KeyMap.KEY_sW : KeyMap.KEY_W;
			case NativeKeyEvent.VC_X: return KeyMap.KEY_X;
			case NativeKeyEvent.VC_Y: return shiftPressed ? KeyMap.KEY_sY : KeyMap.KEY_Y;
			case NativeKeyEvent.VC_Z: return shiftPressed ? KeyMap.KEY_sZ : KeyMap.KEY_Z;
		}
		return "";
	}
	
	/**
	 * For this to work the player should have at-least a constructor which accepts fileName as args.
	 * @param players An empty Map of players which would be initialized with Note and its corresponding player. 
	 * @param player The Implementing Player Class which is to be used.
	 * @version 2.0
	 * @author saurabh.parihar
	 */
	public static void mapPlayers(Map<String, Player> players, Class<?> player) {
		try {
			players.put(KeyMap.KEY_0, (Player) (player.getConstructor(String.class).newInstance(Note.E17)));
			players.put(KeyMap.KEY_1, (Player) (player.getConstructor(String.class).newInstance(Note.C1)));
			players.put(KeyMap.KEY_2, (Player) (player.getConstructor(String.class).newInstance(Note.D3)));
			players.put(KeyMap.KEY_3, (Player) (player.getConstructor(String.class).newInstance(Note.E5)));
			players.put(KeyMap.KEY_4, (Player) (player.getConstructor(String.class).newInstance(Note.F6)));
			players.put(KeyMap.KEY_5, (Player) (player.getConstructor(String.class).newInstance(Note.G8)));
			players.put(KeyMap.KEY_6, (Player) (player.getConstructor(String.class).newInstance(Note.A10)));
			players.put(KeyMap.KEY_7, (Player) (player.getConstructor(String.class).newInstance(Note.B12)));
			players.put(KeyMap.KEY_8, (Player) (player.getConstructor(String.class).newInstance(Note.C13)));
			players.put(KeyMap.KEY_9, (Player) (player.getConstructor(String.class).newInstance(Note.D15)));
			players.put(KeyMap.KEY_A, (Player) (player.getConstructor(String.class).newInstance(Note.B36)));
			players.put(KeyMap.KEY_B, (Player) (player.getConstructor(String.class).newInstance(Note.A58)));
			players.put(KeyMap.KEY_C, (Player) (player.getConstructor(String.class).newInstance(Note.F54)));
			players.put(KeyMap.KEY_D, (Player) (player.getConstructor(String.class).newInstance(Note.D39)));
			players.put(KeyMap.KEY_E, (Player) (player.getConstructor(String.class).newInstance(Note.A22)));
			players.put(KeyMap.KEY_F, (Player) (player.getConstructor(String.class).newInstance(Note.E41)));
			players.put(KeyMap.KEY_G, (Player) (player.getConstructor(String.class).newInstance(Note.F42)));
			players.put(KeyMap.KEY_H, (Player) (player.getConstructor(String.class).newInstance(Note.G44)));
			players.put(KeyMap.KEY_I, (Player) (player.getConstructor(String.class).newInstance(Note.F30)));
			players.put(KeyMap.KEY_J, (Player) (player.getConstructor(String.class).newInstance(Note.A46)));
			players.put(KeyMap.KEY_K, (Player) (player.getConstructor(String.class).newInstance(Note.B48)));
			players.put(KeyMap.KEY_L, (Player) (player.getConstructor(String.class).newInstance(Note.C49)));
			players.put(KeyMap.KEY_M, (Player) (player.getConstructor(String.class).newInstance(Note.C61)));
			players.put(KeyMap.KEY_N, (Player) (player.getConstructor(String.class).newInstance(Note.B60)));
			players.put(KeyMap.KEY_O, (Player) (player.getConstructor(String.class).newInstance(Note.G32)));
			players.put(KeyMap.KEY_P, (Player) (player.getConstructor(String.class).newInstance(Note.A34)));
			players.put(KeyMap.KEY_Q, (Player) (player.getConstructor(String.class).newInstance(Note.F18)));
			players.put(KeyMap.KEY_R, (Player) (player.getConstructor(String.class).newInstance(Note.B24)));
			players.put(KeyMap.KEY_S, (Player) (player.getConstructor(String.class).newInstance(Note.C37)));
			players.put(KeyMap.KEY_T, (Player) (player.getConstructor(String.class).newInstance(Note.C25)));
			players.put(KeyMap.KEY_U, (Player) (player.getConstructor(String.class).newInstance(Note.E29)));
			players.put(KeyMap.KEY_V, (Player) (player.getConstructor(String.class).newInstance(Note.G56)));
			players.put(KeyMap.KEY_W, (Player) (player.getConstructor(String.class).newInstance(Note.G20)));
			players.put(KeyMap.KEY_X, (Player) (player.getConstructor(String.class).newInstance(Note.E53)));
			players.put(KeyMap.KEY_Y, (Player) (player.getConstructor(String.class).newInstance(Note.D27)));
			players.put(KeyMap.KEY_Z, (Player) (player.getConstructor(String.class).newInstance(Note.D51)));
			
			// shifted keys are sharps
			players.put(KeyMap.KEY_s1, (Player) (player.getConstructor(String.class).newInstance(Note.Cx2)));
			players.put(KeyMap.KEY_s2, (Player) (player.getConstructor(String.class).newInstance(Note.Dx4)));
			players.put(KeyMap.KEY_s4, (Player) (player.getConstructor(String.class).newInstance(Note.Fx7)));
			players.put(KeyMap.KEY_s5, (Player) (player.getConstructor(String.class).newInstance(Note.Gx9)));
			players.put(KeyMap.KEY_s6, (Player) (player.getConstructor(String.class).newInstance(Note.Ax11)));
			players.put(KeyMap.KEY_s8, (Player) (player.getConstructor(String.class).newInstance(Note.Cx14)));
			players.put(KeyMap.KEY_s9, (Player) (player.getConstructor(String.class).newInstance(Note.Dx16)));
			players.put(KeyMap.KEY_sB, (Player) (player.getConstructor(String.class).newInstance(Note.Ax59)));
			players.put(KeyMap.KEY_sC, (Player) (player.getConstructor(String.class).newInstance(Note.Fx55)));
			players.put(KeyMap.KEY_sD, (Player) (player.getConstructor(String.class).newInstance(Note.Dx40)));
			players.put(KeyMap.KEY_sE, (Player) (player.getConstructor(String.class).newInstance(Note.Ax23)));
			players.put(KeyMap.KEY_sG, (Player) (player.getConstructor(String.class).newInstance(Note.Fx43)));
			players.put(KeyMap.KEY_sH, (Player) (player.getConstructor(String.class).newInstance(Note.Gx45)));
			players.put(KeyMap.KEY_sI, (Player) (player.getConstructor(String.class).newInstance(Note.Fx31)));
			players.put(KeyMap.KEY_sJ, (Player) (player.getConstructor(String.class).newInstance(Note.Ax47)));
			players.put(KeyMap.KEY_sL, (Player) (player.getConstructor(String.class).newInstance(Note.Cx50)));
			players.put(KeyMap.KEY_sO, (Player) (player.getConstructor(String.class).newInstance(Note.Gx33)));
			players.put(KeyMap.KEY_sP, (Player) (player.getConstructor(String.class).newInstance(Note.Ax35)));
			players.put(KeyMap.KEY_sQ, (Player) (player.getConstructor(String.class).newInstance(Note.Fx19)));
			players.put(KeyMap.KEY_sS, (Player) (player.getConstructor(String.class).newInstance(Note.Cx38)));
			players.put(KeyMap.KEY_sT, (Player) (player.getConstructor(String.class).newInstance(Note.Cx26)));
			players.put(KeyMap.KEY_sV, (Player) (player.getConstructor(String.class).newInstance(Note.Gx57)));
			players.put(KeyMap.KEY_sW, (Player) (player.getConstructor(String.class).newInstance(Note.Gx21)));
			players.put(KeyMap.KEY_sY, (Player) (player.getConstructor(String.class).newInstance(Note.Dx28)));
			players.put(KeyMap.KEY_sZ, (Player) (player.getConstructor(String.class).newInstance(Note.Dx52)));
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
