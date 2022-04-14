import Tools.FileReader;
import forms.MainWindow;
import models.Word;
import models.Wordclass;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
             MainWindow window = new MainWindow();
            }
        });

//        // Create wordclasses
//        // Kilde til forklaring: Bordal, Guri; Hagemann, Kristin: substantiv i Store norske leksikon på snl.no.
//        // Hentet 13. april 2022 fra https://snl.no/substantiv
//        Wordclass substantiv = new Wordclass("substantiv", "Substantiv som ordklasse med ord som omhandler " +
//                "personer, ting og begreper. Les mer om substantiv her: https://snl.no/substantiv");
//
//        // Kilde til forklaring: Bordal, Guri; Hagemann, Kristin: pronomen i Store norske leksikon på snl.no.
//        // Hentet 13. april 2022 fra https://snl.no/pronomen
//        Wordclass pronomen = new Wordclass("pronomen", "Pronomen som ordklasse omhandler ord som benyttes" +
//                "i stedet for andre ord. Les mer om pronomen her: https://snl.no/pronomen");
//
//        // Kilde til forklaring: Hagemann, Kristin: adverb i Store norske leksikon på snl.no.
//        // Hentet 13. april 2022 fra https://snl.no/adverb
//        Wordclass adverb = new Wordclass("adverb", "Adverb er en ordklasse med ubøyelige ord " +
//                "som står til andre ord, og påvirker hva de betyr. Les mer om adverb her: https://snl.no/adverb");



//        // Open dictionary
//        FileReader fileReader = new FileReader();
//        File file = new File("csvFiles/dictionary.csv");
////        System.out.println(fileReader.readFromFile(file));
//
//
//        // Lager bare en liste med hver detalj. Vi ønsker å lage objekter.
//        String[] DictionaryFile;
//
//        DictionaryFile = fileReader.readFromFile(file).split(";");
////        models.Word[] Dictionary = new models.Word[DictionaryFile.length];
//        ArrayList<Word> dictionary = new ArrayList<>();
//        System.out.println(Arrays.toString(DictionaryFile));
//        int x = 3;
//        try {
//            for (int i = 0; i < DictionaryFile.length; i++) {
//                // Making sure the word gets the right wordclass when making object
//                if (Objects.equals(DictionaryFile[x + 2], "substantiv")) {
//                    dictionary.add(new Word(DictionaryFile[x], DictionaryFile[x + 1], substantiv));
//                }
//                else if (Objects.equals(DictionaryFile[x + 2], "pronomen")) {
//                    dictionary.add(new Word(DictionaryFile[x], DictionaryFile[x + 1], pronomen));
//                }
//                else if (Objects.equals(DictionaryFile[x + 2], "adverb")) {
//                    dictionary.add(new Word(DictionaryFile[x], DictionaryFile[x + 1], adverb));
//                }
//                else System.err.println("Something went wrong Creating objects from csv file: " + file);
//
//                if (x < DictionaryFile.length - 2) {
//                    x += 3;
//                } else if (x < DictionaryFile.length - 1) {
//                    x += 2;
//                } else
//                    x += 1;
//                System.out.println(x);
////            System.out.println(Dictionary);
//            }
//        } catch (ArrayIndexOutOfBoundsException exception) {
//            System.err.println(exception.getMessage());
//        }
//                models.Word newWord = new models.Word(DictionaryFile[0], DictionaryFile[1], DictionaryFile[2]);
//        System.out.println(newWord.toString());


    }




}



