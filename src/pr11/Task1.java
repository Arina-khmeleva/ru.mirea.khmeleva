package pr11;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task1 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMMM dd HH:mm:ss");

        // Дата и время получения задания: конструктор Date(long) —
        // количество миллисекунд с 01.01.1970
        long receiptMillis = System.currentTimeMillis() - 7L * 24 * 60 * 60 * 1000; // неделя назад
        Date receiptDate = new Date(receiptMillis);

        // Дата и время сдачи задания: конструктор Date() — текущий момент
        Date submitDate = new Date();

        System.out.println("Разработчик: Хмелева Арина Олеговна");
        System.out.println("Задание получено: " + sdf.format(receiptDate));
        System.out.println("Задание сдано:    " + sdf.format(submitDate));
    }
}
