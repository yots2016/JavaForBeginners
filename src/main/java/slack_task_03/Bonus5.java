package slack_task_03;

import java.util.Scanner;

public class Bonus5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();

        if (firstNumber > secondNumber) {
            System.out.println(firstNumber - secondNumber);
        } else {
            System.out.println(firstNumber + secondNumber);
        }

    }
}
