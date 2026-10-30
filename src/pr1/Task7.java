package pr1;

public class Task7 {
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;// умножаем результат на i
        }
        return result;
    }

    public static void main(String[] args) {
        for (int n = 0; n <= 10; n++) {// проверяем факториалы от 0 до 10
            System.out.println(n + "! = " + factorial(n));
        }
    }
}
