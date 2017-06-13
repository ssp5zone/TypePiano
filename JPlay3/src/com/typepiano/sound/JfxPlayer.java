package com.typepiano.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URISyntaxException;

import com.sun.javafx.application.PlatformImpl;

/**
 * A JFX player. It uses JavaFX libraries provided by Java 8.
 * It eliminates the missing notes problem of ClipPlayer. However, it's bulky and audibly slow.
 * If showing error. Set the Project->Properties->Project Facets->Java 1.8
 * 
 * @version 2.0 (get file as resource. JAR fix.)
 * @version 1.0
 * @category Player
 * @since June 2017
 * @author saurabh.parihar
 *
 */
public class JfxPlayer implements Player {

	Media media;
	MediaPlayer player;
	
	public JfxPlayer() {
		
	}
	
	public JfxPlayer(String file) {
		this();
		this.setMedia(file);
		PlatformImpl.startup(new Runnable() {
			@Override
			public void run() {
				player = new MediaPlayer(media);
				/**
				 * No extraordinary effect on performance
				 * Hence, commenting it.
				 */
				//player.setOnEndOfMedia(new Runnable() {
				//	@Override
				//	public void run() {
				//		player.stop();
				//		Duration duration = new Duration(0);
				//		player.seek(duration);
				//	}
				//	
				//});
			}
		});
	}
	
	@Override
	public void play(String file) {
		this.multiPlay(file);

	}

	@Override
	public void simplePlay(String file) {
		this.setMedia(file);
		this.player = new MediaPlayer(media);
		this.simplePlay();
	}

	@Override
	public void multiPlay(String file) {
		this.setMedia(file);
		this.player = new MediaPlayer(media);
		this.multiPlay();
	}

	@Override
	public void play() {
		this.multiPlay();
	}

	@Override
	public void simplePlay() {
		this.player.play();
	}

	@Override
	public void multiPlay() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Duration duration = new Duration(0);
				player.seek(duration);
				player.play();
			}
			
		}).start();	
	}
	
	private void setMedia(String source) {
		try {
			this.media = new Media(getClass().getResource(source).toURI().toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
