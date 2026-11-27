package pr11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String fullName;
    private Date birthDate; // новое поле — дата рождения

    public Student(String fullName, Date birthDate) {
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    // Метод возвращает дату рождения в заданном извне формате
    public String getFormattedBirthDate(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(birthDate);
    }

    // Переписанный toString(): дата рождения в "среднем" формате
    @Override
    public String toString() {
        return "Student{fullName='" + fullName + "', birthDate="
                + getFormattedBirthDate("dd MMM yyyy") + "}";
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat input = new SimpleDateFormat("dd.MM.yyyy");
        Student s = new Student("Хмелева Арина", input.parse("22.02.2007"));

        System.out.println(s);                                        // toString
        System.out.println("Короткий: " + s.getFormattedBirthDate("dd.MM.yy"));
        System.out.println("Средний:  " + s.getFormattedBirthDate("dd MMM yyyy"));
        System.out.println("Полный:   " + s.getFormattedBirthDate("EEEE, dd MMMM yyyy"));
    }
}
