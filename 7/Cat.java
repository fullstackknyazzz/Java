public class Cat {
    private String name;
    private int age;
    private String ownerName;

    // Конструктор класса Cat
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттеры и сеттеры для полей "имя" и "возраст"
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Методы доступа для поля "имя владельца"
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // Метод "приветствие"
    public void greet() {
        if (ownerName != null) {
            System.out.println("Мяу! Меня зовут " + name + ". Мне " + age + " года(лет). Мой владелец - " + ownerName + ".");
        } else {
            System.out.println("Мяу! Меня зовут " + name + ". Мне " + age + " года(лет).");
        }
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик", 3);
        cat1.setOwnerName("Иван");
        cat1.greet();

        Cat cat2 = new Cat("Мурзик", 5);
        cat2.setOwnerName("Мария");
        cat2.greet();
    }
}
