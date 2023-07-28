public class Main1 {

    // Обобщенный метод printElement
    public static <T> void printElement(T element) {
        System.out.println(element);
    }

    public static void main(String[] args) {
        // Вызов обобщенного метода с различными типами данных
        Integer integerNumber = 42;
        String text = "Hello, world!";
        Double floatingNumber = 3.14;

        printElement(integerNumber); // Выведет: 42
        printElement(text); // Выведет: Hello, world!
        printElement(floatingNumber); // Выведет: 3.14
    }
}
