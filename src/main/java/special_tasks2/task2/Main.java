package special_tasks2.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private final static int MAX_NUMBER = 180;

    public static void main(String[] args) {
        try {
            System.out.println(sum(MAX_NUMBER));
        } catch (ExecutionException | InterruptedException e) {
            throw new IllegalStateException();
        }
    }

    private static int sum(int maxNumber) throws ExecutionException, InterruptedException {
        final List<Integer> integers = IntStream.rangeClosed(0, maxNumber)
                .boxed()
                .collect(Collectors.toList());

        List<Callable<Integer>> callables = divideListByNumberOfThreads(integers);

        return getSumOfNumbersThroughExecutorService(callables);
    }

    private static List<Callable<Integer>> divideListByNumberOfThreads(List<Integer> integers) {
        int threadsNumber = Runtime.getRuntime().availableProcessors();

        List<Callable<Integer>> callables = new ArrayList<>();

        final int integersSize = integers.size();
        final int remainder = integersSize % threadsNumber;
        final int integersSizeWithoutRemainder = integersSize - remainder;
        final int step = integersSize / threadsNumber;

        if (step != 0) {
            for (int i = 0; i < integersSizeWithoutRemainder; i += step) {
                int finalI = i;

                callables.add(() -> integers.subList(finalI, finalI + step).stream()
                        .reduce(0, (n1, n2) -> n1 + n2));
            }
        }

        if (remainder != 0) {
            callables.add(() -> integers.subList(integersSizeWithoutRemainder, integersSize).stream()
                    .reduce(0, (n1, n2) -> n1 + n2));
        }
        return callables;
    }

    private static int getSumOfNumbersThroughExecutorService(List<Callable<Integer>> callables) throws InterruptedException, ExecutionException {
        int threadsNumber = Runtime.getRuntime().availableProcessors();

        ExecutorService executorService = Executors.newFixedThreadPool(threadsNumber);

        int result = 0;

        for (Future<Integer> integerFuture : executorService.invokeAll(callables)) {
            result += integerFuture.get();
        }

        executorService.shutdown();

        return result;
    }


}
