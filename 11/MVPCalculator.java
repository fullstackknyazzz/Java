import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Модель (Model)
class CalculatorModel {
    private double currentValue;

    public void setCurrentValue(double value) {
        currentValue = value;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public double performOperation(double value1, double value2, String operator) {
        switch (operator) {
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "*":
                return value1 * value2;
            case "/":
                if (value2 != 0) {
                    return value1 / value2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}

// Представление (View)
class CalculatorView {
    private JTextField inputField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton;
    private JTextArea resultArea;

    public CalculatorView() {
        JFrame frame = new JFrame("MVP Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        resultArea = new JTextArea(10, 20);
        resultArea.setEditable(false);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3));
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(equalsButton);
        buttonPanel.add(clearButton);

        frame.getContentPane().add(inputField, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(resultArea), BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    public double getInputValue() {
        try {
            return Double.parseDouble(inputField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

     public String getResultText() {
        return resultArea.getText();
    }

    public void setInputValue(String value) {
        inputField.setText(value);
    }

    public void setResultText(String resultText) {
        resultArea.setText(resultText);
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addSubtractButtonListener(ActionListener listener) {
        subtractButton.addActionListener(listener);
    }

    public void addMultiplyButtonListener(ActionListener listener) {
        multiplyButton.addActionListener(listener);
    }

    public void addDivideButtonListener(ActionListener listener) {
        divideButton.addActionListener(listener);
    }

    public void addEqualsButtonListener(ActionListener listener) {
        equalsButton.addActionListener(listener);
    }

    public void addClearButtonListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }
}

// Презентер (Presenter)
class CalculatorPresenter {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorPresenter(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        this.view.addAddButtonListener(new OperationListener("+"));
        this.view.addSubtractButtonListener(new OperationListener("-"));
        this.view.addMultiplyButtonListener(new OperationListener("*"));
        this.view.addDivideButtonListener(new OperationListener("/"));
        this.view.addEqualsButtonListener(new EqualsListener());
        this.view.addClearButtonListener(new ClearListener());
    }

    private class OperationListener implements ActionListener {
        private String operator;

        public OperationListener(String operator) {
            this.operator = operator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            double inputValue = view.getInputValue();
            model.setCurrentValue(inputValue);
            view.setInputValue("");
            view.setResultText(inputValue + " " + operator + " ");
        }
    }

    private class EqualsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double inputValue = view.getInputValue();
            double currentValue = model.getCurrentValue();
            String operator = view.getResultText().split(" ")[1];
            double result = model.performOperation(currentValue, inputValue, operator);
            view.setResultText(currentValue + " " + operator + " " + inputValue + " = " + result + "\n");
        }
    }

    private class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setInputValue("");
            view.setResultText("");
        }
    }
}

// Основной класс (MVPCalculator)
public class MVPCalculator {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorPresenter presenter = new CalculatorPresenter(model, view);
    }
}
