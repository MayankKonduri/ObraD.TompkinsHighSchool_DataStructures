import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.*;


public class Main extends JFrame implements ActionListener {
    private JTextField topDisplay;
    private JTextField operatorDisplay;
    private JTextField inputDisplay;
    private StringBuilder currentInput;
    private BigDecimal result;
    private String currentOperator;

    public Main() {
        setLayout(null);

        topDisplay = createDisplay(50, 45, 280, 20, false);
        operatorDisplay = createDisplay(50, 70, 280, 20, false);
        inputDisplay = createDisplay(10, 95, 320, 30, true);

        createButton(".", 75, 130, 60, 40);
        createButton("+/-", 140, 130, 60, 40);
        createButton("C", 205, 130, 60, 40);
        createButton("+", 270, 130, 60, 40);

        createButton("1", 10, 175, 60, 40);
        createButton("2", 75, 175, 60, 40);
        createButton("3", 140, 175, 60, 40);
        createButton("-", 270, 175, 60, 40);

        createButton("4", 10, 220, 60, 40);
        createButton("5", 75, 220, 60, 40);
        createButton("6", 140, 220, 60, 40);
        createButton("*", 270, 220, 60, 40);

        createButton("7", 10, 265, 60, 40);
        createButton("8", 75, 265, 60, 40);
        createButton("9", 140, 265, 60, 40);
        createButton("=", 10, 310, 320, 40);

        createButton("0", 205, 175, 60, 130);
        createButton("/", 270, 265, 60, 40);

        currentInput = new StringBuilder();
        result = BigDecimal.ZERO;
        currentOperator = "";

        setSize(350, 400);
        setTitle("Styled Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setResizable(true);
    }

    private JTextField createDisplay(int x, int y, int width, int height, boolean bold) {
        JTextField display = new JTextField();
        display.setBounds(x, y, width, height);
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);

        if (bold) {
            display.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        } else {
            display.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        }

        add(display);
        return display;
    }

    private JButton createButton(String label, int x, int y, int width, int height) {
        JButton button = new JButton(label);
        button.setBounds(x, y, width, height);
        button.addActionListener(this);
        add(button);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.matches("[0-9.]")) {
            processNumber(actionCommand);
        } else if (actionCommand.matches("[/+\\-*]")) {
            processOperator(actionCommand);
        } else if (actionCommand.equals("=")) {
            calculateResult("=");
        } else if (actionCommand.equals("+/-")) {
            changeSign();
        } else if (actionCommand.equals("C")) {
            clear();
        }
    }

    private void processNumber(String number) {
        if (number.equals(".")) {
            if (currentInput.length() == 0) {
                currentInput.append("0");
            }

            if (!currentInput.toString().contains(".")) {
                currentInput.append(number);
                inputDisplay.setText(currentInput.toString());
            }
        } else {
            currentInput.append(number);
            inputDisplay.setText(currentInput.toString());
        }
    }

    private void processOperator(String operator) {
        if (currentInput.length() > 0) {
            if (!currentOperator.isEmpty() && !operator.equals("=")) {
                calculateResult(operator);
            } else {
                if (!topDisplay.getText().isEmpty() && !operator.equals("=")) {
                    result = new BigDecimal(topDisplay.getText());
                    topDisplay.setText(result.stripTrailingZeros().toPlainString());
                } else {
                    result = new BigDecimal(currentInput.toString());
                    topDisplay.setText(result.stripTrailingZeros().toPlainString());
                }
            }
            currentInput.setLength(0);

            if (!operator.equals("=")) {
                currentOperator = operator;
                operatorDisplay.setText(currentOperator);
                inputDisplay.setText("");
            } else {
                currentOperator = "";
                operatorDisplay.setText("");
                inputDisplay.setText(result.stripTrailingZeros().toPlainString());
                topDisplay.setText("");
            }
        } else if (!currentOperator.isEmpty()) {
            currentOperator = operator;
            operatorDisplay.setText(currentOperator);
        }
    }


    private void calculateResult(String operator) {
        if (currentInput.length() > 0 && !currentOperator.isEmpty()) {
            BigDecimal operand = new BigDecimal(currentInput.toString());
            switch (currentOperator) {
                case "+":
                    result = result.add(operand);
                    break;
                case "-":
                    result = result.subtract(operand);
                    break;
                case "*":
                    result = result.multiply(operand);
                    break;
                case "/":
                    if (!operand.equals(BigDecimal.ZERO)) {
                        result = result.divide(operand, 10, BigDecimal.ROUND_HALF_UP);
                    } else {
                        clear();
                        inputDisplay.setText("Error");
                        return;
                    }
                    break;
            }
            inputDisplay.setText(result.stripTrailingZeros().toPlainString());
            currentInput.setLength(0);
            operatorDisplay.setText("");
            if(operator!="="){
                topDisplay.setText(result.stripTrailingZeros().toPlainString());
            }
            else{
                topDisplay.setText("");
            }

        }
    }

    private void changeSign() {
        if (currentInput.length() > 0) {
            boolean hasMinus = currentInput.charAt(0) == '-';

            boolean hasDecimal = currentInput.toString().contains(".");


            if (hasDecimal && currentInput.indexOf(".") == currentInput.length() - 1) {
                currentInput.append("0");
            }

            if (hasMinus) {
                currentInput.deleteCharAt(0);
            } else {
                currentInput.insert(0, "-");
            }

            inputDisplay.setText(currentInput.toString());
        }
    }





    private void clear() {
        currentInput.setLength(0);
        result = BigDecimal.ZERO;
        currentOperator = "";
        topDisplay.setText("");
        operatorDisplay.setText("");
        inputDisplay.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
