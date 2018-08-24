package special_tasks.task4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String stringDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate parsedDate = parseDate(stringDate);

        System.out.println(parsedDate);
        System.out.println(parsedDate.getDayOfWeek());

        parsedDate = getPrevTueDate(parsedDate);

        System.out.println();
        System.out.println(parsedDate);
        System.out.println(parsedDate.getDayOfWeek());

    }

    public static LocalDate getPrevTueDate(LocalDate parsedDate) {
        int countDays = 0;
        DayOfWeek dayOfWeek = parsedDate.getDayOfWeek();

        if (dayOfWeek.getValue() == 2) {
            countDays = 7;
        } else {
            while (dayOfWeek.getValue() != 2) {
                dayOfWeek = dayOfWeek.minus(1);
                countDays++;
            }
        }

        return parsedDate.minusDays(countDays);
    }

    public static LocalDate parseDate(String date) {
        return LocalDate.parse(date);
    }
}
