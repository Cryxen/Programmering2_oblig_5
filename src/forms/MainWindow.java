package forms;

import Tools.FileReader;
import models.Word;
import models.Wordclass;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Objects;

public class MainWindow implements ListSelectionListener, ActionListener {

    // Uncertain what it does: https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/GridBagLayoutDemoProject/src/layout/GridBagLayoutDemo.java
    final static boolean shouldFill = true;

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
    private JLabel emptyJLabel;
    private JLabel wordclassInformation;

    //int
    private int placeInList;

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
        // Set jFrame layout to gridBagLayout
        jMainFrame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        if (shouldFill) {
            constraints.fill = GridBagConstraints.HORIZONTAL;
        }

        // Give the frame an initial size.
        jMainFrame.setSize(400, 400);
//


        //JLists
//        dictionaryJList = new JList<Word>(dictionary);
        norwegianWordsJlist = new JList<>(norwegianWords);
//        englishWordsJlist = new JList<>(englishWords);
//        wordClassesJlist = new JList<>(wordClasses);


        //Make the JList single touch and give action call
        norwegianWordsJlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        norwegianWordsJlist.addListSelectionListener(this);


        // Make all Jlists scrollable
        JScrollPane jScrlpnNorwegianWords = new JScrollPane(norwegianWordsJlist);
        jScrlpnNorwegianWords.setPreferredSize(new Dimension(200,90));
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 2;
        jMainFrame.add(jScrlpnNorwegianWords, constraints);

        JScrollPane jScrlpnEnglishWords = new JScrollPane(englishWordsJlist);
        JScrollPane jScrlpnWordClasses = new JScrollPane(wordClassesJlist);

        // Terminate the program when the user closes the application.
        jMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Label headliner
        JLabel jLblHeadliner = new JLabel("Lag din egen Engelsk-Norsk ordbok.");
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 0;
        jMainFrame.add(jLblHeadliner, constraints);




        //JLabel that shows the english headline "Engelsk Oversettelse"
        englishTranslationHeadliner = new JLabel("Engelsk oversettelse");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 1;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 1;
        jMainFrame.add(englishTranslationHeadliner, constraints);

        // English translation that shows when word is pressed.
        englishTranslation = new JLabel(""); // Gets filled in when jscrlpnNorwegianWord is pressed
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.BOTH;
        jMainFrame.add(englishTranslation, constraints);

        wordclassInformation = new JLabel("");
        constraints.gridx = 1;
        constraints.gridy = 3;
        jMainFrame.add(wordclassInformation, constraints);

        // Make a "Learn more about wordclass button
        JButton learnWordClass = new JButton("Lær mer om ordklassen");
        constraints.gridx = 0;
        constraints.gridy = 3;
        jMainFrame.add(learnWordClass, constraints);

        learnWordClass.addActionListener(this);

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
            words.addElement(dictionary.get(i).getExplanationOfClass());
        }
        return words;
    }

    public void valueChanged (ListSelectionEvent le) {
        int index = norwegianWordsJlist.getSelectedIndex();
//        System.out.println(dictionary.get(index));
//        System.out.println(substantiv.getWordclass());
        if (dictionary.get(index).getWordclass().contains("substantiv")) {
            englishTranslation.setText("<html>" + "<blockquote>" + dictionary.get(index).getEnglishWord() + "<br />" +
                    "Ordklasse: Substantiv"+ "</blockquote>" +"</html>");
        }
        else if (dictionary.get(index).getWordclass().contains("pronomen")) {
            englishTranslation.setText("<html>" + "<blockquote>" + dictionary.get(index).getEnglishWord() +
                    "<br />" + "Ordklasse: Pronomen" + "</blockquote>" + "</html>");
        }
        else if (dictionary.get(index).getWordclass().contains("adverb")) {
            englishTranslation.setText("<html>" + "<blockquote>" + dictionary.get(index).getEnglishWord() + "<br />" +
                    "Ordklasse: Adverb" + "</blockquote>" + "</html>");
        }
        else {
            englishTranslation.setText(dictionary.get(index).getEnglishWord() + " ");
            System.out.println("no hits");
            System.out.println(dictionary.get(index).getWordclass());
        }

        placeInList = index;

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Lær mer om ordklassen")) {
            System.out.println("Knapp trykket på.");
//            int index = dictionary.indexOf(englishTranslation);

            if (dictionary.get(placeInList).getWordclass().contains("substantiv")){
                wordclassInformation.setText("<html>" + substantiv.getExplanationOfClass() + "</html>");
            }
            else if (dictionary.get(placeInList).getWordclass().contains("pronomen"))
                wordclassInformation.setText("<html>" + pronomen.getExplanationOfClass()+ "</html>");
            else if (dictionary.get(placeInList).getWordclass().contains("adverb"))
                wordclassInformation.setText("<html>" + adverb.getExplanationOfClass()+ "</html>");
            else wordclassInformation.setText("Ingen treff på ordklasse");

            System.out.println(pronomen.getExplanationOfClass());
            System.out.println(dictionary.get(placeInList).getWordclass());
        }
    }
    }

