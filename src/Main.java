import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Главный класс с консольным интерфейсом
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        // Загрузка данных из файла при запуске
        Garage garage = GarageStorage.loadGarage("garage_data.ser");

        while (true) {
            // Вывод меню
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить деталь");
            System.out.println("2. Удалить деталь");
            System.out.println("3. Просмотреть все детали");
            System.out.println("4. Поиск детали по названию");
            System.out.println("5. Просмотреть детали по разделу");
            System.out.println("6. Выйти");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после nextInt()

            switch (choice) {
                case 1: // Добавление детали
                    System.out.print("Введите предназначение (Двигатель, Подвеска, Интерьер, Экстерьер, Электрика, Инструмент): ");
                    String purpose = scanner.nextLine();
                    System.out.print("Введите название: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите описание: ");
                    String description = scanner.nextLine();
                    System.out.print("Введите цену за штуку: ");
                    double price = scanner.nextDouble();
                    System.out.print("Введите количество: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера
                    System.out.print("Введите серийный номер или артикул: ");
                    String serialNumber = scanner.nextLine();
                    System.out.print("Введите дату покупки (в формате дд.мм.гггг): ");
                    String dateString = scanner.nextLine();
                    try {
                        Date purchaseDate = dateFormat.parse(dateString);
                        Part part = new Part(purpose, name, description, price, quantity, serialNumber, purchaseDate);
                        garage.addPart(part);
                    } catch (ParseException e) {
                        System.out.println("Неверный формат даты! Попробуйте снова.");
                    }
                    GarageStorage.saveGarage(garage, "garage_data.ser");
                    break;

                case 2: // Удаление детали
                    System.out.print("Введите серийный номер детали для удаления: ");
                    String serialToRemove = scanner.nextLine();
                    garage.removePart(serialToRemove);
                    GarageStorage.saveGarage(garage, "garage_data.ser");
                    break;

                case 3: // Просмотр всех деталей
                    garage.viewAllParts();
                    break;

                case 4: // Поиск детали по названию
                    System.out.print("Введите название детали для поиска: ");
                    String searchName = scanner.nextLine();
                    garage.searchPartByName(searchName);
                    break;

                case 5: // Просмотр деталей по разделу
                    System.out.print("Введите раздел (Двигатель, Подвеска, Интерьер, Экстерьер, Электрика, Инструмент): ");
                    String searchPurpose = scanner.nextLine();
                    garage.viewPartsByPurpose(searchPurpose);
                    break;

                case 6: // Выход
                    System.out.println("Выход из программы.");
                    // Сохранение данных в файл перед выходом
                    GarageStorage.saveGarage(garage, "garage_data.ser");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}