package slack_task_03;

public class Main {
    private static int a;
    private static int b;

    public static void main(String[] args) {
        a = 10;
        b = 7;

        System.out.println(sum(a, b));
    }

    private static int sum(int a, int b) {
        return a + b;
    }
}
