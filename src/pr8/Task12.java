package pr8;

public class Task12 {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println("Количество цифр: " + countDigits(n));
    }
    public static int countDigits(int n) {
        if (n < 10) return 1; // Базовый случай
        return 1 + countDigits(n / 10); // Шаг рекурсии
    }
}