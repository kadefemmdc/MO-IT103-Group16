public class Employee {
    private int employeeNumber;
    private String firstName;
    private String lastName;
    private String birthday;
    private String position;
    private double hourlyRate;

    public Employee(int employeeNumber, String firstName, String lastName,
                    String birthday, String position, double hourlyRate) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.position = position;
        this.hourlyRate = hourlyRate;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPosition() {
        return position;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}