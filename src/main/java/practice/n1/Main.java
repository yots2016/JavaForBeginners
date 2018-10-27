package practice.n1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3"));

        ListMultiplicator.multiply(list, 2);

        System.out.println(list);
    }
}

/**
 * Class to modify
 */
class ListMultiplicator {

    /**
     * Multiplies original list provided numper of times
     *
     * @param list list to multiply
     * @param n    times to multiply, should be zero or greater
     */
    public static void multiply(List<?> list, int n) {
        // Add implementation here

        if (n == 0) {
            list.clear();
        } else {
            multiplyHelper(list, n);
        }

    }

    private static <T> void multiplyHelper(List<T> list, int n) {
        List<T> source = new ArrayList<>(list);
        for (int i = 0; i < n - 1; i++) {
            list.addAll(source);
        }
    }
}
