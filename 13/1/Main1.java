import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        double userInput = readDoubleFromUser();
        System.out.println("Вы ввели: " + userInput);
    }

    public static double readDoubleFromUser() {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Пожалуйста, введите дробное число: ");

            if (scanner.hasNextDouble()) {
                result = scanner.nextDouble();
                validInput = true;
            } else {
                System.out.println("Ошибка! Введите корректное дробное число.");
                scanner.nextLine(); // Очистить буфер ввода
            }
        }

        return result;
    }
}
