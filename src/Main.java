import Tools.FileReader;
import forms.MainWindow;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Main {
   void main(String[] args) {
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
        String[] dictionary;
        dictionary = fileReader.readFromFile(file).split(";");
//        System.out.println(dictionary[1]);

        for (int i = 0; i < dictionary.length ; i += 2) {

        }
    }
}
