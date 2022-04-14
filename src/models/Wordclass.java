package models;

public class Wordclass {
    String wordclass;
    String explanationOfClass;

//    Constructor
    public Wordclass(String wordclass, String explanationOfClass) {
        this.wordclass = wordclass;
        this.explanationOfClass = explanationOfClass;
    }

    public Wordclass() {

    }

    //Get and set
    public String getWordclass() {
        return wordclass;
    }

    public void setWordclass(String wordclass) {
        this.wordclass = wordclass;
    }

    public String getExplanationOfClass() {
        return explanationOfClass;
    }

    public void setExplanationOfClass(String explanationOfClass) {
        this.explanationOfClass = explanationOfClass;
    }

    @Override
    public String toString() {
        return "models.Wordclass{" +
                "wordclass='" + wordclass + '\'' +
                ", explanationOfClass='" + explanationOfClass + '\'' +
                '}';
    }
}
