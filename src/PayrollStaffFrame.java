import javax.swing.*;

public class PayrollStaffFrame extends JFrame {

    public PayrollStaffFrame() {

        setTitle("Payroll Staff Dashboard");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JLabel(
                "Welcome Payroll Staff",
                SwingConstants.CENTER
        ));

        setVisible(true);
    }
}