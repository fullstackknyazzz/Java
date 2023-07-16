import java.util.Deque;
import java.util.LinkedList;

public class Zadanie2 {
    public static Deque<Integer> add(Deque<Integer> num1, Deque<Integer> num2) {
        Deque<Integer> result = new LinkedList<>();

        // Инициализация переменных для сложения
        int carry = 0;
        int sum;

        // Проходим по числам и складываем соответствующие цифры
        while (!num1.isEmpty() || !num2.isEmpty()) {
            int digit1 = num1.isEmpty() ? 0 : num1.removeFirst();
            int digit2 = num2.isEmpty() ? 0 : num2.removeFirst();

            sum = digit1 + digit2 + carry;
            result.addLast(sum % 10);
            carry = sum / 10;
        }

        // Если остался остаток, добавляем его
        if (carry > 0) {
            result.addLast(carry);
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
        num2.addLast(-1);
        num2.addLast(0);
        num2.addLast(2);

        Deque<Integer> sum = add(num1, num2);

        System.out.println("Сумма чисел:");
        for (int digit : sum) {
            System.out.print(digit + " ");
        }
    }
}