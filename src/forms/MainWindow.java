package forms;

import Tools.FileReader;
import models.Word;
import models.Wordclass;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MainWindow {

    private JList<Word> dictionaryList;
    private DefaultListModel<Word> dictionary = new DefaultListModel<>();

    // Create wordclasses
    // Create wordclasses
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
            "som står til andre ord, og påvirker hva de betyr. Les mer om adverb her: https://snl.no/adverb");


    // Populate Dictionary here
    // Open dictionary
    FileReader fileReader = new FileReader();
    File file = new File("csvFiles/dictionary.csv");
//        System.out.println(fileReader.readFromFile(file));


    // Lager bare en liste med hver detalj. Vi ønsker å lage objekter.
    String[] DictionaryFile = fileReader.readFromFile(file).split(";");
    int x = 0;
{
    for (int i = 0; i < DictionaryFile.length / 3; i++) {
        // Making sure the word gets the right wordclass when making object
        if (Objects.equals(DictionaryFile[x + 2], "substantiv")) {
            dictionary.addElement(new Word(DictionaryFile[x], DictionaryFile[x + 1], substantiv));
        } else if (Objects.equals(DictionaryFile[x + 2], "pronomen")) {
            dictionary.addElement(new Word(DictionaryFile[x], DictionaryFile[x + 1], pronomen));
        } else if (Objects.equals(DictionaryFile[x + 2], "adverb")) {
            dictionary.addElement(new Word(DictionaryFile[x], DictionaryFile[x + 1], adverb));
        } else System.err.println("Something went wrong Creating objects from csv file: " + file);

        if (x < 15) {
            x += 3;
        }
    }
    System.out.println(dictionary);
}

    public MainWindow() {
        String[] testString = {"test1", "test2", "test3"};
        // Create a new JFrame container.
        JFrame jFrame = new JFrame ("A Simple Swing Application");
        // Set jFrame layout to Flowlayout
        jFrame.setLayout(new FlowLayout());
        // Give the frame an initial size.
        jFrame.setSize(400, 400);

        dictionaryList = new JList<Word>(dictionary);
        // Terminate the program when the user closes the application.
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create a text-based label.
//        JLabel jLblHeadliner = new JLabel();
        JLabel jLblHeadliner = new JLabel("Lag din egen Engelsk-Norsk ordbok.");

        // Make the list scrollable
//        JScrollPane jScrollPane = new JScrollPane(jListDictionary);

        // Add the items to the content pane
        jFrame.add(jLblHeadliner);
        jFrame.add(dictionaryList);

        // Display the frame
        jFrame.setVisible(true);



    }

    // Static functions to retrieve list with norwegian, english and wordclass.
    // TODO: Consider refactoring to different file or place.
    public static ArrayList<String> listNorwegianWords(ArrayList<Word> dictionary) {
        ArrayList<String> words = new ArrayList<>();
        for (Word word: dictionary
        ) {
            words.add(word.getNorwegianWord());
        }
        return words;
    }

    public static ArrayList<String> listEnglishWords(ArrayList<Word> dictionary) {
        ArrayList<String> words = new ArrayList<>();
        for (Word word: dictionary
        ) {
            words.add(word.getEnglishWord());
        }
        return words;
    }
    public static ArrayList<String> listWordclasses(ArrayList<Word> dictionary) {
        ArrayList<String> words = new ArrayList<>();
        for (Word word: dictionary
        ) {
            words.add(word.getWordclass());
        }
        return words;
    }
    }

