import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EmployeeDashboardFrame extends JFrame {

    private JTextField employeeNumberField;

    private JLabel nameValueLabel;
    private JLabel birthdayValueLabel;
    private JLabel positionValueLabel;
    private JLabel hourlyRateValueLabel;

    private JLabel hoursWorkedValueLabel;
    private JLabel cutoffPeriodValueLabel;
    private JLabel grossPayValueLabel;
    private JLabel sssValueLabel;
    private JLabel philHealthValueLabel;
    private JLabel pagibigValueLabel;
    private JLabel taxValueLabel;
    private JLabel netPayValueLabel;

    private JButton searchButton;
    private JButton computePayrollButton;
    private JButton resetButton;

    private CSVDataManager dataManager;
    private ArrayList<Employee> employees;
    private ArrayList<AttendanceRecord> attendanceRecords;

    private Employee selectedEmployee;

    public EmployeeDashboardFrame() {

        dataManager = new CSVDataManager();
        employees = dataManager.loadEmployees();
        attendanceRecords = dataManager.loadAttendanceRecords();

        setTitle("MotorPH Employee App");
        setSize(650, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(7, 10, 7, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        JLabel title = new JLabel("MotorPH Employee Payroll", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(title, gbc);

        gbc.gridy = 1;

        JLabel instruction = new JLabel(
                "Search an employee, review details, then compute payroll from attendance records.",
                SwingConstants.CENTER
        );
        instruction.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(instruction, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Employee Number:"), gbc);

        gbc.gridx = 1;
        employeeNumberField = new JTextField(15);
        panel.add(employeeNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        searchButton = new JButton("Search Employee");
        panel.add(searchButton, gbc);

        gbc.gridx = 1;
        resetButton = new JButton("Reset Form");
        panel.add(resetButton, gbc);

        addSectionHeader(panel, gbc, "Employee Details", 4);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Employee Name:"), gbc);

        gbc.gridx = 1;
        nameValueLabel = new JLabel("-");
        panel.add(nameValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Birthday:"), gbc);

        gbc.gridx = 1;
        birthdayValueLabel = new JLabel("-");
        panel.add(birthdayValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Position:"), gbc);

        gbc.gridx = 1;
        positionValueLabel = new JLabel("-");
        panel.add(positionValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Hourly Rate:"), gbc);

        gbc.gridx = 1;
        hourlyRateValueLabel = new JLabel("-");
        panel.add(hourlyRateValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;

        computePayrollButton = new JButton("Compute Payroll");
        computePayrollButton.setEnabled(false);
        panel.add(computePayrollButton, gbc);

        gbc.gridwidth = 1;

        addSectionHeader(panel, gbc, "Attendance Summary", 10);

        gbc.gridx = 0;
        gbc.gridy = 11;
        panel.add(new JLabel("Cutoff Period:"), gbc);

        gbc.gridx = 1;
        cutoffPeriodValueLabel = new JLabel("-");
        panel.add(cutoffPeriodValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        panel.add(new JLabel("Hours Worked (Sample Cutoff):"), gbc);

        gbc.gridx = 1;
        hoursWorkedValueLabel = new JLabel("-");
        panel.add(hoursWorkedValueLabel, gbc);

        addSectionHeader(panel, gbc, "Salary Computation", 13);

        gbc.gridx = 0;
        gbc.gridy = 14;
        panel.add(new JLabel("Gross Pay:"), gbc);

        gbc.gridx = 1;
        grossPayValueLabel = new JLabel("-");
        panel.add(grossPayValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 15;
        panel.add(new JLabel("SSS:"), gbc);

        gbc.gridx = 1;
        sssValueLabel = new JLabel("-");
        panel.add(sssValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 16;
        panel.add(new JLabel("PhilHealth:"), gbc);

        gbc.gridx = 1;
        philHealthValueLabel = new JLabel("-");
        panel.add(philHealthValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 17;
        panel.add(new JLabel("Pag-IBIG:"), gbc);

        gbc.gridx = 1;
        pagibigValueLabel = new JLabel("-");
        panel.add(pagibigValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 18;
        panel.add(new JLabel("Withholding Tax:"), gbc);

        gbc.gridx = 1;
        taxValueLabel = new JLabel("-");
        panel.add(taxValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 19;
        panel.add(new JLabel("Net Pay:"), gbc);

        gbc.gridx = 1;
        netPayValueLabel = new JLabel("-");
        panel.add(netPayValueLabel, gbc);

        add(panel);

        searchButton.addActionListener(e -> searchEmployee());
        computePayrollButton.addActionListener(e -> computePayroll());
        resetButton.addActionListener(e -> resetForm());

        setVisible(true);
    }

    private void addSectionHeader(
        JPanel panel,
        GridBagConstraints gbc,
        String text,
        int row
) {

    gbc.gridx = 0;
    gbc.gridy = row;
    gbc.gridwidth = 2;

    JPanel headerPanel =
            new JPanel(
                    new FlowLayout(
                            FlowLayout.CENTER
                    )
            );

    headerPanel.setOpaque(false);

    JLabel sectionLabel =
            new JLabel(text);

    sectionLabel.setFont(
            new Font(
                    "Arial",
                    Font.BOLD,
                    16
            )
    );

    headerPanel.add(sectionLabel);

    panel.add(headerPanel, gbc);

    gbc.gridwidth = 1;
}

private void searchEmployee() {

    try {

        String employeeNumberText =
                employeeNumberField.getText().trim();

        // Empty field validation
        if (employeeNumberText.isEmpty()) {

            throw new IllegalArgumentException(
                    "Please enter an employee number."
            );
        }

        // Allow only numbers and optional minus sign
        if (!employeeNumberText.matches("-?[0-9]+")) {

            throw new IllegalArgumentException(
                    "Employee Number must be numeric."
            );
        }

        int employeeNumber =
                Integer.parseInt(employeeNumberText);

        // Negative number validation
        if (employeeNumber <= 0) {

            throw new IllegalArgumentException(
                    "Employee Number must be greater than zero."
            );
        }

        selectedEmployee =
                dataManager.findEmployeeByNumber(
                        employees,
                        employeeNumber
                );

        if (selectedEmployee == null) {

            throw new IllegalArgumentException(
                    "Employee not found."
            );
        }

        nameValueLabel.setText(
                selectedEmployee.getFullName()
        );

        birthdayValueLabel.setText(
                selectedEmployee.getBirthday()
        );

        positionValueLabel.setText(
                selectedEmployee.getPosition()
        );

        hourlyRateValueLabel.setText(
                formatMoney(
                        selectedEmployee.getHourlyRate()
                )
        );

        clearPayrollLabels();

        computePayrollButton.setEnabled(true);

        JOptionPane.showMessageDialog(
                this,
                "Employee record loaded successfully.",
                "Search Successful",
                JOptionPane.INFORMATION_MESSAGE
        );

    }

    catch (IllegalArgumentException ex) {

        showErrorMessage(
                ex.getMessage()
        );
    }
}

    private void computePayroll() {

        if (selectedEmployee == null) {
            showErrorMessage("Please search for an employee first.");
            return;
        }

        double totalHours = 0;
        int count = 0;

        for (AttendanceRecord record : attendanceRecords) {
            if (record.getEmployee().getEmployeeNumber()
                    == selectedEmployee.getEmployeeNumber()) {

                totalHours += record.getHoursWorked();
                count++;

                if (count == 10) {
                    break;
                }
            }
        }

        if (totalHours <= 0) {
            showErrorMessage(
                    "No attendance records found for this employee."
            );
            return;
        }

        String cutoffPeriod =
                "Sample Cutoff - First 10 Attendance Records";

        double monthlyGross =
                totalHours * selectedEmployee.getHourlyRate();

        PayrollRecord payrollRecord = new PayrollRecord(
                selectedEmployee,
                cutoffPeriod,
                totalHours,
                monthlyGross
        );

        cutoffPeriodValueLabel.setText(cutoffPeriod);
        hoursWorkedValueLabel.setText(String.format("%.2f", totalHours));
        grossPayValueLabel.setText(formatMoney(payrollRecord.getGrossPay()));
        sssValueLabel.setText(formatMoney(payrollRecord.getSSS()));
        philHealthValueLabel.setText(formatMoney(payrollRecord.getPhilHealth()));
        pagibigValueLabel.setText(formatMoney(payrollRecord.getPagibig()));
        taxValueLabel.setText(formatMoney(payrollRecord.getWithholdingTax()));
        netPayValueLabel.setText(formatMoney(payrollRecord.getNetPay()));

        JOptionPane.showMessageDialog(
                this,
                "Payroll computed successfully.",
                "Computation Complete",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private String formatMoney(double value) {
        return String.format("₱%,.2f", value);
    }

    private void resetForm() {
        employeeNumberField.setText("");
        selectedEmployee = null;

        nameValueLabel.setText("-");
        birthdayValueLabel.setText("-");
        positionValueLabel.setText("-");
        hourlyRateValueLabel.setText("-");

        clearPayrollLabels();
        computePayrollButton.setEnabled(false);
    }

    private void clearPayrollLabels() {
        cutoffPeriodValueLabel.setText("-");
        hoursWorkedValueLabel.setText("-");
        grossPayValueLabel.setText("-");
        sssValueLabel.setText("-");
        philHealthValueLabel.setText("-");
        pagibigValueLabel.setText("-");
        taxValueLabel.setText("-");
        netPayValueLabel.setText("-");
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "Validation Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}