package slack_task_15.subtask4;

import java.util.Scanner;

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

        String targetString = scanner.next();
        int minNumberUniqueChars = getNumberUniqueСhars(targetString);


        for (int i = 0; i < stringsNumber - 1; i++) {
            strings[i] = scanner.next();
            if (getNumberUniqueСhars(strings[i]) < minNumberUniqueChars) {
                minNumberUniqueChars = getNumberUniqueСhars(strings[i]);
                targetString = strings[i];
            }
        }

        System.out.printf("Target word - \"%s\".", targetString);
    }

    private static int getNumberUniqueСhars(String string){
        StringBuilder uniqueString = new StringBuilder();
        char currentChar;

        for (int i = 0; i < string.length(); i++) {
            currentChar = string.charAt(i);

            if (uniqueString.indexOf(String.valueOf(currentChar)) == -1) {
                uniqueString.append(currentChar);
            }
        }

        return uniqueString.length();
    }
}
