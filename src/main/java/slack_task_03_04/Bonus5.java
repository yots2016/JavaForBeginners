package slack_task_03_04;

import java.util.Scanner;

public class Bonus5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt(); //the number value is read
        int secondNumber = scanner.nextInt(); //the number value is read

        // check which number is more
        if (firstNumber > secondNumber) {
            System.out.println(firstNumber - secondNumber);
        } else {
            System.out.println(firstNumber + secondNumber);
        }

    }
}
