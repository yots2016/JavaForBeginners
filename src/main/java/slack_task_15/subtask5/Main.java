package slack_task_15.subtask5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        System.out.println("Target words - " + getTargetWords(strings));

    }

    public static String[] getLatinWords(String[] inputArray) {
        Pattern latinPattern = Pattern.compile("[A-z]+");
        List<String> result = new ArrayList<>();

        for (int i = 0; i < inputArray.length; i++) {
            Matcher latinMatcher = latinPattern.matcher(inputArray[i]);

                if (latinMatcher.matches()) {
                    result.add(inputArray[i]);
                }
        }

        return result.toArray(new String[result.size()]);
    }

    public static List<String> getTargetWords(String[] inputArray) {
        String[] latinWords = getLatinWords(inputArray);

        List<String> result = new ArrayList<>();
        int loudLetters, consonantLetters;

        for (int i = 0; i < inputArray.length; i++) {
            loudLetters = latinWords[i].replaceAll("[^aeiouAEIOU]", "").length();
            consonantLetters = latinWords[i].replaceAll("[aeiouAEIOU]", "").length();

            if (loudLetters == consonantLetters) {
                result.add(latinWords[i]);
            }
        }

        return result;
    }
}
