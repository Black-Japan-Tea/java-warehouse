import java.io.Serial;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @param purpose      Предназначение (Двигатель, Подвеска и т.д.)
 * @param name         Название
 * @param description  Описание
 * @param price        Цена за штуку
 * @param quantity     Количество
 * @param serialNumber Серийный номер
 * @param purchaseDate Дата покупки
 */ // Класс, представляющий деталь
record Part(String purpose, String name, String description, double price, int quantity, String serialNumber,
            Date purchaseDate) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    // Конструктор для создания детали

    // Переопределение метода toString для удобного вывода информации о детали
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return "Предназначение: " + purpose + "\n" +
                "Название: " + name + "\n" +
                "Описание: " + description + "\n" +
                "Цена за штуку: " + price + " руб.\n" +
                "Количество: " + quantity + "\n" +
                "Серийный номер: " + serialNumber + "\n" +
                "Дата покупки: " + dateFormat.format(purchaseDate) + "\n";
    }
}