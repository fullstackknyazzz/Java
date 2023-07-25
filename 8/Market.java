import java.util.LinkedList;
import java.util.Queue;

// Интерфейс QueueBehaviour
interface QueueBehaviour<T> {
    void enqueue(T item); // Добавить элемент в конец очереди
    T dequeue(); // Удалить и вернуть элемент из начала очереди
    int size(); // Возвращает количество элементов в очереди
    boolean isEmpty(); // Проверяет, является ли очередь пустой
}

// Интерфейс MarketBehaviour
interface MarketBehaviour {
    void addPersonToQueue(String personName); // Добавить человека в очередь
    void removePersonFromQueue(); // Удалить человека из очереди
    void update(); // Обновить состояние магазина (принять и отдать заказы)
}

// Реализация класса Market, реализующего оба интерфейса
public class Market implements QueueBehaviour<String>, MarketBehaviour {
    private Queue<String> queue = new LinkedList<>();
    private int orderCounter = 0;

    @Override
    public void enqueue(String personName) {
        queue.add(personName);
    }

    @Override
    public String dequeue() {
        return queue.poll();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void addPersonToQueue(String personName) {
        enqueue(personName);
        System.out.println(personName + " добавлен в очередь.");
    }

    @Override
    public void removePersonFromQueue() {
        if (!isEmpty()) {
            String person = dequeue();
            System.out.println(person + " вышел из очереди.");
        } else {
            System.out.println("Очередь пуста.");
        }
    }

    @Override
    public void update() {
        if (!isEmpty()) {
            String person = dequeue();
            System.out.println("Принят заказ от " + person + ". Заказ #" + ++orderCounter);
        } else {
            System.out.println("Очередь пуста. Заказов нет.");
        }
    }

    public static void main(String[] args) {
        Market market = new Market();
        market.addPersonToQueue("Иван");
        market.addPersonToQueue("Мария");
        market.addPersonToQueue("Алексей");

        market.update();
        market.removePersonFromQueue();
        market.update();
    }
}