package ie.tudublin;

import java.util.ArrayList;
import java.util.*;

import processing.core.PApplet;
import processing.data.*;;

public class DANI extends PApplet {

    String[] sonnet;
    HashMap<String, ArrayList<String>> wordFollows = new HashMap<>();

    public void settings() {
        size(1000, 1000);
    }

	// load the file
    public void loadFile() {
        sonnet = loadStrings("shakespere.txt");
        for (int i = 0; i < sonnet.length; i++) {
            String line = sonnet[i];
            String[] words = split(line, ' ');
            for (int j = 0; j < words.length - 1; j++) {
                String word = words[j].toLowerCase().replaceAll("[^\\w\\s]", "");
                String nextWord = words[j + 1].toLowerCase().replaceAll("[^\\w\\s]", "");

                ArrayList<String> follows = wordFollows.getOrDefault(word, new ArrayList<>());
                follows.add(nextWord);
                wordFollows.put(word, follows);
            }
        }
    }

	public void printModel()
	{
		String[] generateSonnet = writeSonnet();
        for (String line : generateSonnet) {
            System.out.println(line);
			
        }
		
		
	}

	// generating sonnet
    public String[] writeSonnet() {
        Random random = new Random();
        String[] generateSonnet = new String[14];
        ArrayList<String> words = new ArrayList<>(wordFollows.keySet());

        for (int i = 0; i < 14; i++) {

            StringBuilder line = new StringBuilder();
            String word = words.get(random.nextInt(words.size()));

            for (int j = 0; j < 8; j++) {
                line.append(word).append(" ");
                ArrayList<String> follows = wordFollows.get(word);

                if (follows == null || follows.isEmpty()) {
                    break;
                }
                word = follows.get(random.nextInt(follows.size()));
            }

            generateSonnet[i] = line.toString().trim();

			
        }
		text("" + words ,300,300);
		

        return generateSonnet;
    }

	public void keyPressed()
	{
		if (keyCode == ' '){
			// print new sonnet
			printModel();  
		}
	}

    public void setup() {
        colorMode(HSB);
        loadFile();
		printModel();
		//writeSonnet();
        
    }

    public void draw() {
        background(0);
        fill(255);
        noStroke();
        textSize(20);
        textAlign(CENTER, CENTER);

		writeSonnet();
		
    }


}
