package slack_task_12;

public class Person {
    //Поля класу
    private String gender;
    private int age;

    //Конструктор класу з двома вхідними параметрами
    public Person(String gender, int age) {
        this.gender = gender;
        this.age = age;
    }

    //Гетер для поля gender
    public String getGender() {
        return gender;
    }

    //Сетер для поля gender
    public void setGender(String gender) {
        this.gender = gender;
    }

    //Гетер для поля age
    public int getAge() {
        return age;
    }

    //Сетер для поля age
    public void setAge(int age) {
        this.age = age;
    }
}
