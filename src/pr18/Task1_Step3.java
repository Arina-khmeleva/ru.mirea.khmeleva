package pr18;

public class Task1_Step3 {
    public void exceptionDemo() {
        try {
            System.out.println( 2 / 0 );
        } catch ( ArithmeticException e ) {
            System.out.println("Attempted division by zero");
        }
    }

    public static void main(String[] args) {
        new Task1_Step3().exceptionDemo();
    }
}