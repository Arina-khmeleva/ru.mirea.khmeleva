package pr18;

public class Task1_Step1 {
    public void exceptionDemo() {
        System.out.println( 2 / 0 ); // Здесь произойдет исключение
    }

    public static void main(String[] args) {
        Task1_Step1 obj = new Task1_Step1();
        obj.exceptionDemo();
    }
}
// Программа аварийно завершается с ошибкой java.lang.ArithmeticException: / by zero.
//Это исключение времени выполнения (RuntimeException), возникающее при попытке
// целочисленного деления на ноль.