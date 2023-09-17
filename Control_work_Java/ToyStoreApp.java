import java.io.*;
import java.util.*;

class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weight;

    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }
}

class ToyStore {
    private List<Toy> toys = new ArrayList<>();
    private List<Toy> prizeToys = new ArrayList<>();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    public Toy drawPrizeToy() {
        List<Toy> prizeToys = new ArrayList<>();
        for (Toy toy : toys) {
            int numPrizes = (int) (toy.getWeight() * 100);
            for (int i = 0; i < numPrizes; i++) {
                prizeToys.add(toy);
            }
        }

        if (prizeToys.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(prizeToys.size());
        Toy prizeToy = prizeToys.get(randomIndex);
        prizeToys.remove(randomIndex);

        for (Toy toy : toys) {
            if (toy.getId() == prizeToy.getId()) {
                toy.decreaseQuantity();
                break;
            }
        }

        prizeToys.add(prizeToy); // Добавляем призовую игрушку в список выданных призов
        savePrizeToysToFile(prizeToy); // Записываем призовую игрушку в файл

        return prizeToy;
    }

    // Метод для записи призовых игрушек в файл
    private void savePrizeToysToFile(Toy prizeToy) {
        try (FileWriter writer = new FileWriter("prize_toys.txt", true)) {
            writer.write("ID: " + prizeToy.getId() + "\n");
            writer.write("Name: " + prizeToy.getName() + "\n");
            writer.write("Quantity: " + prizeToy.getQuantity() + "\n");
            writer.write("Weight: " + prizeToy.getWeight() + "\n");
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Toy> getToys() {
        return toys;
    }
}

public class ToyStoreApp {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        Toy toy1 = new Toy(1, "Action Figure", 10, 0.2);
        Toy toy2 = new Toy(2, "Doll", 15, 0.3);
        Toy toy3 = new Toy(3, "Puzzle", 20, 0.1);

        toyStore.addToy(toy1);
        toyStore.addToy(toy2);
        toyStore.addToy(toy3);

        // Пример изменения веса игрушки
        toyStore.updateToyWeight(1, 0.4);

        // Пример розыгрыша игрушки
        Toy prizeToy = toyStore.drawPrizeToy();
        if (prizeToy != null) {
            System.out.println("Поздравляем! Вы выиграли игрушку: " + prizeToy.getName());
        } else {
            System.out.println("Извините, больше нет призовых игрушек.");
        }
    }
}
