package slack_task_03_04;

import java.util.*;

public class Bonus2 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            integers.add(scanner.nextInt()); //the number values is read
        }

        //definition of maximum and minimum values
        System.out.println("Max " + Collections.max(integers));
        System.out.println("Min " + Collections.min(integers));
    }
}
