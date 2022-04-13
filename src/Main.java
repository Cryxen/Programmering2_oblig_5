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

        // Kilde til forklaring: Bordal, Guri; Hagemann, Kristin: substantiv i Store norske leksikon på snl.no.
        // Hentet 13. april 2022 fra https://snl.no/substantiv
        Wordclass substantiv = new Wordclass("substantiv", "Substantiv som ordklasse med ord som omhandler " +
                "personer, ting og begreper. Les mer om substantiv her: https://snl.no/substantiv");

        // Kilde til forklaring: Bordal, Guri; Hagemann, Kristin: pronomen i Store norske leksikon på snl.no.
        // Hentet 13. april 2022 fra https://snl.no/pronomen
        Wordclass pronomen = new Wordclass("pronomen", "Pronomen som ordklasse omhandler ord som benyttes" +
                "i stedet for andre ord. Les mer om pronomen her: https://snl.no/pronomen");

        // Kilde til forklaring: Hagemann, Kristin: adverb i Store norske leksikon på snl.no.
        // Hentet 13. april 2022 fra https://snl.no/adverb
        Wordclass adverb = new Wordclass("adverb", "Adverb er en ordklasse med ubøyelige ord " +
                "som står til andre ord, og påvirker hva de betyr. Les mer om adverb her: https://snl.no/adverb")
    }

    // Static functions to retrieve list with norwegian, english and wordclass.
    // TODO: Consider refactoring to different file or place.
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
    public static ArrayList<String> listWordclasses(ArrayList<Word> dictionary) {
        ArrayList<String> words = new ArrayList<>();
        for (Word word: dictionary
        ) {
            words.add(word.wordClass);
        }
        return words;
    }
}



