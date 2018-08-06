package slack_task_10;

class Student {

    //Поля класу з доступом лише для членів класу
    private final String name;
    private final String course;

    //Конструктор класу, який при створенні об’єкту ініалізує його поля значеннями, що передаються в цей конструктор
    Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return name + ": " + course;
    }

    //Геттер для поля name
    String getName() {
        return name;
    }

    //Геттер для поля course
    String getCourse() {
        return course;
    }
}
