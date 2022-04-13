import Tools.FileReader;
import forms.MainWindow;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;



public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });

        // Open dictionary
        FileReader fileReader = new FileReader();
        File file = new File("csvFiles/dictionary.csv");
//        System.out.println(fileReader.readFromFile(file));


        // Lager bare en liste med hver detalj. Vi ønsker å lage objekter.
        String[] DictionaryFile;

        DictionaryFile = fileReader.readFromFile(file).split(";");
//        Word[] Dictionary = new Word[DictionaryFile.length];
        ArrayList<Word> Dictionary = new ArrayList<>();
        System.out.println(Arrays.toString(DictionaryFile));
        int x = 3;
        try {
            for (int i = 0; i < DictionaryFile.length; i++) {
                Dictionary.add(new Word(DictionaryFile[x], DictionaryFile[x + 1], DictionaryFile[x + 2]));
//            System.out.println(DictionaryFile[x] + ", " + DictionaryFile[x+1]);
                if (x < DictionaryFile.length - 2) {
                    x += 3;
                } else if (x < DictionaryFile.length - 1) {
                    x += 2;
                } else
                    x += 1;
                System.out.println(x);
//            System.out.println(Dictionary);
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.err.println(exception.getMessage());
        }
//                Word newWord = new Word(DictionaryFile[0], DictionaryFile[1], DictionaryFile[2]);
//        System.out.println(newWord.toString());

        System.out.println(listNorwegianWords(Dictionary));
        System.out.println(listEnglishWords(Dictionary));
    }

    public static ArrayList<String> listNorwegianWords(ArrayList<Word> dictionary) {
        ArrayList<String> words = new ArrayList<>();
        for (Word word: dictionary
        ) {
            words.add(word.norwegianWord);
        }
        return words;
    }

    public static ArrayList<String> listEnglishWords(ArrayList<Word> dictionary) {
        ArrayList<String> words = new ArrayList<>();
        for (Word word: dictionary
        ) {
            words.add(word.englishWord);
        }
        return words;
    }
}



