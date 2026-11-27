package pr8;

public class Task8 {
    public static void main(String[] args) {
        String word = "mom";
        System.out.println(isPalindrome(word) ? "YES" : "NO");
    }

    public static boolean isPalindrome(String s) {
        // Базовый случай: пустая строка или 1 символ — это палиндром
        if (s.length() <= 1) {
            return true;
        }
        // Если первый и последний символы не равны — это не палиндром
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        // Шаг рекурсии: отрезаем первый и последний символы и проверяем остаток
        return isPalindrome(s.substring(1, s.length() - 1));
    }
}