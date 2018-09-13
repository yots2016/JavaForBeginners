package slack_task_15.subtask1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stringsNumber;
        do {
            System.out.println("Enter the number of strings from 1: ");
            stringsNumber = scanner.nextInt();
        } while (stringsNumber <= 0);
        System.out.printf("Enter %d strings:%n", stringsNumber);

        String s = scanner.next();
        int length = s.length();

        String minString = s, maxString = s;
        int min = length, max = length;

        for (int i = 0; i < stringsNumber - 1; i++) {
            s = scanner.next();
            length = s.length();

            if (length > max) {
                max = length;
                maxString = s;
            }

            if (length < min) {
                min = length;
                minString = s;
            }
        }

        System.out.printf("Max string - \"%s\", length - %d.%n", maxString, max);
        System.out.printf("Min string - \"%s\", length - %d.", minString, min);
    }
}
