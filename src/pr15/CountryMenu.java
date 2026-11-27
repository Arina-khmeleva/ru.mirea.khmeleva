package pract15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CountryMenu extends JFrame {

    JComboBox<String> combo;
    JTextArea info = new JTextArea(6, 30);

    public CountryMenu() {
        super("Hello Swing");
        setLayout(new FlowLayout());
        setSize(400, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] countries = {"Australia", "China", "England", "Russia"};
        combo = new JComboBox<>(countries);
        add(combo);

        // JTextArea в JScrollPane (замечание из методички)
        info.setEditable(false);
        add(new JScrollPane(info));

        // Вариант 1: ActionListener (по методичке)
        combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String c = (String) combo.getSelectedItem();
                info.setText(describe(c));
            }
        });

        // Вариант 2: ItemListener — тоже корректен для JComboBox
        combo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Selected: " + e.getItem());
                }
            }
        });

        setVisible(true);
    }

    private String describe(String country) {
        switch (country) {
            case "Australia": return "Australia — capital: Canberra, continent: Australia.";
            case "China":     return "China — capital: Beijing, continent: Asia.";
            case "England":   return "England — capital: London, part of the UK.";
            case "Russia":    return "Russia — capital: Moscow, largest country by area.";
            default:          return "Unknown country";
        }
    }

    public static void main(String[] args) {
        new CountryMenu();
    }
}