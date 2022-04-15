package models;

public class Noun extends Word{
    private String gender;

    // Constructor
    public Noun(String norwegianWord, String englishWord, Wordclass wordClass) {
        super(norwegianWord, englishWord, wordClass);
    }

    // Getter and setter

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
