package slack_task_15.subtask2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Створюємо об'єкт класа Scanner передаємо йому як параметр InputStream
        Scanner scanner = new Scanner(System.in);

        //Локальна змінна для зьерігання числа рядків
        int stringsNumber;
        do {
            System.out.println("Enter the number of strings from 1: ");
            //Присвоюється кількість ріядків
            stringsNumber = Integer.parseInt(scanner.nextLine());
            //Умова виходу з циклу
        } while (stringsNumber <= 0);
        System.out.printf("Enter %d strings:%n", stringsNumber);

        //Оголошення та визначення масиву рядків
        String[] strings = new String[stringsNumber];

        //Ініалізація масиву рядків
        for (int i = 0; i < stringsNumber; i++) {
            strings[i] = scanner.nextLine();
        }

        //Оголошення та визначення компаратора
        Comparator<String> asc = Comparator.comparing(String::length, Integer::compareTo);


        System.out.println();
        //Виведення результатів
        Arrays.sort(strings, asc);
        System.out.printf("Asc sorted strings - %s.%n", Arrays.toString(strings));
        Arrays.sort(strings, asc.reversed());
        System.out.printf("Desc sorted strings - %s.", Arrays.toString(strings));
    }
}
