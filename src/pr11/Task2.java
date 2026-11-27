package pr11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false); // строгий разбор: 31.02.2024 не пройдёт

        System.out.print("Введите дату (dd.MM.yyyy): ");
        String input = sc.nextLine();

        try {
            Date userDate = sdf.parse(input);   // текст -> дата
            Date now = new Date();              // текущее системное время

            // Сравнение методами класса Date
            if (userDate.before(now)) {
                System.out.println("Введённая дата (" + sdf.format(userDate)
                        + ") раньше текущей (" + sdf.format(now) + ")");
            } else if (userDate.after(now)) {
                System.out.println("Введённая дата (" + sdf.format(userDate)
                        + ") позже текущей (" + sdf.format(now) + ")");
            } else {
                System.out.println("Даты равны");
            }

            System.out.println("compareTo: " + userDate.compareTo(now)); // -1 / 1 / 0
        } catch (ParseException e) {
            System.out.println("Некорректный формат даты: " + e.getMessage());
        }
    }
}
