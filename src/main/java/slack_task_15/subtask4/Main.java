package slack_task_15.subtask4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Створюємо об'єкт класа Scanner передаємо йому як параметр InputStream
        Scanner scanner = new Scanner(System.in);

        //Локальна змінна для зьерігання числа рядків
        int stringsNumber;
        do {
            System.out.println("Enter the number of words from 1: ");
            //Присвоюється кількість слів
            stringsNumber = scanner.nextInt();
            //Умова виходу з циклу
        } while (stringsNumber <= 0);
        System.out.printf("Enter %d words:%n", stringsNumber);

        //Оголошення та визначення масиву рядків
        String[] strings = new String[stringsNumber];

        //Оголошення, визначення та ініалізація змінної для цільового слова
        String targetString = scanner.next();
        //Оголошення, визначення та ініалізація змінної мінімальної к-сті унікальних символів
        int minNumberUniqueChars = getNumberUniqueСhars(targetString);

        //Ініціалізація масиву рядків strings та визначення слова з мінімальною кількістю унікальних символів
        for (int i = 0; i < stringsNumber - 1; i++) {
            strings[i] = scanner.next();
            if (getNumberUniqueСhars(strings[i]) < minNumberUniqueChars) {
                minNumberUniqueChars = getNumberUniqueСhars(strings[i]);
                targetString = strings[i];
            }
        }

        //Виведення результату
        System.out.printf("Target word - \"%s\".", targetString);
    }

    //Метод визначення к-сті унікальних символів
    private static int getNumberUniqueСhars(String string){
        //Оголошення та визначення змінної типу StringBuilder
        StringBuilder uniqueString = new StringBuilder();
        //Оголошення змінної типу char для поточного символа перебору
        char currentChar;

        //Цикл перебору всіх символів слова
        for (int i = 0; i < string.length(); i++) {
            currentChar = string.charAt(i);

            if (uniqueString.indexOf(String.valueOf(currentChar)) == -1) {
                uniqueString.append(currentChar);
            }
        }

        return uniqueString.length();
    }
}
