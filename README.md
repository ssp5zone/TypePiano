# TypePiano

Play a piano as you type. Convert your computer keyboard into a musical keyboard.

## What is it?

An app that runs in the background and generates specific music notes for different keystroke combinations.

## Why is it?

This application is based on Virtual Piano.

![](/docs/piano.png)

Most similar music apps generate a sound that have exponential or cosine frequency responce. This is one of the rare ones who's notes follow a time-varying gaussian curve. 

In human language; it sounds very close to the real thing. Hence, this application has 3 major purpose,

1. Preserve the original project.
2. Make it offline.
3. Plug headphones in your school/college/office and play paino while pretending to work. 

## How does it work?

The project uses JNativeHook that leverages platform-dependent native code to create low-level system-wide hooks. These hooks capture your keystrokes no matter what application is currently running and is in focus.

Different key combinations are assigned a note, that is played via one of the implimented Player implimentation.

## Using Locally

If you want to run this project locally,

### Requirements

1. Java 7 or above
2. Windows 7,8 or 10

### Build

For the first download/clone of this repo,

1. Import the JPlay3 folder as a Java project using your IDE (Eclipse/Netbeans).
2. If the IDE does not detect the `lib` folder, then [add its contents as external jars](http://www.wikihow.com/Add-JARs-to-Project-Build-Paths-in-Eclipse-(Java)).
3. Add "resources" folder as a Source. In Eclipse: `Project -> Properties -> Java Build Path -> Source -> Add Folder`

### Run

To directly use it.

1. Download the jar from latest release.
1. Double click the jar. This will start the app in background (You can check this under processes in TaskManager).
2. Press a key anywhere, to hear a sound.
3. To stop the app. Press `F9` key.

### Changing Player

The current application has support for 4 different players. The `TinyPlayer` is used by default.

To modify this,
 
1. Check the currently supported players in _Players.java_
```java
public enum Players {
	CLIP_PLAYER (ClipPlayer.class, Extension.WAV),
	JFX_PLAYER (JfxPlayer.class, Extension.MP3),
	JACO_PLAYER (JaCoPlayer.class, Extension.MP3),
	TINY_PLAYER (TinyPlayer.class, Extension.WAV);
  ...
 }
 ```
 2. Open the file _TypePiano.java_.
 3. Update the player passed to _Conductor_.
 ```java
Conductor mainConductor = new Conductor(Players.TINY_PLAYER);
 ```
 4. Build the project.
 
### Key Map

The current version has keys `0-9` and `A-Z` mapped to the piano. Additinally, the sharp notes (_the black keys in the piano_) can be played by pressing `Shift+Key`. 

The current version covers **3 and a half octaves** as seen below.

![](/docs/keymap.png)

## Known Issues

* Using MP3 files has latency but they are very small in size for the same quality. Currently using WAV format instead.
* The `CLIP_PLAYER` misses notes.
* The `TINY_PLAYER` gives jitters sometimes.

## Licence

Licenced under GNU GENERAL PUBLIC LICENSE v3.0. It is free to copy and distribute.
