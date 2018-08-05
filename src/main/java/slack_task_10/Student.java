package slack_task_10;

public class Student {

    //Поля класу з доступом лише для членів класу
    private String name;
    private String course;

    //Конструктор класу, який при створенні об’єкту ініалізує його поля значеннями, що передаються в цей конструктор
    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    //Геттер для поля name
    public String getName() {
        return name;
    }

    //Геттер для поля course
    public String getCourse() {
        return course;
    }
}
