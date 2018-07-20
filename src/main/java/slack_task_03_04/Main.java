package slack_task_03_04;

public class Main {
    private static int a;
    private static int b;

    public static void main(String[] args) {
        a = 10;
        b = 7;

        System.out.println(sum(a, b)); //the amount is deducted
    }

    private static int sum(int a, int b) {
        return a + b;
    }
}
