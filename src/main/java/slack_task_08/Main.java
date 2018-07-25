package slack_task_08;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(functionThatReturnsString("strinf", 17, 145.132554654));
        System.out.println();

        System.out.println(Arrays.toString(getReversedArray(new int[] {1, 48, 78, 25, 13})));
        System.out.println();

        String string = "Hello World! Hello Java! :-)";
        System.out.println(reverseString(string));
    }

    //Метод поверення рядка складеного з вхідних параметрів
    private static String functionThatReturnsString(String string, int integer, double numberWithFloatingPoint) {
        return ("S = " + string + " + " + integer + " + " + numberWithFloatingPoint + ".");
    }

    //Метод перевертання масиву
    private static int[] getReversedArray(int[] sourceArray) {
        for (int i = 0; i < sourceArray.length / 2; i++) {
            int tmp = sourceArray[i];
            sourceArray[i] = sourceArray[sourceArray.length - i - 1];
            sourceArray[sourceArray.length - i - 1] = tmp;
        }

        return sourceArray;
    }

    //Метод перевертання рядка
    private static String reverseString(String str) {
        /*
        У рекурсивний метод постійно потраплятиме рядок без першого символу, а перед цим
         цей же перший символ буде витягуватися кудись у тимчасове місце зберігання(зараз це не важливо, куди саме).
         Коли в рядку не залишиться символів всі витягнуті символи
         складуться у порядку від останнього витягнутого до першоого. Бо ця дія робиться не рекурсивно.
         Рекурсивно викликається лише метод з параметром без першого символу.
        */
        return str.isEmpty() ? "" : reverseString(str.substring(1)) + str.charAt(0);
    }
}
