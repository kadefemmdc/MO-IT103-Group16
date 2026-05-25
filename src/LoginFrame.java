import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JComboBox<String> roleComboBox;
    private JButton loginButton;
    private JPanel mainPanel;

    public LoginFrame() {

        setTitle("MotorPH Employee App");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        usernameField = new JTextField(15);
        mainPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Role:"), gbc);

        gbc.gridx = 1;
        roleComboBox = new JComboBox<>(new String[]{
                "Employee",
                "Payroll Staff"
        });
        mainPanel.add(roleComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        loginButton = new JButton("Login");
        mainPanel.add(loginButton, gbc);

        add(mainPanel);

        loginButton.addActionListener(e -> openDashboard());

        setVisible(true);
    }

    public boolean validateLogin() {
        return !usernameField.getText().trim().isEmpty();
    }

    public void openDashboard() {

        if (!validateLogin()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter username.",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        String role = roleComboBox.getSelectedItem().toString();

        dispose();

        if (role.equals("Employee")) {
            new EmployeeDashboardFrame();
        } else {
            new PayrollStaffFrame();
        }
    }
}