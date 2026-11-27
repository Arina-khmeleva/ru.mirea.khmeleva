package pr5;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Task4 extends JFrame {

    private final JLabel label = new JLabel("", JLabel.CENTER);
    private final List<ImageIcon> frames = new ArrayList<>();
    private int index = 0;

    public Task4(String dir) {
        super("Animation");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // 1. Пытаемся загрузить кадры из папки (если путь передан)
        if (dir != null && !dir.isEmpty()) {
            File folder = new File(dir);
            if (folder.exists() && folder.isDirectory()) {
                // Ищем файлы frame1.png, frame2.png и т.д.
                for (int i = 1; i <= 50; i++) {
                    File f = new File(folder, "frame" + i + ".png");
                    if (!f.exists()) break; // если кадры закончились
                    ImageIcon icon = new ImageIcon(f.getAbsolutePath());
                    if (icon.getIconWidth() > 0) {
                        frames.add(icon);
                    }
                }
            }
        }

        // 2. Если кадров нет (или папка не указана) — генерируем программные кадры
        if (frames.isEmpty()) {
            int totalFrames = 20;
            for (int i = 0; i < totalFrames; i++) {
                frames.add(makeFrame(i, totalFrames, 380, 380));
            }
        }

        add(label);
        label.setIcon(frames.get(0));

        // 3. Таймер для анимации (переключает кадры каждые 100 мс)
        Timer timer = new Timer(100, e -> {
            index = (index + 1) % frames.size(); // зацикливаем
            label.setIcon(frames.get(index));
        });
        timer.start();

        setVisible(true);
    }

    /** Метод рисует один программный кадр (синий круг, который катится) */
    private static ImageIcon makeFrame(int frame, int total, int w, int h) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();

        // Включаем сглаживание для красоты
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Белый фон
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);

        // Вычисляем позицию круга (от левого края до правого)
        int x = (int) ((double) frame / total * (w - 60));
        int y = h / 2 - 30;

        // Рисуем круг
        g.setColor(new Color(30, 120, 220)); // Синий цвет
        g.fillOval(x, y, 60, 60);

        // Подпись кадра
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("Кадр: " + (frame + 1) + " / " + total, 15, 25);

        g.dispose();
        return new ImageIcon(img);
    }

    public static void main(String[] args) {
        // Если передан путь к папке с картинками в аргументах — используем его
        String dir = (args.length > 0) ? args[0] : null;
        new Task4(dir);
    }
}