package pr3.movable;

public class MainMovable {
    public static void main(String[] args) {
        System.out.println("--- Тестируем MovablePoint ---");
        // Создаем точку на координатах (0, 0) со скоростью 5 по X и 10 по Y
        MovablePoint point = new MovablePoint(0, 0, 5, 10);
        System.out.println("Изначально: " + point);

        point.moveUp();     // Y должен стать 10
        point.moveRight();  // X должен стать 5
        System.out.println("После moveUp и moveRight: " + point);

        System.out.println("\n--- Тестируем MovableCircle ---");
        // Создаем круг, центр в (10, 10), скорость 2, радиус 5
        MovableCircle circle = new MovableCircle(10, 10, 2, 2, 5);
        System.out.println("Изначально: " + circle);

        circle.moveLeft();  // X центра уменьшится на 2
        circle.moveDown();  // Y центра уменьшится на 2
        System.out.println("После moveLeft и moveDown: " + circle);

        System.out.println("\n--- Тестируем MovableRectangle ---");
        // Создаем прямоугольник: верхняя левая точка (0,0), нижняя правая (5,5)
        // Скорости у обеих точек одинаковые (3, 3)
        MovableRectangle rect = new MovableRectangle(0, 0, 5, 5, 3, 3);
        System.out.println("Изначально: " + rect);

        rect.moveRight();   // Обе точки сдвинутся вправо на 3
        rect.moveUp();      // Обе точки сдвинутся вверх на 3
        System.out.println("После moveRight и moveUp: " + rect);
    }
}
