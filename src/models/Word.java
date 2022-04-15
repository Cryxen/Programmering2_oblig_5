package models;

import Tools.FileReader;

import java.io.File;

public class Word extends Wordclass {
    String norwegianWord;
    String englishWord;



    // Constructor
    public Word(String norwegianWord, String englishWord, Wordclass wordClass) {
        super();
        setWordclass(String.valueOf(wordClass));
        this.norwegianWord = norwegianWord;
        this.englishWord = englishWord;
    }


    // Get and Set
    public String getNorwegianWord() {
        return norwegianWord;
    }

    public void setNorwegianWord(String norwegianWord) {
        this.norwegianWord = norwegianWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    @Override
    public String getWordclass() {
        return super.getWordclass();
    }

    @Override
    public String toString() {
        return "models.Word{" +
                "norwegianWord='" + norwegianWord + '\'' +
                ", englishWord='" + englishWord + '\'' +
                ", wordClass='" + getWordclass() + '\'' +
                '}';
    }
}



