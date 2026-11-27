package pr8;

public class Task10 {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println("Развернутое число: " + reverse(n));
    }

    // Основной метод, который вызывает рекурсивный
    public static int reverse(int n) {
        return reverseHelper(n, 0);
    }

    // Вспомогательный рекурсивный метод
    private static int reverseHelper(int n, int reversed) {
        // Базовый случай: если число закончилось, возвращаем накопленный результат
        if (n == 0) {
            return reversed;
        }
        // Шаг рекурсии:
        // Берем последнюю цифру (n % 10) и приписываем её к результату (reversed * 10 + цифра)
        // Отбрасываем последнюю цифру (n / 10) и идем дальше
        return reverseHelper(n / 10, reversed * 10 + n % 10);
    }
}
