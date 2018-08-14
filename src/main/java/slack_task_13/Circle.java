package slack_task_13;

public class Circle {
    public Circle(double radius) {
        this.radius = radius;
    }

    private double radius;

    public double getSquare(){
        return Math.PI * Math.pow(radius, 2);
    }

    public double getLength() {
        return 2 * Math.PI * radius;
    }

    public double getPI() {
        return getLength() / (2 * radius);
    }
}
