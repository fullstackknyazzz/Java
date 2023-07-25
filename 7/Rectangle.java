public class Rectangle {
    private double width;
    private double height;

    // Конструктор без параметров
    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }

    // Конструктор с параметрами
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Геттеры и сеттеры для свойств ширины и высоты
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Метод "вычислить площадь"
    public double calculateArea() {
        return width * height;
    }

    // Метод "вычислить периметр"
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    public static void main(String[] args) {
        // Пример использования класса Rectangle
        Rectangle rectangle1 = new Rectangle();
        System.out.println("Прямоугольник 1 - Ширина: " + rectangle1.getWidth() + ", Высота: " + rectangle1.getHeight());
        System.out.println("Площадь прямоугольника 1: " + rectangle1.calculateArea());
        System.out.println("Периметр прямоугольника 1: " + rectangle1.calculatePerimeter());

        Rectangle rectangle2 = new Rectangle(4.5, 3.2);
        System.out.println("\nПрямоугольник 2 - Ширина: " + rectangle2.getWidth() + ", Высота: " + rectangle2.getHeight());
        System.out.println("Площадь прямоугольника 2: " + rectangle2.calculateArea());
        System.out.println("Периметр прямоугольника 2: " + rectangle2.calculatePerimeter());
    }
}