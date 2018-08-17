package slack_task_13;

public class Circle {
    // Статичне поле класу, константа типу double
    private static final double PI = 3.14159265359;

    // Поле класу
    private double radius;

    // Конструктор класу
    public Circle(double radius) {
        this.radius = radius;
    }

    // Метод, що обраховує та повертає площу
    public double getSquare(){
        return PI * Math.pow(radius, 2);
    }

    // Метод, що обраховує та повертає довжину кола
    public double getLength() {
        return 2 * PI * radius;
    }

    // Метод, що обраховує та повертає число PI
    public double getPI() {
        return PI;
    }
}
