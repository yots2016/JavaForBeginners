package slack_task_13;

public class Circle {
    // Конструктор класу
    public Circle(double radius) {
        this.radius = radius;
    }

    // Поле класу
    private double radius;

    // Метод, що обраховує та повертає площу
    public double getSquare(){
        return Math.PI * Math.pow(radius, 2);
    }

    // Метод, що обраховує та повертає довжину кола
    public double getLength() {
        return 2 * Math.PI * radius;
    }

    // Метод, що обраховує та повертає число PI
    public double getPI() {
        return getLength() / (2 * radius);
    }
}
