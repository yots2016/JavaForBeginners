package special_tasks1.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeadlockWithResourcesV2 {
    public static void main(String[] args) {

        List<Integer> elements1 = new ArrayList<>(Arrays.asList(12, 34, 2, 56, 34, 90000, 77, 890));
        List<Integer> elements2 = new ArrayList<>(Arrays.asList(2109, 4, 77777, 67676767, 1, 2));

        new Thread(() -> moveElements(elements1, elements2, 3)).start();
        new Thread(() -> moveElements(elements2, elements1, 2)).start();
    }

    private static void moveElements() {
    }

    public static void moveElements(List<Integer> from, List<Integer> to, Integer element) {
        log("attempting lock for list", from);

        synchronized (from) {
            log("lock acquired for list", from);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log("attempting lock for list ", to);

            synchronized (to) {

                log("lock acquired for list", to);

                if (from.remove(element)) {
                    to.add(element);
                }

                log("moved item to list ", to);
            }
        }
    }

    public static void log (String msg, Object target) {
        System.out.println(Thread.currentThread().getName() +
                ": " + msg + " " +
                System.identityHashCode(target));
    }
}
