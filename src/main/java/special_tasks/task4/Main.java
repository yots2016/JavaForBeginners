package special_tasks.task4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String stringDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate parsedDate = parseDate(stringDate);

        System.out.println(parsedDate);
        System.out.println(parsedDate.getDayOfWeek());

        System.out.println();
        System.out.println(parsedDate.with(TemporalAdjusters.previous(DayOfWeek.TUESDAY)));
        System.out.println(parsedDate.getDayOfWeek());

    }

    public static LocalDate parseDate(String date) {
        return LocalDate.parse(date);
    }
}
