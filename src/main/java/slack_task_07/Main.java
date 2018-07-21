package slack_task_07;

import slack_task_07.utils.ArraySorts;

import java.util.Random;

public class Main {
    //фактично це константи для задання розміру трьохвимірного масиву
    private static final int SIZE_OF_FIRST_DIMENSION_OF_ARRAY = 1;
    private static final int SIZE_OF_SECOND_DIMENSION_OF_ARRAY = 2;
    private static final int SIZE_OF_THIRD_DIMENSION_OF_ARRAY = 5;

    public static void main(String[] args) {
        int[][][] threeDimensionalArrayOfNumbers //Оголошення та визначення трьохвимірного масиву типу int
                = new int[SIZE_OF_FIRST_DIMENSION_OF_ARRAY][SIZE_OF_SECOND_DIMENSION_OF_ARRAY][SIZE_OF_THIRD_DIMENSION_OF_ARRAY];

        randomFillArray(threeDimensionalArrayOfNumbers); //Виклик методу заповнення масиву цілими числами

        printElementsOfThreeDimensionalArray(threeDimensionalArrayOfNumbers); //Виклик методу виведення на екран масиву

        sorThreeDimensionalArray(threeDimensionalArrayOfNumbers); //Виклик методу сортування масиву

        printElementsOfThreeDimensionalArray(threeDimensionalArrayOfNumbers);


    }

    //Метод сортування елементів масиву
    private static void sorThreeDimensionalArray(int[][][] threeDimensionalArrayOfNumbers) {
       /*
       * Перебір елементів другого виміру масиву, його елементами є посилання на одновимірні масиви цілих чисел
       *
       * Це особливість масивів у java.
       *
       * Наприклад, у двохвимірного масиву int a[][] = new int[2][3]
       * 1-ий рівень це 2 посилання на 2 одновимірних інтових масиви по 3 елементи
       * 2-ий рівень у кожного одновимірного інтового масиву по 3 елементи
       *
       * У цій ситуації аналогічно тільки з 3-ома вимірами
       **/
        for (int i = 0; i < SIZE_OF_FIRST_DIMENSION_OF_ARRAY; i++) {
            for (int j = 0; j < SIZE_OF_SECOND_DIMENSION_OF_ARRAY; j++) {
                chooseSortMethod(threeDimensionalArrayOfNumbers, i, j); //Виклик методу рандомного вибору методу сортування
            }
        }

        System.out.println();
    }

    //Метод рандомного вибору методу сортування масиву та його сортування
    private static void chooseSortMethod(int[][][] threeDimensionalArrayOfNumbers, int indexI, int indexJ) {
        Random random = new Random();

        switch (random.nextInt(4)) {//умовний оператор
            case 1:
                ArraySorts.bubbleSort(threeDimensionalArrayOfNumbers[indexI][indexJ]);//Інтерфейс із статистичними методами сортування
                break;
            case 2:
                ArraySorts.choiceSort(threeDimensionalArrayOfNumbers[indexI][indexJ]);//Інтерфейс із статистичними методами сортування
                break;
            case 3:
            default:
                ArraySorts.insertSort(threeDimensionalArrayOfNumbers[indexI][indexJ]);//Інтерфейс із статистичними методами сортування

        }
    }

    //Метод виведення на екран елементів масиву
    private static void printElementsOfThreeDimensionalArray(int[][][] threeDimensionalArrayOfNumbers) {
        //Перебір всіх елементів масиву, кожен фор перебирає кожен вимір(рівень масиву)
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

    //Метод заповнення масиву рандомними елементами
    private static void randomFillArray(int[][][] threeDimensionalArrayOfNumbers) {
        Random random = new Random();

        //Перебір всіх елементів масиву
        //Ініціалізація всіх елементів масиву цілими рандомними числами з проміжку від -10 до 10
        for (int i = 0; i < SIZE_OF_FIRST_DIMENSION_OF_ARRAY; i++) {
            for (int j = 0; j < SIZE_OF_SECOND_DIMENSION_OF_ARRAY; j++) {
                for (int k = 0; k < SIZE_OF_THIRD_DIMENSION_OF_ARRAY; k++) {
                    threeDimensionalArrayOfNumbers[i][j][k] = random.nextInt(21) - 10;
                }
            }
        }
    }
}
