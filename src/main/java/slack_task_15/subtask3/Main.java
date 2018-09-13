package slack_task_15.subtask3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stringsNumber;
        do {
            System.out.println("Enter the number of strings from 1: ");
            stringsNumber = Integer.parseInt(scanner.nextLine());
        } while (stringsNumber <= 0);
        System.out.printf("Enter %d strings:%n", stringsNumber);

        String[] strings = new String[stringsNumber];

        double[] sum = {0};
        for (int i = 0; i < stringsNumber; i++) {
            strings[i] = scanner.nextLine();
            sum[0]+=strings[i].length();
        }

        double[] average = {sum[0] / strings.length};

        Map<Boolean, List<String>> map = Stream.of(strings)
                .collect(Collectors.partitioningBy(s -> s.length() > average[0]));

        map.forEach((aBoolean, stringList) -> {
            if (!aBoolean) {
                System.out.println("Strings whose length is less than  the average:");
            } else {
                System.out.println("Strings whose length is greater than the average:");
            }
            stringList.forEach(s -> System.out.printf("String - %s. It`s length - %d.%n", s, s.length()));
        });




    }
}
