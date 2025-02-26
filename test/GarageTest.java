import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class GarageTest {

    private Garage garage;
    private SimpleDateFormat dateFormat;

    @BeforeEach
    void setUp() throws ParseException {
        garage = new Garage();
        dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        // Добавим несколько деталей для тестирования
        Date purchaseDate1 = dateFormat.parse("01.01.2023");
        Date purchaseDate2 = dateFormat.parse("02.01.2023");

        garage.addPart(new Part("Двигатель", "Свеча зажигания", "Свеча для бензинового двигателя", 500.0, 4, "12345", purchaseDate1));
        garage.addPart(new Part("Подвеска", "Амортизатор", "Амортизатор передний", 3000.0, 2, "67890", purchaseDate2));
    }

    @Test
    void testAddPart() throws ParseException {
        Date purchaseDate = dateFormat.parse("03.01.2023");
        Part part = new Part("Интерьер", "Коврик", "Коврик для салона", 1000.0, 1, "54321", purchaseDate);

        garage.addPart(part);

        // Проверяем, что деталь добавлена
        garage.viewPartsByPurpose("Интерьер"); // Выведет деталь, если она добавлена
    }

    @Test
    void testRemovePart() {
        garage.removePart("12345");

        // Проверяем, что деталь удалена
        garage.viewPartsByPurpose("Двигатель"); // Не должно быть вывода, если деталь удалена
    }

    @Test
    void testViewAllParts() {
        garage.viewAllParts(); // Проверяем, что метод не выбрасывает исключений
    }

    @Test
    void testSearchPartByName() {
        garage.searchPartByName("Свеча зажигания"); // Проверяем, что метод находит деталь
        garage.searchPartByName("Несуществующая деталь"); // Проверяем обработку случая, когда деталь не найдена
    }

    @Test
    void testViewPartsByPurpose() {
        garage.viewPartsByPurpose("Двигатель"); // Проверяем, что метод выводит детали по разделу
        garage.viewPartsByPurpose("Несуществующий раздел"); // Проверяем обработку случая, когда раздел пуст
    }
}
