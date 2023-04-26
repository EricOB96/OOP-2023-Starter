package ie.tudublin;

import java.util.ArrayList;

public class Word {
    // varibles
    private String word;
    private ArrayList<Follow> follows;

    public Word(String word, ArrayList<Follow> follows) {
        this.word = word;
        this.follows = follows;
    }

    public String getWord() {
        return word;
    }

    public ArrayList<Follow> getFollows() {
        return follows;
    }

    @Override
    public String toString() {
        StringBuilder sm = new StringBuilder();
        sm.append("Word: ").append(word).append("");
        sm.append("Follows: ");
        for (Follow follow : follows) {
            sm.append("\t").append(follow.toString()).append("");
        }
        return sm.toString();
    }
}
