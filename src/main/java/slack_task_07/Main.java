package slack_task_07;

import slack_task_07.utils.ArraySorts;

import java.util.Random;

public class Main {
    private static final int SIZE_OF_FIRST_DIMENSION_OF_ARRAY = 1;
    private static final int SIZE_OF_SECOND_DIMENSION_OF_ARRAY = 2;
    private static final int SIZE_OF_THIRD_DIMENSION_OF_ARRAY = 5;

    public static void main(String[] args) {
        int[][][] threeDimensionalArrayOfNumbers 
                = new int[SIZE_OF_FIRST_DIMENSION_OF_ARRAY][SIZE_OF_SECOND_DIMENSION_OF_ARRAY][SIZE_OF_THIRD_DIMENSION_OF_ARRAY];

        randomFillArray(threeDimensionalArrayOfNumbers);

        printElementsOfThreeDimensionalArray(threeDimensionalArrayOfNumbers);

        sorThreeDimensionalArray(threeDimensionalArrayOfNumbers);

        printElementsOfThreeDimensionalArray(threeDimensionalArrayOfNumbers);


    }

    private static void sorThreeDimensionalArray(int[][][] threeDimensionalArrayOfNumbers) {
        for (int i = 0; i < SIZE_OF_FIRST_DIMENSION_OF_ARRAY; i++) {
            for (int j = 0; j < SIZE_OF_SECOND_DIMENSION_OF_ARRAY; j++) {
                chooseSortMethod(threeDimensionalArrayOfNumbers, i, j);
            }
        }

        System.out.println();
    }

    private static void chooseSortMethod(int[][][] threeDimensionalArrayOfNumbers, int indexI, int indexJ) {
        Random random = new Random();

        switch (random.nextInt(4)) {
            case 1:
                ArraySorts.bubbleSort(threeDimensionalArrayOfNumbers[indexI][indexJ]);
                break;
            case 2:
                ArraySorts.choiceSort(threeDimensionalArrayOfNumbers[indexI][indexJ]);
                break;
            case 3:
            default:
                ArraySorts.insertSort(threeDimensionalArrayOfNumbers[indexI][indexJ]);

        }
    }

    private static void printElementsOfThreeDimensionalArray(int[][][] threeDimensionalArrayOfNumbers) {
        for (int i = 0; i < SIZE_OF_FIRST_DIMENSION_OF_ARRAY; i++) {
            for (int j = 0; j < SIZE_OF_SECOND_DIMENSION_OF_ARRAY; j++) {
                for (int k = 0; k < SIZE_OF_THIRD_DIMENSION_OF_ARRAY; k++) {
                    System.out.print(" " + threeDimensionalArrayOfNumbers[i][j][k]);
                }

                System.out.println();
            }
        }

        System.out.println();
    }

    private static void randomFillArray(int[][][] threeDimensionalArrayOfNumbers) {
        Random random = new Random();

        for (int i = 0; i < SIZE_OF_FIRST_DIMENSION_OF_ARRAY; i++) {
            for (int j = 0; j < SIZE_OF_SECOND_DIMENSION_OF_ARRAY; j++) {
                for (int k = 0; k < SIZE_OF_THIRD_DIMENSION_OF_ARRAY; k++) {
                    threeDimensionalArrayOfNumbers[i][j][k] = random.nextInt(21) - 10;
                }
            }
        }
    }
}
