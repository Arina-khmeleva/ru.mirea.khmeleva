package pract15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDemo extends JFrame {

    JTextArea textArea = new JTextArea();

    public MenuDemo() {
        super("Hello Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);

        // ---- Меню ----
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem pasteItem = new JMenuItem("Paste");
        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // ---- Обработчики меню (анонимные классы) ----
        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Saved (demo)");
            }
        });
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { System.exit(0); }
        });
        copyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { textArea.copy(); }
        });
        cutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { textArea.cut(); }
        });
        pasteItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { textArea.paste(); }
        });
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Menu demo v1.0");
            }
        });

        // ---- Кнопки (GridLayout) ----
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        buttonsPanel.add(b1);
        buttonsPanel.add(b2);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("Button 1 clicked\n");
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("Button 2 clicked\n");
            }
        });

        // ---- Текстовое поле ----
        textArea.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(textArea);

        // ---- Компоновка ----
        JPanel north = new JPanel(new BorderLayout());
        north.add(buttonsPanel, BorderLayout.NORTH);

        add(north, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuDemo();
    }
}