package special_tasks2.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static class MyCallable implements Callable<Integer> {
        int firstIndex, lastIndex, sum = 0;
        Integer[] numbers;

        public MyCallable(int firstIndex, int lastIndex, Integer[] numbers) {
            this.firstIndex = firstIndex;
            this.lastIndex = lastIndex;
            this.numbers = numbers;
        }

        @Override
        public Integer call() throws Exception {
            for (int i = firstIndex; i <= lastIndex; i++) {
                sum += numbers[i];
            }

            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(sum(6));
    }

    public static long sum(int inputNumber) throws ExecutionException, InterruptedException {
        int sum;
        int threadsNumber = Runtime.getRuntime().availableProcessors();

        Integer[] integers;
        if (inputNumber < 0) {
            integers = new Integer[1];
        } else {
            integers = new Integer[inputNumber + 1];
        }

        int integersLength = integers.length;

        for (int i = 0; i < integersLength; i++) {
            integers[i] = i;
        }

        ExecutorService executorService = Executors.newFixedThreadPool(threadsNumber);
        List<Callable<Integer>> callables = new ArrayList<>();

        if (integersLength % threadsNumber == 0) {
            int step = integersLength / threadsNumber;
            for (int i = 0, firstIndex = 0, lastIndex = step - 1; i < threadsNumber; i++, firstIndex += step, lastIndex += step) {
                callables.add(new MyCallable(firstIndex, lastIndex, integers));
            }

        } else if (integersLength % threadsNumber != 0) {
            int step = integersLength / threadsNumber;
            int remainder = integersLength % threadsNumber;

            callables.add(new MyCallable(0, remainder - 1, integers));

            if (step != 0) {
                for (int i = 0, firstIndex = remainder, lastIndex = step; i < threadsNumber; i++, firstIndex += step, lastIndex += step) {
                    callables.add(new MyCallable(firstIndex, lastIndex, integers));
                }
            }
        }
        sum = executorService.invokeAll(callables).stream()
                .map(integerFuture -> {
                    try {
                        return integerFuture.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .mapToInt(n -> n)
                .sum();

        executorService.shutdown();

        return sum;
    }
}
