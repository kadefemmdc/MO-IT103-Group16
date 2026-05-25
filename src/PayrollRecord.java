public class PayrollRecord {

    private Employee employee;
    private String cutoffPeriod;

    private double grossPay;
    private double netPay;

    private double sss;
    private double philHealth;
    private double pagibig;
    private double withholdingTax;

    public PayrollRecord(
            Employee employee,
            String cutoffPeriod,
            double hoursWorked,
            double monthlyGross
    ) {

        this.employee = employee;
        this.cutoffPeriod = cutoffPeriod;

        grossPay = computeGrossPay(hoursWorked);

        computeNetPay(monthlyGross);
    }

    public double computeGrossPay(double hoursWorked) {

        return hoursWorked *
                employee.getHourlyRate();
    }

    public double computeNetPay(double monthlyGross) {

        DeductionCalculator calculator =
                new DeductionCalculator();

        sss =
                calculator.computeSSS(monthlyGross);

        philHealth =
                calculator.computePhilHealth(monthlyGross);

        pagibig =
                calculator.computePagibig(monthlyGross);

        double taxableIncome =
                monthlyGross -
                (sss + philHealth + pagibig);

        if (taxableIncome < 0) {
            taxableIncome = 0;
        }

        withholdingTax =
                calculator.computeTax(taxableIncome);

        double totalDeductions =
                sss
                + philHealth
                + pagibig
                + withholdingTax;

        netPay =
                grossPay - totalDeductions;

        return netPay;
    }

    public String displayPayslip() {

        return "Employee: "
                + employee.getFullName()

                + "\nCutoff Period: "
                + cutoffPeriod

                + "\nGross Pay: "
                + grossPay

                + "\nSSS: "
                + sss

                + "\nPhilHealth: "
                + philHealth

                + "\nPag-IBIG: "
                + pagibig

                + "\nWithholding Tax: "
                + withholdingTax

                + "\nNet Pay: "
                + netPay;
    }

    // Getters

    public Employee getEmployee() {
        return employee;
    }

    public String getCutoffPeriod() {
        return cutoffPeriod;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public double getSSS() {
        return sss;
    }

    public double getPhilHealth() {
        return philHealth;
    }

    public double getPagibig() {
        return pagibig;
    }

    public double getWithholdingTax() {
        return withholdingTax;
    }

    public double getNetPay() {
        return netPay;
    }
}