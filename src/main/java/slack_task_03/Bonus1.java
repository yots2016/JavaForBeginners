package slack_task_03;

import java.util.Scanner;

public class Bonus1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt(); //the time value is read

        /*
        *Determine whether the numeric value
        * belongs to the time range
        */
        if (time >= 0 && time <= 24) {
            if (time >= 9 && time < 18) {
                System.out.println("I`m at work");
            } else {
                System.out.println("I rest");
            }
        } else {
            System.out.println("The number is not from the time interval");
        }
    }
}
