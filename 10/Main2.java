public class Main2 {

    // Обобщенный метод printArray
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Создание массивов типов Integer и String
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"apple", "banana", "cherry"};

        // Вызов обобщенного метода printArray для каждого массива
        printArray(intArray); // Выведет: 1 2 3 4 5
        printArray(stringArray); // Выведет: apple banana cherry
    }
}
