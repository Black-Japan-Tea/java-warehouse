import java.io.*;

public class GarageStorage {

    // Метод для сохранения гаража в файл
    public static void saveGarage(Garage garage, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(garage);
            System.out.println("Данные успешно сохранены в файл: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }

    // Метод для загрузки гаража из файла
    public static Garage loadGarage(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Garage garage = (Garage) ois.readObject();
            System.out.println("Данные успешно загружены из файла: " + filename);
            return garage;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке данных: " + e.getMessage());
            return new Garage(); // Возвращаем новый пустой гараж, если файл не найден или произошла ошибка
        }
    }
}