/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */


import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/* 1. Download the JavaZoom jar from here: http://bit.ly/javazoom
 * 2. Right click your project and add it as an External JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {

	JFrame frame = new JFrame();
	   JPanel panel = new JPanel();
	   JButton button = new JButton();
	   JButton button2 = new JButton();
	   JButton button3 = new JButton();
	   JButton button4 = new JButton();
	   Song song = new Song("VESTIGE - Elephant.mp3");
	   Song song1 = new Song("queen.mp3");
	   Song song2 = new Song("drake.mp3");
	   Song song3 = new Song("Thriller.mp3");
	   Song song4 = new Song("monstercat.mp3");
	   boolean x1 = false;
	   boolean x2 = false;
	   boolean x3 = false;
	   boolean x4 = false;
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Jukebox());
	}
	
           public void run() {
        	   
		// 3. Find an mp3 on your computer or on the Internet.
        	   
		// 4. Create a Song
        	  
        	   
		// 5. Play the Song
        	   song.play();
		/*
		 * 6. Create a user interface for your Jukebox so that the user can to
		 * choose which song to play. You can use can use a different button for
		 * each song, or a picture of the album cover. When the button or album
		 * cover is clicked, stop the currently playing song, and play the one
		 * that was selected.
		 */
        	   GridBagConstraints constraints = new GridBagConstraints();
        	   frame.setVisible(true);
        	   frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        	   frame.add(panel);
        	   constraints.gridx = 50;
        	   constraints.gridy = 50;
        	   panel.add(button, constraints);
        	   
        	   button.setText("Queen");
        	   constraints.gridx = 100;
        	   constraints.gridy = 50;
        	   panel.add(button2, constraints);
        	   
        	   button2.setText("Drake");
        	   constraints.gridx = 100;
        	   constraints.gridy = 50;
        	   panel.add(button3, constraints);
        	   
        	   button3.setText("Michael Jackson");
        	   constraints.gridx = 100;
        	   constraints.gridy = 100;
        	   panel.add(button4, constraints);
        	
        	   button4.setText("Monstercat");
        	   
        	  button.addActionListener(this);
        	   button2.addActionListener(this);
        	   button3.addActionListener(this);
        	   button4.addActionListener(this);
        	   frame.pack();
      
          }
	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 
		song.stop();
		song1.stop();
		song2.stop();
		song3.stop();
		song4.stop();
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		
		if(buttonPressed==button&&x1==false) {
		
			song1.play();
			x1=true;
		    x2 = false;
		    x3 = false;
		    x4 = false;
		}
		else if(buttonPressed==button2&&x2==false) {
			
			song2.play();
			x2=true;
			x1 = false;
		    x3 = false;
		    x4 = false;
		}
		else if(buttonPressed==button3&&x3==false) {
			
			song3.play();
			x3=true;
			x1 = false;
		    x2 = false;
		    x4 = false;
		}
		else if(buttonPressed==button4&&x4==false){
			
			song4.play();
			x4=true;
			x1 = false;
		    x2 = false;
		    x3 = false;
		}
		
		   
	}

}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet
	 * addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}

