package slack_task_09;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final Random RANDOM = new Random(10);

    public static void main(String[] args) {
//        System.out.println("AverageArithmetic = " + getAverageArithmeticValue(new double[]{1.3, .5, 89.000005, 12}));
//        System.out.println();
//        System.out.println("AverageArithmetic = " + getAverageArithmeticValue(new short[]{3, 5, 5, 12, 555}));
//        System.out.println();
//        System.out.println("AverageArithmetic = " + getAverageArithmeticValue(new long[]{3, 1000, 678678, 4654}));
//        System.out.println();
//        System.out.println("The sum of squares of two numbers = " + getSumOfSquaresOfTwoNumbers(12, 3));
//        System.out.println();
//        System.out.println("The sum of squares of two numbers = " + getSumOfSquaresOfTwoNumbers(54544f, 76f));
//        System.out.println();

        int[] randomNumbersArray = new int[17];

        randomArrayFill(randomNumbersArray, randomNumbersArray.length);
        System.out.println(Arrays.toString(randomNumbersArray));
    }

    private static int getAverageArithmeticValue(int[] inputArray) {
        int sum = 0;

        for (int anInputArray : inputArray) {
            sum += anInputArray;
        }

        return sum / inputArray.length;
    }

    private static long getAverageArithmeticValue(long[] inputArray) {
        long sum = 0;

        for (long anInputArray : inputArray) {
            sum += anInputArray;
        }

        return sum / inputArray.length;
    }

    private static int getAverageArithmeticValue(byte[] inputArray) {
        int sum = 0;

        for (byte anInputArray : inputArray) {
            sum += anInputArray;
        }

        return sum / inputArray.length;
    }

    private static int getAverageArithmeticValue(short[] inputArray) {
        int sum = 0;

        for (short anInputArray : inputArray) {
            sum += anInputArray;
        }

        return sum / inputArray.length;
    }

    private static double getAverageArithmeticValue(double[] inputArray) {
        double sum = 0;

        for (double anInputArray : inputArray) {
            sum += anInputArray;
        }

        return sum / inputArray.length;
    }

    private static double getAverageArithmeticValue(float[] inputArray) {
        double sum = 0;

        for (float anInputArray : inputArray) {
            sum += anInputArray;
        }

        return sum / inputArray.length;
    }

    private static int getSumOfSquaresOfTwoNumbers(int firstNumber, int secondNumber) {
        return firstNumber * firstNumber + secondNumber * secondNumber;
    }

    private static double getSumOfSquaresOfTwoNumbers(float firstNumber, float secondNumber) {
        return firstNumber * firstNumber + secondNumber * secondNumber;
    }

    private static void randomArrayFill(int inputArray[], int arrayLength) {
        if (arrayLength == 0) {
            return;
        } else {
            randomArrayFill(inputArray,arrayLength - 1);
        }

        inputArray[--arrayLength] = RANDOM.nextInt(10);
    }
}
