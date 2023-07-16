import java.util.*;

public class DuplicateNames {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList(
            "Светлана Петрова",
            "Кристина Белова",
            "Анна Мусина",
            "Анна Крутова",
            "Иван Юрин",
            "Петр Лыков",
            "Павел Чернов",
            "Петр Чернышов",
            "Мария Федорова",
            "Марина Светлова",
            "Иван Савин",
            "Мария Рыкова",
            "Марина Лугова",
            "Анна Владимирова",
            "Иван Мечников",
            "Петр Петин",
            "Иван Ежов",
            "Иван Ежов",
            "Петр Лыков"
        );

        Map<String, Integer> nameCount = new HashMap<>();

        // Подсчет повторений имен
        for (String employee : employees) {
            nameCount.put(employee, nameCount.getOrDefault(employee, 0) + 1);
        }

        // Создание списка пар (имя, количество повторений)
        List<Map.Entry<String, Integer>> sortedNames = new ArrayList<>(nameCount.entrySet());
        sortedNames.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Вывод повторяющихся имен с количеством повторений
        for (Map.Entry<String, Integer> entry : sortedNames) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}