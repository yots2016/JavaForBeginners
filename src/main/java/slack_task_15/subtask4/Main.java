package slack_task_15.subtask4;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stringsNumber;
        do {
            System.out.println("Enter the number of words from 1: ");
            stringsNumber = scanner.nextInt();
        } while (stringsNumber <= 0);
        System.out.printf("Enter %d words:%n", stringsNumber);

        String[] strings = new String[stringsNumber];

        for (int i = 0; i < stringsNumber; i++) {
            strings[i] = scanner.next();
        }


    }
}
