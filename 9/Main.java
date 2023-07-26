import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

// Функциональный интерфейс для обработки заказов
interface OrderProcessor {
    boolean processOrder(String order);
}

// Интерфейс QueueBehaviour
interface QueueBehaviour {
    void enqueue(String person);

    String dequeue();

    boolean isEmpty();

    int getQueueLength();
}

// Интерфейс MarketBehaviour
interface MarketBehaviour {
    void addPersonToQueue(String personName);

    void removePersonFromQueue(String personName);

    void acceptOrder(String order);

    void deliverOrder();
}

// Класс Market, реализующий интерфейсы QueueBehaviour и MarketBehaviour
class Market implements QueueBehaviour, MarketBehaviour {
    private List<String> queue;   // Список, представляющий очередь людей в магазине
    private List<String> orders; // Список заказов магазина
    private OrderProcessor orderProcessor; // Поле для обработки заказов
    private Comparator<String> orderComparator; // Наш компаратор для сортировки заказов

    public Market() {
        this.queue = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.orderProcessor = order -> {
            // По умолчанию обрабатываем заказы просто добавлением в список
            return orders.add(order);
        };
        // Инициализируем компаратор для сортировки заказов по длине строки
        this.orderComparator = (order1, order2) -> order1.length() - order2.length();
    }

    // Методы из интерфейса QueueBehaviour
    @Override
    public void enqueue(String person) {
        queue.add(person);
    }

    @Override
    public String dequeue() {
        if (!isEmpty()) {
            return queue.remove(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int getQueueLength() {
        return queue.size();
    }

    // Методы из интерфейса MarketBehaviour
    @Override
    public void addPersonToQueue(String personName) {
        enqueue(personName);
    }

    @Override
    public void removePersonFromQueue(String personName) {
        queue.remove(personName);
    }

    @Override
    public void acceptOrder(String order) {
        orders.add(order);
    }

    @Override
    public void deliverOrder() {
        if (!orders.isEmpty()) {
            String order = orders.remove(0);
            System.out.println("Delivering order: " + order);
        } else {
            System.out.println("No orders to deliver.");
        }
    }

    // Метод для установки произвольной реализации обработки заказов
    public void setOrderProcessor(OrderProcessor processor) {
        this.orderProcessor = processor;
    }

    // Метод update для обновления состояния магазина с использованием OrderProcessor
    public void update(String order) {
        if (orderProcessor.processOrder(order)) {
            System.out.println("Order processed successfully: " + order);
        } else {
            System.out.println("Order processing failed: " + order);
        }
        sortOrders(); // Сортируем заказы после обновления
    }

    // Метод для сортировки списка заказов
    private void sortOrders() {
        orders.sort(orderComparator);
    }

}

public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        market.addPersonToQueue("Alice");
        market.addPersonToQueue("Bob");
        market.addPersonToQueue("Charlie");

        market.setOrderProcessor(order -> {
            // Мы определили свою логику обработки заказов с помощью лямбда-выражения
            // Здесь мы просто считаем, что все заказы с буквой "A" обработаны успешно,
            // а все остальные - неуспешно
            return order.contains("A");
        });

        market.update("Apples"); // Order processed successfully: Apples
        market.update("Bananas"); // Order processing failed: Bananas

        market.removePersonFromQueue("Bob");

        market.update("Carrots"); // Order processing failed: Carrots

    }
}
