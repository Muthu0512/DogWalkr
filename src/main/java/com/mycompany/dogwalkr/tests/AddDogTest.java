package com.mycompany.dogwalkr.tests;

import com.mycompany.dogwalkr.ui.owner.AddDogPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AddDogTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Add Dog Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new AddDogPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}