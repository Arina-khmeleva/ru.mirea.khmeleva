package pr5;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Task2 extends JFrame {

    // ---------- Абстрактный базовый класс ----------
    static abstract class Shape {
        protected Color color;
        protected int x, y;

        public Shape(Color color, int x, int y) {
            this.color = color;
            this.x = x;
            this.y = y;
        }

        // Абстрактный метод рисования — у каждой фигуры свой
        public abstract void draw(Graphics g);
    }

    static class CircleShape extends Shape {
        private final int r;
        public CircleShape(Color color, int x, int y, int r) {
            super(color, x, y);
            this.r = r;
        }
        @Override
        public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, 2 * r, 2 * r);
        }
    }

    static class RectShape extends Shape {
        private final int w, h;
        public RectShape(Color color, int x, int y, int w, int h) {
            super(color, x, y);
            this.w = w;
            this.h = h;
        }
        @Override
        public void draw(Graphics g) {
            g.setColor(color);
            g.fillRect(x, y, w, h);
        }
    }

    static class LineShape extends Shape {
        private final int x2, y2;
        public LineShape(Color color, int x, int y, int x2, int y2) {
            super(color, x, y);
            this.x2 = x2;
            this.y2 = y2;
        }
        @Override
        public void draw(Graphics g) {
            g.setColor(color);
            g.drawLine(x, y, x2, y2);
        }
    }

    // ---------- Панель рисования ----------
    static class DrawPanel extends JPanel {
        private final Shape[] shapes = new Shape[20];

        public DrawPanel() {
            setBackground(Color.WHITE);
            Random rnd = new Random();
            for (int i = 0; i < shapes.length; i++) {
                Color c = new Color(rnd.nextInt(256),
                        rnd.nextInt(256),
                        rnd.nextInt(256));
                int x = rnd.nextInt(400);
                int y = rnd.nextInt(300);
                switch (rnd.nextInt(3)) {
                    case 0:
                        shapes[i] = new CircleShape(c, x, y, 10 + rnd.nextInt(30));
                        break;
                    case 1:
                        shapes[i] = new RectShape(c, x, y,
                                20 + rnd.nextInt(40),
                                20 + rnd.nextInt(40));
                        break;
                    default:
                        shapes[i] = new LineShape(c, x, y,
                                rnd.nextInt(450), rnd.nextInt(350));
                        break;
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Shape s : shapes) {
                if (s != null) s.draw(g);
            }
        }
    }

    public Task2() {
        super("20 random shapes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        add(new DrawPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Task2();
    }
}