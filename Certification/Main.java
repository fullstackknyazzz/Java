public class Main {
    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber(3, 2);
        ComplexNumber num2 = new ComplexNumber(1, 4);

        ComplexOperationStrategy addStrategy = new AddOperation();
        ComplexCalculator calculator = new ComplexCalculator(addStrategy);
        ComplexNumber result = calculator.performOperation(num1, num2);

        System.out.println("Результат: " + result.getRealPart() + " + " + result.getImaginaryPart() + "i");
    }
}
