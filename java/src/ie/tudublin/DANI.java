package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;

public class DANI extends PApplet {

	String[] sonnet;

	public void settings() {
		size(1000, 1000);
		// fullScreen(SPAN);
	}

	public String[] writeSonnet() {
		return null;
	}

	public void loadFile() {
		sonnet = loadStrings("small.txt"); // Load a text file into a String array
		for (int i = 0; i < sonnet.length; i++) {
			String line = sonnet[i];
			String[] words = split(line, ' '); // Split a string into an array of words
			for (int j = 0; j < words.length; j++) {
				String word = words[j];
				String w = word.replaceAll("[^\\w\\s]", ""); // Remove punctuation characters
				String s = w.toLowerCase(); // Convert a string to lower case
				words[j] = s;
			}
			sonnet[i] = join(words, ' ');
		}
	}

	public boolean findWord(String searchWord) {
		for (String word : sonnet) {
			if (word.equalsIgnoreCase(searchWord)) {
				return true;
			}
		}
		return false;
	}

	public void printModel() {
		for (String line : sonnet) {
			System.out.println(line);
		}
	}

	public void setup() {
		colorMode(HSB);
		loadFile();
		printModel(); // Call printModel() to print the loaded file
	}

	public void keyPressed() {

	}

	float off = 0;

	public void draw() {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
		textAlign(CENTER, CENTER);
	}

}
