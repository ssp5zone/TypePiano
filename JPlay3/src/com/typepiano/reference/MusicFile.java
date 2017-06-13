package com.typepiano.reference;

/**
 * 
 * The base file that contains the full path of all music files.
 * Since there are 2 formats of files, an Enumeration was added.
 * 
 * @version 4.0 (updated relative path. JAR fix) 
 * @version 3.0 (added extension) 
 * @version 2.0 (added enum)
 * @since May 2017
 * @author saurabh.parihar
 *
 */
public class MusicFile {
	
	public static Extension fileExtension;
	
	static {
		fileExtension = Extension.MP3;
	}
	
	
	/**
	 * Contains all supported extensions the music file.
	 * The player must define which one of the extension it requires 
	 * in the Players list enum.
	 * 
	 * @see com.typepiano.sound.Players	 
	 * @version 1.0
	 * @since June 2017
	 * @author saurabh.parihar
	 *
	 */
	public static enum Extension {
		MP3 (".mp3"),
		WAV (".wav");
		
		private String value;
		
		Extension (String value) {
			this.value = value;
		}
		
		public String value() {
			return this.value;
		}
	}
	
	// the white keys (NOTES)	
	public final static String a1 = "/a1";
	public final static String a2 = "/a2";
	public final static String a3 = "/a3";
	public final static String a4 = "/a4";
	public final static String a5 = "/a5";
	public final static String a6 = "/a6";
	public final static String a7 = "/a7";
	public final static String a8 = "/a8";
	public final static String a9 = "/a9";
	public final static String a10 = "/a10";
	public final static String a11 = "/a11";
	public final static String a12 = "/a12";
	public final static String a13 = "/a13";
	public final static String a14 = "/a14";
	public final static String a15 = "/a15";
	public final static String a16 = "/a16";
	public final static String a17 = "/a17";
	public final static String a18 = "/a18";
	public final static String a19 = "/a19";
	public final static String a20 = "/a20";
	public final static String a21 = "/a21";
	public final static String a22 = "/a22";
	public final static String a23 = "/a23";
	public final static String a24 = "/a24";
	public final static String a25 = "/a25";
	public final static String a26 = "/a26";
	public final static String a27 = "/a27";
	public final static String a28 = "/a28";
	public final static String a29 = "/a29";
	public final static String a30 = "/a30";
	public final static String a31 = "/a31";
	public final static String a32 = "/a32";
	public final static String a33 = "/a33";
	public final static String a34 = "/a34";
	public final static String a35 = "/a35";
	public final static String a36 = "/a36";	

	// the black keys (SHARPS and INTERVALS)
	public final static String b1 = "/b1";
	public final static String b2 = "/b2";
	public final static String b3 = "/b3";
	public final static String b4 = "/b4";
	public final static String b5 = "/b5";
	public final static String b6 = "/b6";
	public final static String b7 = "/b7";
	public final static String b8 = "/b8";
	public final static String b9 = "/b9";
	public final static String b10 = "/b10";
	public final static String b11 = "/b11";
	public final static String b12 = "/b12";
	public final static String b13 = "/b13";
	public final static String b14 = "/b14";
	public final static String b15 = "/b15";
	public final static String b16 = "/b16";
	public final static String b17 = "/b17";
	public final static String b18 = "/b18";
	public final static String b19 = "/b19";
	public final static String b20 = "/b20";
	public final static String b21 = "/b21";
	public final static String b22 = "/b22";
	public final static String b23 = "/b23";
	public final static String b24 = "/b24";
	public final static String b25 = "/b25";
	
	public static String getFile(String file) {
		return file.concat(fileExtension.value());
	}
}
