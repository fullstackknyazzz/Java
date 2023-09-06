import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInfoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        try {
            String[] data = input.split("\\s+");
            
            if (data.length != 6) {
                throw new Exception("Неверное количество данных. Введите Фамилию, Имя, Отчество, Дату рождения, Номер телефона и Пол.");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            String gender = data[5];

            if (!isValidDate(birthDate) || !isValidPhoneNumber(phoneNumber) || !isValidGender(gender)) {
                throw new Exception("Неверный формат данных.");
            }

            String fileName = lastName + ".txt";
            String userData = lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(userData);
                writer.newLine();
            } catch (IOException e) {
                throw new Exception("Ошибка записи данных в файл.");
            }

            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static boolean isValidDate(String date) {
        String datePattern = "\\d{2}\\.\\d{2}\\.\\d{4}";
        Pattern pattern = Pattern.compile(datePattern);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d+");
    }

    private static boolean isValidGender(String gender) {
        return gender.matches("[mf]");
    }
}
