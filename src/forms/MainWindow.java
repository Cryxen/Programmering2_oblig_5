package forms;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow {
    public MainWindow() {
        // Create a new JFrame container.
        JFrame jFrame = new JFrame ("A Simple Swing Application");
        // Set jFrame layout to Flowlayout
        jFrame.setLayout(new FlowLayout());
        // Give the frame an initial size.
        jFrame.setSize(400, 400);

        // Terminate the program when the user closes the application.
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a text-based label.
        JLabel jLblHeadliner = new JLabel("Lag din egen Engelsk-Norsk ordbok.");

        // Create a list
        JList jListDictionary = new JList<String>();

        // Make the list scrollable
        JScrollPane jScrollPane = new JScrollPane(jListDictionary);

        // Add the items to the content pane
        jFrame.add(jLblHeadliner);
        jFrame.add(jListDictionary);

        // Display the frame
        jFrame.setVisible(true);
    }
// TODO populate String
    public  populateList (ArrayList<String> listItems) {
        JList<String> jList = new JList<String>(listItems);


    }
    }

