package forms;

import Tools.FileReader;
import models.Word;
import models.Wordclass;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.File;
import java.util.Objects;

public class MainWindow implements ListSelectionListener {

    //Jlists
    private JList<Word> dictionaryJList;
    private JList<String> norwegianWordsJlist;
    private JList<String> englishWordsJlist;
    private JList<String> wordClassesJlist;

    //Default lists
    private DefaultListModel<Word> dictionary = new DefaultListModel<>();
    private DefaultListModel<String> norwegianWords = new DefaultListModel<>();
    private DefaultListModel<String> englishWords = new DefaultListModel<>();
    private DefaultListModel<String> wordClasses = new DefaultListModel<>();

    //JLabels
    private JLabel englishTranslation;
    private JLabel englishTranslationHeadliner;

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

        // Populate the list with norwegian word and english word
        norwegianWords = listNorwegianWords(dictionary);
        englishWords = listEnglishWords(dictionary);
        wordClasses = listWordclasses(dictionary);

    }


    public MainWindow() {
        String[] testString = {"test1", "test2", "test3"};
        // Create a new JFrame container.
        JFrame jMainFrame = new JFrame ("A Simple Swing Application");
        // Set jFrame layout to Flowlayout
        jMainFrame.setLayout(new FlowLayout());
        // Give the frame an initial size.
        jMainFrame.setSize(400, 400);


        //splitPane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);



        //JLists
        dictionaryJList = new JList<Word>(dictionary);
        norwegianWordsJlist = new JList<>(norwegianWords);
        englishWordsJlist = new JList<>(englishWords);
        wordClassesJlist = new JList<>(wordClasses);

        //Make the JList single touch and give action call
        norwegianWordsJlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        norwegianWordsJlist.addListSelectionListener(this);

        // Make all Jlists scrollable
        JScrollPane jScrlpnNorwegianWords = new JScrollPane(norwegianWordsJlist);
        JScrollPane jScrlpnEnglishWords = new JScrollPane(englishWordsJlist);
        JScrollPane jScrlpnWordClasses = new JScrollPane(wordClassesJlist);

        // Terminate the program when the user closes the application.
        jMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Create a text-based label.
        JLabel jLblHeadliner = new JLabel("Lag din egen Engelsk-Norsk ordbok.");
        englishTranslationHeadliner = new JLabel("Engelsk oversettelse");
        englishTranslation = new JLabel("");


        // Add the items to the content pane
        jMainFrame.add(jLblHeadliner);
//        jMainFrame.add(jScrlpnNorwegianWords);
//        jNorwegianFrame.add(jScrlpnNorwegianWords);
        jMainFrame.add(splitPane);
        splitPane.setLeftComponent(jScrlpnNorwegianWords);
//        splitPane.setRightComponent(englishTranslationHeadliner);
        splitPane.setRightComponent(englishTranslation);
//        jMainFrame.add(jScrlpnWordClasses);


        // Display the frame
        jMainFrame.setVisible(true);
        System.out.println(listNorwegianWords(dictionary));
    }

    // Static functions to retrieve list with norwegian, english and wordclass.
    // TODO: Consider refactoring to different file or place.
    public static DefaultListModel<String> listNorwegianWords(DefaultListModel<Word>  dictionary) {
        DefaultListModel<String> words = new DefaultListModel<>();
        for (int i = 0; i <dictionary.getSize(); i++) {
              words.addElement(dictionary.get(i).getNorwegianWord());
        }
        return words;
    }

    public static DefaultListModel<String> listEnglishWords(DefaultListModel<Word>  dictionary) {
        DefaultListModel<String> words = new DefaultListModel<>();
        for (int i = 0; i <dictionary.getSize(); i++) {
            words.addElement(dictionary.get(i).getEnglishWord());
        }
        return words;
    }
    public static DefaultListModel<String>  listWordclasses(DefaultListModel<Word>  dictionary) {
        DefaultListModel<String> words = new DefaultListModel<>();
        for (int i = 0; i <dictionary.getSize(); i++) {
            words.addElement(dictionary.get(i).getWordclass());
        }
        return words;
    }

    public void valueChanged (ListSelectionEvent le) {
        int index = norwegianWordsJlist.getSelectedIndex();
        System.out.println(dictionary.get(index));
        englishTranslation.setText(dictionary.get(index).getEnglishWord());
    }

    }

