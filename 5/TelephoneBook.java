import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneBook {
    private Map<String, List<String>> contacts;

    public TelephoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        List<String> phoneNumbers = contacts.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        contacts.put(name, phoneNumbers);
    }

    public List<String> getPhoneNumbers(String name) {
        return contacts.getOrDefault(name, new ArrayList<>());
    }

    public static void main(String[] args) {
        TelephoneBook telephoneBook = new TelephoneBook();

        telephoneBook.addContact("Саня Чиж", "89253211223");
        telephoneBook.addContact("Саня Чиж", "89994567898");
        telephoneBook.addContact("Василий Фаркин", "89991236545");

        List<String> johnDoePhoneNumbers = telephoneBook.getPhoneNumbers("Саня Чиж");
        System.out.println("Телефонный номер Сани Чижа: " + johnDoePhoneNumbers);

        List<String> janeSmithPhoneNumbers = telephoneBook.getPhoneNumbers("Василий Фаркин");
        System.out.println("Телефонный номер Василия Фаркина: " + janeSmithPhoneNumbers);
    }
}