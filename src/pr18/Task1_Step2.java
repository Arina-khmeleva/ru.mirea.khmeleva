package pr18;

public class Task1_Step2 {
    public void exceptionDemo() {
        System.out.println( 2.0 / 0.0 );
    }

    public static void main(String[] args) {
        new Task1_Step2().exceptionDemo();
    }
}
//Программа выведет Infinity (бесконечность) и не завершится с ошибкой.
// При делении чисел с плавающей точкой (double, float) на ноль исключение
// не генерируется согласно стандарту IEEE 754.