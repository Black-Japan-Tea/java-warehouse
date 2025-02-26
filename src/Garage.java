import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Класс, представляющий гараж
class Garage implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<Part> parts; // Список деталей

    // Конструктор
    public Garage() {
        parts = new ArrayList<>();
    }

    // Метод для добавления детали
    public void addPart(Part part) {
        parts.add(part);
        System.out.println("Деталь добавлена!");
    }

    // Метод для удаления детали по серийному номеру
    public void removePart(String serialNumber) {
        Part partToRemove = null;
        for (Part part : parts) {
            if (part.serialNumber().equals(serialNumber)) {
                partToRemove = part;
                break;
            }
        }
        if (partToRemove != null) {
            parts.remove(partToRemove);
            System.out.println("Деталь удалена!");
        } else {
            System.out.println("Деталь с серийным номером " + serialNumber + " не найдена.");
        }
    }

    // Метод для просмотра всех деталей, отсортированных по дате добавления (последняя добавленная = последняя в списке)
    public void viewAllParts() {
        if (parts.isEmpty()) {
            System.out.println("В гараже нет деталей.");
            return;
        }

        // Сортировка по дате покупки (последняя добавленная = последняя в списке)
        parts.sort((p1, p2) -> p2.purchaseDate().compareTo(p1.purchaseDate()));

        // Вывод всех деталей
        for (Part part : parts) {
            System.out.println(part);
            System.out.println("-----------------------------");
        }
    }

    // Метод для поиска детали по названию
    public void searchPartByName(String name) {
        boolean found = false;
        for (Part part : parts) {
            if (part.name().equalsIgnoreCase(name)) {
                System.out.println(part);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Деталь с названием \"" + name + "\" не найдена.");
        }
    }

    // Метод для просмотра деталей по предназначению
    public void viewPartsByPurpose(String purpose) {
        boolean found = false;
        for (Part part : parts) {
            if (part.purpose().equalsIgnoreCase(purpose)) {
                System.out.println(part);
                System.out.println("-----------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Детали с предназначением \"" + purpose + "\" не найдены.");
        }
    }
}