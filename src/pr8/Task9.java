package pr8;

public class Task9 {
    public static void main(String[] args) {
        int a = 2; // количество нулей
        int b = 3; // количество единиц
        System.out.println("Количество последовательностей: " + countSequences(a, b));
    }

    public static int countSequences(int a, int b) {
        // Базовые случаи
        if (a == 0) return 1; // Нулей нет — только один вариант (одни единицы)
        if (b == 0) return 0; // Есть нули, но нет единиц — их нельзя разделить (если a > 1)

        // Если нулей больше, чем единиц + 1, то их невозможно разделить без двух нулей рядом
        if (a > b + 1) return 0;

        // Шаг рекурсии:
        // 1. Первым ставим 1: остается a нулей и b-1 единиц
        // 2. Первым ставим 0, тогда вторым ОБЯЗАТЕЛЬНО 1: остается a-1 нулей и b-1 единиц
        return countSequences(a, b - 1) + countSequences(a - 1, b - 1);
    }
}