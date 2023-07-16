import java.util.Deque;
import java.util.LinkedList;

public class Zadanie1 {
    public static Deque<Integer> multiply(Deque<Integer> num1, Deque<Integer> num2) {
        Deque<Integer> result = new LinkedList<>();

        // Проверяем, если одно из чисел равно нулю, возвращаем 0
        if (num1.isEmpty() || num2.isEmpty())
            return result;

        // Инициализируем массив для хранения промежуточных результатов
        int[] intermediate = new int[num1.size() + num2.size()];

        // Умножение чисел
        int carry = 0;
        int idx1 = 0;
        for (int digit1 : num1) {
            int idx2 = 0;
            for (int digit2 : num2) {
                int product = digit1 * digit2 + intermediate[idx1 + idx2] + carry;
                carry = product / 10;
                intermediate[idx1 + idx2] = product % 10;
                idx2++;
            }

            if (carry > 0) {
                intermediate[idx1 + idx2] += carry;
                carry = 0;
            }
            idx1++;
        }

        // Формирование результата в виде связанного списка
        int i = intermediate.length - 1;
        while (i >= 0 && intermediate[i] == 0) {
            i--;
        }

        while (i >= 0) {
            result.addLast(intermediate[i]);
            i--;
        }

        return result;
    }

    public static void main(String[] args) {
        // Пример использования
        Deque<Integer> num1 = new LinkedList<>();
        num1.addLast(2);
        num1.addLast(3);
        num1.addLast(4);

        Deque<Integer> num2 = new LinkedList<>();
        num2.addLast(1);
        num2.addLast(0);
        num2.addLast(2);

        Deque<Integer> product = multiply(num1, num2);

        System.out.println("Произведение чисел:");
        for (int digit : product) {
            System.out.print(digit);
        }
    }
}