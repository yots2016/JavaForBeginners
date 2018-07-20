package slack_task_05;

public class Main {
    public static void main(String[] args) {
        printNumbers();

        System.out.println(function(10));
    }

    private static void printNumbers() {
        for (int i = 1; i <= 20; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    private static int function(int n) {
        if (n == 0) return 1;
        return n + function(n - 1);
    }
}
