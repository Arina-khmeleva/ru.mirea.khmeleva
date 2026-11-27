package pr11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите: <Год> <Месяц> <Число>");
        int year  = sc.nextInt();
        int month = sc.nextInt();   // 1..12 — как вводит пользователь
        int day   = sc.nextInt();

        System.out.println("Введите: <Часы> <Минуты>");
        int hour   = sc.nextInt();
        int minute = sc.nextInt();

        // 1) Calendar
        Calendar cal = Calendar.getInstance();     // экземпляр через getInstance()
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);        // Calendar: месяц 0..11 !!
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);       // часы 0..23
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        // 2) Date из Calendar (после getTime() происходит пересчёт полей)
        Date date = cal.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Calendar -> " + sdf.format(cal.getTime()));
        System.out.println("Date     -> " + sdf.format(date));

        // Проверка отдельных полей через get(...)
        System.out.printf("Проверка: %04d/%02d/%02d %02d:%02d%n",
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE));
    }
}

