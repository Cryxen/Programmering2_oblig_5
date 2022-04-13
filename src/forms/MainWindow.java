package forms;

import javax.swing.*;

public class MainWindow {
    public MainWindow() {
        // Create a new JFrame container.
        JFrame jfrm = new JFrame ("A Simple Swing Application");

        // Give the frame an initial size.
        jfrm.setSize(275, 100);

        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a text-based label.
        JLabel jlab = new JLabel("GUI Programming with Swing");

        // Add the label to the content pane
        jfrm.add(jlab);

        // Display the frame
        jfrm.setVisible(true);
    }
    }

