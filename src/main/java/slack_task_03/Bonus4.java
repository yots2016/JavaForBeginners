package slack_task_03;

import java.util.Scanner;

public class Bonus4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = scanner.nextDouble();

        if (number > 0 && number < 1) {
            System.out.println("Number in range");
        } else {
            System.out.println("Number is not in range");
        }
    }
}
