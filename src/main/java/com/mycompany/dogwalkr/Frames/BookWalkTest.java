package com.mycompany.dogwalkr.Frames;

public class BookWalkTest {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame f = new javax.swing.JFrame("Book Walk Test");
            f.add(new Book_Walk_Panel());
            f.pack();
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
    }
}