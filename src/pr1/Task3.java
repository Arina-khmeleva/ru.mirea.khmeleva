package pr1;

public class Task3 {
        public static void main(String[] args) {
            int[] arr = {5, 10, 15, 20, 25, 30}; // Создание массива целых чисел, сразу заполняем его

            int sum = 0;// Переменная для накопления
            for (int i = 0; i < arr.length; i++) {// переменная от 0 и до длинны массива
                sum += arr[i];
            }

            double average = (double) sum / arr.length;// Среднее арифметическое double, чтобы не потерять дроби

            System.out.println("Сумма: " + sum);
            System.out.println("Среднее арифметическое: " + average);
        }
}
