package pr1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// создание объекта, читает с клавиатуры

        System.out.print("Введите размер массива: ");
        int n = sc.nextInt();// считывает число и сохраняет в переменную
        int[] arr = new int[n];// массив целых чисел размер n

        System.out.println("Введите " + n + " элементов:");
        for (int i = 0; i < n; i++) {// заполняем массив
            arr[i] = sc.nextInt();// считываем число и кладем в элемент массива
        }

        // do-while: сумма
        int sum = 0;
        int i = 0;
        do {
            sum += arr[i];// прибавляем элемент к сумме
            i++;
        } while (i < arr.length);

        // while: min и max
        int max = arr[0];
        int min = arr[0];
        int j = 0;
        while (j < arr.length) {
            if (arr[j] > max) max = arr[j];
            if (arr[j] < min) min = arr[j];
            j++;
        }

        System.out.println("Сумма: " + sum);
        System.out.println("Максимум: " + max);
        System.out.println("Минимум: " + min);
    }
}
