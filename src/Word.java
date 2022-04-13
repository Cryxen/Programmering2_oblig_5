import java.util.ArrayList;

public class Word {
        String norwegianWord;
        String englishWord;
        String wordClass;

        // Constructor
    public Word(String norwegianWord, String englishWord, String wordClass) {
        this.norwegianWord = norwegianWord;
        this.englishWord = englishWord;
        this.wordClass = wordClass;
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

    public String getWordClass() {
        return wordClass;
    }

    public void setWordClass(String wordClass) {
        this.wordClass = wordClass;
    }

    @Override
    public String toString() {
        return "Word{" +
                "norwegianWord='" + norwegianWord + '\'' +
                ", englishWord='" + englishWord + '\'' +
                ", wordClass='" + wordClass + '\'' +
                '}';
    }


}

