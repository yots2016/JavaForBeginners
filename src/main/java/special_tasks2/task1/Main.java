package special_tasks2.task1;

import com.sun.istack.internal.NotNull;
import sun.plugin.javascript.navig.LinkArray;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> strings = IntStream.rangeClosed(1, 100).mapToObj(String::valueOf).collect(Collectors.toList());
        Collections.shuffle(strings);

        System.out.println(min(strings));
        System.out.println(max(strings));
        System.out.println(filterParityOdd(strings));
    }

    public static List<String> min(@NotNull List<String> strings) {
        int min = strings.stream()
                        .mapToInt(Integer::parseInt)
                        .min()
                        .getAsInt();

        List<String> stringList = new ArrayList<>(strings);
        stringList.remove(String.valueOf(min));
        stringList.add(0, String.valueOf(min));

        return stringList;
    }

    public static List<String> max(@NotNull List<String> strings) {
        int max = strings.stream()
                        .mapToInt(Integer::parseInt)
                        .max()
                        .getAsInt();

        int indexOfMax = strings.indexOf(String.valueOf(max));

        List<String> beforeMax = strings.subList(0, indexOfMax);
        List<String> afterMax = strings.subList(indexOfMax + 1, strings.size());

        beforeMax.sort(Comparator.comparingInt(Integer::parseInt));
        afterMax.sort((a, b) -> Integer.parseInt(b) - Integer.parseInt(a));

        List<String> result = new ArrayList<>(beforeMax.size() + afterMax.size() + 1);
        result.addAll(beforeMax);
        result.add(String.valueOf(max));
        result.addAll(afterMax);

        return result;
    }

    public static List<String> filterParityOdd(@NotNull List<String> strings) {
        Supplier<Stream<String>> streamSupplier = strings::stream;

        List<String> result;

        int sum = streamSupplier.get()
                .mapToInt(Integer::parseInt)
                .sum();

        if (sum % 2 != 0) {
            result = streamSupplier.get()
                                .mapToInt(Integer::parseInt)
                                .filter(n -> n % 2 == 0)
                                .mapToObj(String::valueOf)
                                .collect(Collectors.toList());
        } else {
            result = streamSupplier.get()
                    .mapToInt(Integer::parseInt)
                    .filter(n -> n % 2 != 0)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.toList());
        }

        return result;
    }
}
