public class ComplexCalculator {
    private ComplexOperationStrategy operationStrategy;

    public ComplexCalculator(ComplexOperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public ComplexNumber performOperation(ComplexNumber num1, ComplexNumber num2) {
        return operationStrategy.execute(num1, num2);
    }
}
