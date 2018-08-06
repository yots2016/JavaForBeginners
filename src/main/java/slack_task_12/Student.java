package slack_task_12;

public class Student extends Person{
    //Поле класу
    private String name;

    //Конструктор класу з трьома вхідними параметрами
    public Student(String gender, int age, String name) {
        super(gender, age); //Виклик конструктора батьківського класу з двома параметрами
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ", " + super.getGender() + ", " + super.getAge();
    }

    //Гетер для поля name
    public String getName() {
        return name;
    }

    //Сетер для поля name
    public void setName(String name) {
        this.name = name;
    }
}
