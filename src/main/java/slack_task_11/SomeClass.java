package slack_task_11;

public class SomeClass { //Клас, назва якого не прив’язана до якого-небудь контексту
    //Поля класу, назва яких не прив’язана до якого-небудь контексту
    private final int firstField;
    private final int secondField;

    //Конструктор класу з двома вхідними параметрами
    public SomeClass(int firstField, int secondField) {
        this.firstField = firstField;
        this.secondField = secondField;
    }

    //Конструктор класу, що по замовчуванню ініціалізує поля заданими значення
    public SomeClass() {
        this(10, 11); //Тут Constructor Chaining допомагає уникнути дублювання коду

    }

    @Override
    public String toString() {
        return firstField + ", " + secondField;
    }

    //Гетер для поля firstField
    public int getFirstField() {
        return firstField;
    }

    //Гетер для поля secondField
    public int getSecondField() {
        return secondField;
    }

    //Цей метод викликається тоді, коли збирач сміття вирішить видалити наш об’єкт. Без особої потреби цей метод
    //не бажано оголошувати або перевизначати.
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object \"" + this + "\" was deleted: ");
    }
}
