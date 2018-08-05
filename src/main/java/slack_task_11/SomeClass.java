package slack_task_11;

public class SomeClass {
    //Поля класу, назва яких не прив’язана до якого-небудь контексту
    private int firstField;
    private int secondField;

    //Конструктор класу з двома вхідними параметрами
    public SomeClass(int firstField, int secondField) {
        this.firstField = firstField;
        this.secondField = secondField;
    }

    //Конструктор класу, що по зпмовчуванню ініціалізує поля заданими значення
    public SomeClass() {
        this.firstField = 10;
        this.secondField = 11;

    }

    //Цей метод викликається тоді, коли збирач сміття вирішить видалити наш об’єкт. Без особої потреби цей метод
    //не бажано перевизначати.
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object was deleted");
    }
}
