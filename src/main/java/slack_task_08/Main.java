package slack_task_08;

import java.util.Arrays;
import java.util.Formatter;

public class Main {
    public static void main(String[] args) {
        System.out.println(getString("strinf", 17, 145.132554654));
        System.out.println();

        int[] numbersArray = new int[] {1, 48, 78, 25, 13};
        reverseArray(numbersArray);
        System.out.println(Arrays.toString(numbersArray));
        System.out.println();

        System.out.println(reverseString("Hello World! Hello Java! :-)", new Formatter()));
    }

    //Метод поверення рядка складеного з вхідних параметрів
    private static String getString(String characterString, int number, double numberWithFloatingPoint) {
        return ("S = " + characterString + " + " + number + " + " + numberWithFloatingPoint + ".");
    }

    //Метод перевертання масиву
    private static void reverseArray(int[] sourceArray) {
        for (int i = 0; i < sourceArray.length / 2; i++) {
            int tmp = sourceArray[i];
            sourceArray[i] = sourceArray[sourceArray.length - i - 1];
            sourceArray[sourceArray.length - i - 1] = tmp;
        }
    }

    //Метод перевертання рядка
    private static String reverseString(String inputString, Formatter formatter) {
        /*
        У рекурсивний метод постійно потраплятиме рядок без першого символу, а перед цим
         цей же перший символ буде витягуватися кудись у тимчасове місце зберігання(зараз це не важливо, куди саме).
         Коли в рядку не залишиться символів всі витягнуті символи
         складуться у порядку від останнього витягнутого до першоого.
         Порядок виконання методів записується у такий собі стек і коли рекурсивний прохід закінчився,
         починають забиратися зі стеку та виконуватися. А так як стек це структура "першим прийшов, прешим пішов",
         то першим виконається останній метод, який сюди записався і так аж до першого з якого все почалося.
         Останнім виконається пеший метод.
         Щоб було простіше уявіть собі for з downto який виконує певний метод, а його параметром є індекс цього for`у.
         Може трішки примітивно. Мені так було простіше зрозуміти ;-)
        */
        if (inputString!= null && !(inputString.isEmpty())) {
            reverseString(inputString.substring(1), formatter);
            return formatter.format("%s", inputString.charAt(0)).toString();
        } else {
            return "";
        }

    }
}
