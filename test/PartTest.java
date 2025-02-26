import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PartTest {

    @Test
    void testPartCreation() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date purchaseDate = dateFormat.parse("01.01.2023");

        Part part = new Part("Двигатель", "Свеча зажигания", "Свеча для бензинового двигателя",
                500.0, 4, "12345", purchaseDate);

        assertEquals("Двигатель", part.purpose());
        assertEquals("Свеча зажигания", part.name());
        assertEquals("Свеча для бензинового двигателя", part.description());
        assertEquals(500.0, part.price());
        assertEquals(4, part.quantity());
        assertEquals("12345", part.serialNumber());
        assertEquals(purchaseDate, part.purchaseDate());
    }

    @Test
    void testToString() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date purchaseDate = dateFormat.parse("01.01.2023");

        Part part = new Part("Двигатель", "Свеча зажигания", "Свеча для бензинового двигателя",
                500.0, 4, "12345", purchaseDate);

        String expected = """
                Предназначение: Двигатель
                Название: Свеча зажигания
                Описание: Свеча для бензинового двигателя
                Цена за штуку: 500.0 руб.
                Количество: 4
                Серийный номер: 12345
                Дата покупки: 01.01.2023
                """;

        assertEquals(expected, part.toString());
    }
}