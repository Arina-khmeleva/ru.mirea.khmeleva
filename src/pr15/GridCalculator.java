package pract15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridCalculator extends JFrame {

    JTextField display = new JTextField();
    double firstOperand = 0;
    String pendingOp = null;
    boolean startNewNumber = true;

    public GridCalculator() {
        super("Simple Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(320, 260);
        setLayout(new BorderLayout(5, 5));

        // Дисплей
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        add(display, BorderLayout.NORTH);

        // Сетка кнопок
        JPanel grid = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] labels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onButton(e.getActionCommand());
            }
        };

        for (String label : labels) {
            JButton b = new JButton(label);
            b.setFont(new Font("Arial", Font.BOLD, 16));
            b.addActionListener(listener);   // один слушатель на все кнопки
            grid.add(b);
        }
        add(grid, BorderLayout.CENTER);

        setVisible(true);
    }

    private void onButton(String cmd) {
        if (cmd.matches("[0-9.]")) {
            if (startNewNumber) { display.setText(""); startNewNumber = false; }
            display.setText(display.getText() + cmd);
        } else if (cmd.equals("=")) {
            if (pendingOp != null) {
                double second = Double.parseDouble(display.getText().isEmpty() ? "0" : display.getText());
                double res = apply(firstOperand, second, pendingOp);
                display.setText(String.valueOf(res));
                pendingOp = null;
                startNewNumber = true;
            }
        } else { // + - * /
            if (!display.getText().isEmpty()) {
                firstOperand = Double.parseDouble(display.getText());
                pendingOp = cmd;
                startNewNumber = true;
            }
        }
    }

    private double apply(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b == 0 ? Double.NaN : a / b;
            default: return b;
        }
    }

    public static void main(String[] args) {
        new GridCalculator();
    }
}