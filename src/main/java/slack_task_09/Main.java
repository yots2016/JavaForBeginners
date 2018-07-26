package slack_task_09;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        System.out.println("AverageArithmetic = " + getAverage(new double[]{1.3, .5, 89.000005, 12}));
        System.out.println();
        System.out.println("AverageArithmetic = " + getAverage(new short[]{3, 5, 5, 12, 555}));
        System.out.println();
        System.out.println("AverageArithmetic = " + getAverage(new long[]{3, 1000, 678678, 4654}));
        System.out.println();
        System.out.println("The sum of squares of two numbers = " + getSumOfSquares(12, 3));
        System.out.println();
        System.out.println("The sum of squares of two numbers = " + getSumOfSquares(54544f, 76f));
        System.out.println();

        int[] randomNumbersArray = new int[10];

        randomArrayFill(randomNumbersArray, randomNumbersArray.length);
        System.out.println(Arrays.toString(randomNumbersArray));
    }

    //Метод для прорахунку середньоарифметичного значення елементів масиву типу int
    private static long getAverage(int[] inputArray) {
        int sum = 0;

        for (int anInputArray : inputArray) {
            sum += anInputArray;
        }

        return sum / inputArray.length;
    }

    //Перегружений метод для прорахунку середньоарифметичного значення елементів масиву типу long
    private static long getAverage(long[] inputArray) {
        long sum = 0;

        for (long anInputArray : inputArray) {
            sum += anInputArray;
        }

        return sum / inputArray.length;
    }

    //Перегружений метод для прорахунку середньоарифметичного значення елементів масиву типу byte
    private static long getAverage(byte[] inputArray) {
        int sum = 0;

        for (byte anInputArray : inputArray) {
            sum += anInputArray;
        }

        return sum / inputArray.length;
    }

    //Перегружений метод для прорахунку середньоарифметичного значення елементів масиву типу short
    private static long getAverage(short[] inputArray) {
        int sum = 0;

        for (short anInputArray : inputArray) {
            sum += anInputArray;
        }

        return sum / inputArray.length;
    }

    //Метод для прорахунку середньоарифметичного значення елементів масиву типу double
    private static double getAverage(double[] inputArray) {
        double sum = 0;

        for (double anInputArray : inputArray) {
            sum += anInputArray;
        }

        return sum / inputArray.length;
    }

    //Перегружений метод для прорахунку середньоарифметичного значення елементів масиву типу float
    private static double getAverage(float[] inputArray) {
        double sum = 0;

        for (float anInputArray : inputArray) {
            sum += anInputArray;
        }

        return sum / inputArray.length;
    }

    //Метод для прорахунку суми квадратів двох чисел типу int
    private static long getSumOfSquares(int firstNumber, int secondNumber) {
        return firstNumber * firstNumber + secondNumber * secondNumber;
    }

    //Перегружений метод для прорахунку суми квадратів двох чисел типу float
    private static double getSumOfSquares(float firstNumber, float secondNumber) {
        return firstNumber * firstNumber + secondNumber * secondNumber;
    }

    //Рекурсивний метод заповннення масиву випадковими неповторюваними числами
    private static void randomArrayFill(int inputArray[], int arrayLength) {
        if (arrayLength == 0) { //Умова виходу з рекурсії
            return;
        } else {
            randomArrayFill(inputArray,arrayLength - 1); //Рекурсивний виклик методу
        }

        int random; //Змінна для рнадомних значень
        boolean hasSameValue = false; //Прапорець перевірки чи є повторюваний елемент у масиві

        //Цикл, що крутиться поки не знайдеться значення, якого ще немає у масиві
        //Особливість тут у тому що, коли розмір масиву більший ніж кількість усіх можливих елементів рандому
        //заданого діапазону, то відбудеться зациклення
        do {
            random = RANDOM.nextInt(11);

            //Цикл, що перевіряє чи нове рандомне значення для вставки не було раніше вставлено вже в цей масив
            for (int i = 0; i < arrayLength; i++) {
                if (inputArray[i] == random) {
                    hasSameValue = true; //Якщо рандомне значення вже є в масиві
                    break;
                }

                hasSameValue = false;  //Якщо рандомного значення ще немає в масиві
            }
        } while (hasSameValue);

        inputArray[--arrayLength] = random;//Внесення нового рандомного значення в масив
    }
}
