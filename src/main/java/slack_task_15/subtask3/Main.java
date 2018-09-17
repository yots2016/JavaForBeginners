package slack_task_15.subtask3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        int sum = 0;
        //Ініціалізація масиву рядків та підрахунок суми довжин цих рядків
        for (int i = 0; i < stringsNumber; i++) {
            strings[i] = scanner.nextLine();
            sum+=strings[i].length();
        }

        //Оголошення, визначення та ініалізація масиву який містить середнє значення довжини рядків
        int[] average = {sum / strings.length};

        //Оголошення та визначення змінної типу Map. Створення stream з масиву рядків.
        //Розподілення елементів stream з використання метода класу Collectors
        Map<Boolean, List<String>> map = Stream.of(strings)
                .collect(Collectors.partitioningBy(s -> s.length() > average[0]));

        //Перебір ключів об'єкта map
        map.forEach((aBoolean, stringList) -> {
            if (!aBoolean) {
                System.out.println("Strings whose length is less than  the average:");
            } else {
                System.out.println("Strings whose length is greater than the average:");
            }
            //Перебір всіх значень кожного ключа
            stringList.forEach(s -> System.out.printf("String - %s. It`s length - %d.%n", s, s.length()));
            System.out.println();
        });




    }
}
