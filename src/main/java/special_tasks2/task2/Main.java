package special_tasks2.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
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
        public Integer call() {
            for (int i = firstIndex; i <= lastIndex; i++) {
                sum += numbers[i];
            }

            return sum;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(sum(181));
    }

    public static long sum(int inputNumber) throws InterruptedException {
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

        int threadsNumber = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(threadsNumber);
        List<Callable<Integer>> callables = new ArrayList<>();

        if (integersLength % threadsNumber == 0) {
            int step = integersLength / threadsNumber;
            for (int i = 0, firstIndex = 0, lastIndex = step - 1; i < threadsNumber; i++, firstIndex += step, lastIndex += step) {
                callables.add(new MyCallable(firstIndex, lastIndex, integers));
            }

        } else {
            int step = integersLength / threadsNumber;
            int remainder = integersLength % threadsNumber;

            callables.add(new MyCallable(0, remainder - 1, integers));

            if (step != 0) {
                for (int i = 0, firstIndex = remainder, lastIndex = (step + remainder - 1); i < threadsNumber; i++, firstIndex += step, lastIndex += step) {
                    callables.add(new MyCallable(firstIndex, lastIndex, integers));
                }
            }
        }

        long sum = sumResults(executorService, callables);

        executorService.shutdown();

        return sum;
    }

    public static long sumResults(ExecutorService executorService, List<Callable<Integer>> callables) throws InterruptedException {
        return executorService.invokeAll(callables).stream()
                .map(integerFuture -> {
                    try {
                        return integerFuture.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .reduce(0, (n1, n2) -> n1 + n2);
    }
}
