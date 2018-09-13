package slack_task_15.subtask2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

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

        for (int i = 0; i < stringsNumber; i++) {
            strings[i] = scanner.nextLine();
        }

        Comparator<String> asc = Comparator.comparing(String::length,Integer::compareTo);
        Comparator<String> desc = Comparator.comparing(String::length, Integer::compareTo).reversed();

        Arrays.sort(strings, asc);
        System.out.printf("Asc sorted strings - %s.%n", Arrays.toString(strings));
        Arrays.sort(strings, desc);
        System.out.printf("Desc sorted strings - %s.", Arrays.toString(strings));
    }
}
