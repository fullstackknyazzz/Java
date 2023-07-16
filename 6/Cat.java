import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cat {
    private String name;
    private int age;
    private String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        return age == cat.age &&
                Objects.equals(name, cat.name) &&
                Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, color);
    }

    public static void main(String[] args) {
        Set<Cat> cats = new HashSet<>();
        cats.add(new Cat("Tom", 3, "Gray"));
        cats.add(new Cat("Lucy", 2, "White"));
        cats.add(new Cat("Tom", 3, "Gray"));

        System.out.println("Cats in the set:");
        for (Cat cat : cats) {
            System.out.println("Name: " + cat.getName() +
                    ", Age: " + cat.getAge() +
                    ", Color: " + cat.getColor());
        }
    }
}