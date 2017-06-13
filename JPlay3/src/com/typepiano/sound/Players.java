package com.typepiano.sound;

import com.typepiano.reference.MusicFile.Extension;

/**
 * An enumeration of all the available players and the file type they support.
 * If adding a new player, make an entry here and use that in Main class.
 * 
 * @since May 2017
 * @category Support
 * @version 1.0
 * @author saurabh.parihar
 *
 */
public enum Players {
	CLIP_PLAYER (ClipPlayer.class, Extension.WAV),
	JFX_PLAYER (JfxPlayer.class, Extension.MP3),
	JACO_PLAYER (JaCoPlayer.class, Extension.MP3),
	TINY_PLAYER (TinyPlayer.class, Extension.WAV);
	
	private Class<?> className;
	private Extension extension;
	
	Players(Class<?> className, Extension extension) {
		this.className = className;
		this.extension = extension;
	}
	
	public Class<?> getClassName() {
		return this.className;
	}
	
	public Extension getExtension() {
		return this.extension;
	}
}
