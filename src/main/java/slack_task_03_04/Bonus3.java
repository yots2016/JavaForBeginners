package slack_task_03_04;

import java.util.Scanner;

public class Bonus3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt(); //the number value is readToListIO

        //checking or dividing the number by 7 without loss
        if (number % 7 == 0) {
            System.out.println(number * 2);
        } else {
            System.out.println(number);
        }
    }
}
