package slack_task_06;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    private final static int ARRAY_SIZE = 10;

    public static void main(String[] args) {
        Random random = new Random();

        Integer randomNumbersArray[] = new Integer[ARRAY_SIZE];

        randomFillArray(random, randomNumbersArray);

        printArray(randomNumbersArray);

        findMaxMinValues(randomNumbersArray);
    }

    private static void findMaxMinValues(Integer[] randomNumbersArray) {
        List<Integer> randomNumbersList = Arrays.asList(randomNumbersArray);

        System.out.println("Max = " + Collections.max(randomNumbersList));
        System.out.println("Min = " + Collections.min(randomNumbersList));
    }

    private static void printArray(Integer[] randomNumbersArray) {
        for (int number : randomNumbersArray) {
            System.out.print(" " + number);
            System.out.println();
        }
    }

    private static void randomFillArray(Random random, Integer[] randomNumbersArray) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            randomNumbersArray[i] = random.nextInt(21) - 10;
        }
    }
}
