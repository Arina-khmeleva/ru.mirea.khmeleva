package pr8;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите последовательность чисел (завершение: два 0 подряд):");

        int count = countOnes(scanner);

        System.out.println("Количество единиц в последовательности: " + count);
        scanner.close();
    }

    public static int countOnes(Scanner scanner) {
        // Читаем очередное число
        int num = scanner.nextInt();

        // Если встретили 0, нужно проверить, не закончилась ли последовательность
        if (num == 0) {
            int nextNum = scanner.nextInt();
            // Если следующий тоже 0 — это конец последовательности
            if (nextNum == 0) {
                return 0; // Базовый случай
            } else {
                // Если следующий не 0, то первый 0 был просто числом в последовательности.
                // Проверяем, является ли следующий ноль единицей, и идем дальше.
                return (nextNum == 1 ? 1 : 0) + countOnes(scanner);
            }
        }

        // Шаг рекурсии: если число 1, прибавляем единицу к результату остатка
        return (num == 1 ? 1 : 0) + countOnes(scanner);
    }
}