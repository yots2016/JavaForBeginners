package slack_task_15.subtask1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Створюємо об'єкт класа Scanner передаємо йому як параметр InputStream
        Scanner scanner = new Scanner(System.in);

        //Локальна змінна для зьерігання числа рядків
        int stringsNumber;
        //Цикл, що зчитує вказану к-сть рядків. В умові виходу перевіряється корекність
        //вказаної к-сті рядків
        do {
            System.out.println("Enter the number of strings from 1: ");
            //Присвоюється кількість ріядків
            stringsNumber = Integer.parseInt(scanner.nextLine());
            //Умова виходу з циклу
        } while (stringsNumber <= 0);
        System.out.printf("Enter %d strings:%n", stringsNumber);

        //Ініціалізація першого рядка та визначення його довжини
        String s = scanner.nextLine();
        int length = s.length();

        //Ініціалізація локальних змінних
        String minString = s, maxString = s;
        int min = length, max = length;

        //Цикл, який зчитує введені рядки та одночасно визначає
        //максимальний та мінімальний елементи
        for (int i = 0; i < stringsNumber - 1; i++) {
            s = scanner.nextLine();
            length = s.length();

            if (length > max) {
                max = length;
                maxString = s;
            }

            if (length < min) {
                min = length;
                minString = s;
            }
        }

        System.out.println();
        //Виведення результатів
        System.out.printf("Max string - \"%s\", length - %d.%n", maxString, max);
        System.out.printf("Min string - \"%s\", length - %d.", minString, min);
    }
}
