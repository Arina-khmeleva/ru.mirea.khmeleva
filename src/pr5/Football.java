package pr5;

import javax.swing.*;
import java.awt.*;

public class Football extends JFrame {
    private int milanScore = 0;
    private int madridScore = 0;

    private JLabel resultLabel = new JLabel("Result: 0 X 0");
    private JLabel scorerLabel = new JLabel("Last Scorer: N/A");
    private JLabel winnerLabel = new JLabel("Winner: DRAW");

    public Football() {
        super("AC Milan vs Real Madrid");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 5, 5)); // 5 строк
        setSize(320, 220);

        JButton milanBtn = new JButton("AC Milan");
        JButton madridBtn = new JButton("Real Madrid");

        // Шрифт для читаемости
        Font f = new Font("Arial", Font.BOLD, 14);
        resultLabel.setFont(f);
        scorerLabel.setFont(f);
        winnerLabel.setFont(f);
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        scorerLabel.setHorizontalAlignment(JLabel.CENTER);
        winnerLabel.setHorizontalAlignment(JLabel.CENTER);

        add(milanBtn);
        add(madridBtn);
        add(resultLabel);
        add(scorerLabel);
        add(winnerLabel);

        // Обработчики (анонимные классы через лямбда-синтаксис)
        milanBtn.addActionListener(e -> {
            milanScore++;
            scorerLabel.setText("Last Scorer: AC Milan");
            updateLabels();
        });
        madridBtn.addActionListener(e -> {
            madridScore++;
            scorerLabel.setText("Last Scorer: Real Madrid");
            updateLabels();
        });

        setVisible(true);
    }

    private void updateLabels() {
        resultLabel.setText("Result: " + milanScore + " X " + madridScore);
        if (milanScore > madridScore) {
            winnerLabel.setText("Winner: AC Milan");
        } else if (madridScore > milanScore) {
            winnerLabel.setText("Winner: Real Madrid");
        } else {
            winnerLabel.setText("Winner: DRAW");
        }
    }

    public static void main(String[] args) {
        new Football();
    }
}
