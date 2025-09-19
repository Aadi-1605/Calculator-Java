import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcGUI extends JFrame implements ActionListener {
    private JTextField input1, input2, result;
    private JComboBox<String> operator;
    private JButton calculate;

    public CalcGUI() {
        setTitle("Simple Calculator");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Components
        input1 = new JTextField();
        input2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        operator = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        calculate = new JButton("Calculate");

        // Add components to frame
        add(new JLabel("First Number:"));
        add(input1);
        add(new JLabel("Operator:"));
        add(operator);
        add(new JLabel("Second Number:"));
        add(input2);
        add(new JLabel("Result:"));
        add(result);

        add(calculate);

        // Event handling
        calculate.addActionListener(this);

        setLocationRelativeTo(null); // Center window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int a = Integer.parseInt(input1.getText());
            int b = Integer.parseInt(input2.getText());
            String op = (String) operator.getSelectedItem();

            int res = 0;
            switch (op) {
                case "+": res = a + b; break;
                case "-": res = a - b; break;
                case "*": res = a * b; break;
                case "/":
                    if (b == 0) {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero");
                        return;
                    }
                    res = a / b; 
                    break;
            }
            result.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Enter integers only.");
        }
    }
//Hello 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalcGUI());
    }
}
