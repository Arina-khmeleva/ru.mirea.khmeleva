package pract15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    JTextField num1 = new JTextField(10);
    JTextField num2 = new JTextField(10);
    JButton addBtn = new JButton("+");
    JButton subBtn = new JButton("-");
    JButton mulBtn = new JButton("*");
    JButton divBtn = new JButton("/");

    Calculator() {
        super("Calculator");
        setLayout(new FlowLayout());
        setSize(320, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("1st Number")); add(num1);
        add(new JLabel("2nd Number")); add(num2);
        add(addBtn); add(subBtn); add(mulBtn); add(divBtn);

        // Анонимный класс-слушатель для каждой кнопки (листинг 15.6)
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { calc('+'); }
        });
        subBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { calc('-'); }
        });
        mulBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { calc('*'); }
        });
        divBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { calc('/'); }
        });

        setVisible(true);
    }

    private void calc(char op) {
        try {
            double x1 = Double.parseDouble(num1.getText().trim());
            double x2 = Double.parseDouble(num2.getText().trim());
            double res;
            switch (op) {
                case '+': res = x1 + x2; break;
                case '-': res = x1 - x2; break;
                case '*': res = x1 * x2; break;
                case '/':
                    if (x2 == 0) {
                        JOptionPane.showMessageDialog(null, "Division by zero!",
                                "alert", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    res = x1 / x2; break;
                default: return;
            }
            JOptionPane.showMessageDialog(null, "Result = " + res,
                    "Alert", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Numbers !",
                    "alert", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}