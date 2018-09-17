package slack_task_15.subtask5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        //Ініціалізація масиву рядків strings
        for (int i = 0; i < stringsNumber; i++) {
            strings[i] = scanner.next();
        }

        //Виведення результату
        System.out.println("Target words - " + getTargetWords(strings));

    }

    //Метод, що відбирає та повертає масив латинських слів
    public static String[] getLatinWords(String[] inputArray) {
        //Оголошення, визначення та ініціалізація змінної типу Pattern
        //Отримується за допомогою метода compile з регулярного виразу
        Pattern latinPattern = Pattern.compile("[A-z]+");
        //Оголошення змінної типу Matcher
        Matcher latinMatcher;
        //Оголошення та визначення змінної типу List<String>
        List<String> result = new ArrayList<>();

        //Цикл перебору елементів вхідного масиву та відбір тих, що відповідають регулярному виразу
        for (int i = 0; i < inputArray.length; i++) {
            latinMatcher = latinPattern.matcher(inputArray[i]);

                if (latinMatcher.matches()) {
                    result.add(inputArray[i]);
                }
        }

        //Повернення масиву рядків
        return result.toArray(new String[result.size()]);
    }

    //Метод, який вілбирає слова у яких рівна к-сть голосних і приголосних букв
    public static List<String> getTargetWords(String[] inputArray) {
        ////Оголошення, визначення та ініціалізація змінної типу String[]
        String[] latinWords = getLatinWords(inputArray);

        ////Оголошення, визначення змінної типу List<String>
        List<String> result = new ArrayList<>();
        ////Оголошення змінних типу int для підрахунку к-сті голосних та приголосних букв
        int loudLetters, consonantLetters;

        //Цикл перебору всіх слів масиву inputArray
        for (int i = 0; i < inputArray.length; i++) {
            //Присвоєння к-сті приголосних букв
            loudLetters = latinWords[i].replaceAll("[^aeiouAEIOU]", "").length();
            //Присвоєння к-сті голосних букв
            consonantLetters = latinWords[i].replaceAll("[aeiouAEIOU]", "").length();

            //Порвняння к-сті голосних і приголосних букв
            if (loudLetters == consonantLetters) {
                result.add(latinWords[i]);
            }
        }

        return result;
    }
}
