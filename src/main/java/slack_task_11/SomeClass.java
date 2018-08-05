package slack_task_11;

public class SomeClass { //Клас, назва якого не прив’язана до якого-небудь контексту
    //Поля класу, назва яких не прив’язана до якого-небудь контексту
    private int firstField;
    private int secondField;

    //Конструктор класу з двома вхідними параметрами
    SomeClass(int firstField, int secondField) {
        this.firstField = firstField;
        this.secondField = secondField;
    }

    //Конструктор класу, що по зпмовчуванню ініціалізує поля заданими значення
    SomeClass() {
        this.firstField = 10;
        this.secondField = 11;

    }

    //Гетер для поля firstField
    int getFirstField() {
        return firstField;
    }

    //Гетер для поля secondField
    int getSecondField() {
        return secondField;
    }

    //Цей метод викликається тоді, коли збирач сміття вирішить видалити наш об’єкт. Без особої потреби цей метод
    //не бажано оголошувати або перевизначати.
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object \"" + this + "\" was deleted: ");
    }
}
