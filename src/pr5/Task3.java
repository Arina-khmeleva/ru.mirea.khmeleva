package pr5;

import javax.swing.*;
import java.io.File;

public class Task3 extends JFrame {

    public Task3(String path) {
        super("Image viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        if (path == null || path.isEmpty() || !new File(path).exists()) {
            add(new JLabel("Файл не найден: " + path, JLabel.CENTER));
            setSize(400, 150);
            setVisible(true);
            return;
        }

        ImageIcon icon = new ImageIcon(path);
        if (icon.getIconWidth() <= 0) {
            add(new JLabel("Не удалось загрузить изображение", JLabel.CENTER));
            setSize(400, 150);
        } else {
            add(new JLabel(icon));
        }
        pack();                          // подгоняем окно под картинку
        setLocationRelativeTo(null);     // центрируем
        setVisible(true);
    }

    public static void main(String[] args) {
        // В IntelliJ: Run → Edit Configurations… → Program arguments: C:\images\pic.jpg
        String path = (args.length > 0) ? args[0] : null;
        new Task3(path);
    }
}