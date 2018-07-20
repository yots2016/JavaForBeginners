package slack_task_06;

import java.util.*;

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

        int max = Collections.max(randomNumbersList);
        int min = Collections.min(randomNumbersList);

        int indexOfMax = randomNumbersList.indexOf(max);
        int indexOfMin = randomNumbersList.indexOf(min);

        System.out.println("Max randomNumbersArray[" + indexOfMax + "] = " + max);
        System.out.println("Min randomNumbersArray[" + indexOfMin + "] = " + min);
    }

    private static void printArray(Integer[] randomNumbersArray) {
        for (int number : randomNumbersArray) {
            System.out.print(" " + number);
        }

        System.out.println();
        System.out.println();
    }

    private static void randomFillArray(Random random, Integer[] randomNumbersArray) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            randomNumbersArray[i] = random.nextInt(21) - 10;
        }
    }
}
