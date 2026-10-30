package pr1;

public class Task6 {
    public static void main(String[] args) {
        double harmonic = 0.0;
        for (int i = 1; i <= 10; i++) {
            harmonic += 1.0 / i;//1.0 чтобы деление было дробным
            System.out.printf("%d-й член: %.4f, сумма: %.4f%n",
                    i, 1.0 / i, harmonic);
        }
    }
}
