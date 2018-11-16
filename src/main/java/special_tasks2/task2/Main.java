package special_tasks2.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private final static int MAX_NUMBER = new Random().nextInt(300);
    private final static int THREADS_NUMBER = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws InterruptedException {
        List<Integer> integers = IntStream.rangeClosed(0, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        List<List<Integer>> partitions = divideListToPartitions(integers);

        System.out.println(calculateSum(partitions));
    }

    private static List<List<Integer>> divideListToPartitions(List<Integer> integers) {
        List<List<Integer>> partitions = new ArrayList<>();
        int partitionSize = calculatePartitionSize(integers);

        for (int i = 0; i < integers.size(); i += partitionSize) {
            partitions.add(integers.subList(i, Math.min(i + partitionSize, integers.size())));
        }
        return partitions;
    }

    private static int calculatePartitionSize(List<Integer> integers) {
        int partitionSize;

        if (integers.size() >= THREADS_NUMBER) {
            partitionSize = integers.size() / THREADS_NUMBER;
        } else {
            partitionSize = 1;
        }
        return partitionSize;
    }

    private static int calculateSum(List<List<Integer>> partitions) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_NUMBER);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        CountDownLatch countDownLatch = new CountDownLatch(partitions.size());

        for (int i = 0; i < partitions.size(); i++) {
            int finalI = i;
            executorService.execute(() -> {
               partitions.get(finalI).forEach(atomicInteger::addAndGet);
               countDownLatch.countDown();
            });

        }

        countDownLatch.await();
        executorService.shutdown();

        return atomicInteger.get();
    }
}
