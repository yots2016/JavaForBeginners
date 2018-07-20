package slack_task_03;

import java.util.*;

public class Bonus2 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            integers.add(scanner.nextInt());
        }

        System.out.println("Max " + Collections.max(integers));
        System.out.println("Min " + Collections.min(integers));
    }
}
