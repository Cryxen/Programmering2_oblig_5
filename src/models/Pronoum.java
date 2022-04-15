package models;

public class Pronoum extends Word{
    private String whichPronoum;

    // Constructor
    public Pronoum(String norwegianWord, String englishWord, Wordclass wordClass) {
        super(norwegianWord, englishWord, wordClass);
    }

    public String getWhichPronoum() {
        return whichPronoum;
    }

    public void setWhichPronoum(String whichPronoum) {
        this.whichPronoum = whichPronoum;
    }
}
