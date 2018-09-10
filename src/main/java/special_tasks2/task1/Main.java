package special_tasks2.task1;

import com.sun.istack.internal.NotNull;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<String> strings = IntStream.rangeClosed(1, 100).mapToObj(String::valueOf).collect(Collectors.toList());
        Collections.shuffle(strings);

        System.out.println(min(strings));
        System.out.println(max(strings));
        System.out.println(filterParity(strings));

    }

    public static List<String> min(@NotNull List<String> strings) {
        LinkedList<String> result = new LinkedList<>(strings);

        String min = Collections.min(result, Comparator.comparingInt(Integer::parseInt));
        result.remove(min);
        result.addFirst(min);

        return result;
    }

    public static List<String> max(@NotNull List<String> strings) {
        int indexOfMax = 0;
        int max = 0;

        for (int i = 0; i < strings.size(); i++) {
            if (Integer.parseInt(strings.get(i)) > max)
            {
                max = Integer.parseInt(strings.get(i));
                indexOfMax = i;
            }
        }

        List<String> beforeMax = strings.subList(0, indexOfMax);
        List<String> afterMax = strings.subList(indexOfMax, strings.size());

        beforeMax.sort(Comparator.comparingInt(Integer::parseInt));
        afterMax.sort((a, b) -> Integer.compare(Integer.parseInt(b), Integer.parseInt(a)));

        List<String> result = new ArrayList<>(beforeMax.size() + afterMax.size());
        result.addAll(beforeMax);
        result.addAll(afterMax);

        return result;
    }

    public static List<String> filterParity(@NotNull List<String> strings) {
        AtomicLong sum = new AtomicLong();
        return strings.stream()
                .collect(Collectors.partitioningBy(s -> {
                    int x = Integer.parseInt(s);
                    sum.addAndGet(x);
                    return x % 2 != 0; }))
                .get(sum.longValue() % 2 == 0);
    }
}
