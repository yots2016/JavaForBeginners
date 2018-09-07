package special_tasks2.task1;

import com.sun.istack.internal.NotNull;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    enum Parity {
        EVEN(true),
        ODD(false);

        private boolean parity;

        Parity(boolean parity) {
            this.parity = parity;
        }

        public boolean isPair() {
            return parity;
        }
    }

    public static void main(String[] args) {
        List<String> strings = IntStream.rangeClosed(1, 100).mapToObj(String::valueOf).collect(Collectors.toList());
        Collections.shuffle(strings);

        System.out.println(min(strings));
        System.out.println(max(strings));
        System.out.println(filterParity(strings));

    }

    public static List<String> min(@NotNull List<String> strings) {
        List<String> stringList = new ArrayList<>(strings);

        String min = Collections.min(stringList, Comparator.comparingInt(Integer::parseInt));
        stringList.remove(min);
        stringList.add(0, min);
        return stringList;
    }

    public static List<String> max(@NotNull List<String> strings) {
        String  max = Collections.max(strings, Comparator.comparingInt(Integer::parseInt));

        int indexOfMax = strings.indexOf(max);

        List<String> beforeMax = strings.subList(0, indexOfMax);
        List<String> afterMax = strings.subList(indexOfMax + 1, strings.size());

        beforeMax.sort(Comparator.comparingInt(Integer::parseInt));
        afterMax.sort((a, b) -> Integer.compare(Integer.parseInt(b), Integer.parseInt(a)));

        List<String> result = new ArrayList<>(beforeMax.size() + afterMax.size() + 1);
        result.addAll(beforeMax);
        result.add(max);
        result.addAll(afterMax);

        return result;
    }

    public static List<String> filterParity(@NotNull List<String> strings) {
        Predicate<String> predicate = s -> (Integer.parseInt(s) % 2) != 0;

        Map<Boolean, List<String>> map = strings.stream()
                .collect(Collectors.partitioningBy(predicate));

        int sum = strings.stream()
                .mapToInt(Integer::parseInt)
                .sum();

        if (sum % 2 != 0) {
            return map.get(Parity.ODD.isPair());
        } else {
            return map.get(Parity.EVEN.isPair());
        }
    }
}
