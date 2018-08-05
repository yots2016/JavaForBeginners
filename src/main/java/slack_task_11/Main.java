package slack_task_11;

public class Main {
    public static void main(String[] args) {
        //Створення об’єкту типу SomeClass
        SomeClass someClass = new SomeClass();
        System.out.println(someClass.getFirstField() + ", " + someClass.getSecondField());

        //Створення об’єкту типу SomeClass
        SomeClass someClass1 = new SomeClass(134, 6755);
        System.out.println(someClass1.getFirstField() + ", " + someClass1.getSecondField());

    }
}
