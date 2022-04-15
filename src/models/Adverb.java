package models;

public class Adverb extends Word{
    private Boolean bendableAdverb;
    // Constructor
    public Adverb(String norwegianWord, String englishWord, Wordclass wordClass) {
        super(norwegianWord, englishWord, wordClass);
        bendableAdverb = true;
    }
    // Getter and setter


    public Boolean getBendableAdverb() {
        return bendableAdverb;
    }

    public void setBendableAdverb(Boolean bendableAdverb) {
        this.bendableAdverb = bendableAdverb;
    }
}
