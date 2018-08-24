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

        parsedDate = getPrevDayDate(parsedDate, DayOfWeek.TUESDAY);

        System.out.println();
        System.out.println(parsedDate);
        System.out.println(parsedDate.getDayOfWeek());

    }

    public static LocalDate getPrevDayDate(LocalDate parsedDate, DayOfWeek prevDayOfWeek) {
        int countDays = 0;
        DayOfWeek dayOfWeek = parsedDate.getDayOfWeek();

        if (dayOfWeek.getValue() == prevDayOfWeek.getValue()) {
            countDays = 7;
        } else {
            while (dayOfWeek.getValue() != prevDayOfWeek.getValue()) {
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
