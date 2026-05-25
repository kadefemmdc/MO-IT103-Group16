import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CSVDataManager {
    private static final String EMPLOYEE_FILE = "resources/MotorPH_Employee Data - Employee Details.csv";
    private static final String ATTENDANCE_FILE = "resources/MotorPH_Employee Data - Attendance Record.csv";

    public ArrayList<Employee> loadEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(EMPLOYEE_FILE))) {
            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                int employeeNumber = Integer.parseInt(data[0].trim());
                String lastName = data[1].trim();
                String firstName = data[2].trim();
                String birthday = data[3].trim();
                String position = "Employee";
                double hourlyRate = parseNumber(data[data.length - 1]);

                employees.add(new Employee(employeeNumber, firstName, lastName, birthday, position, hourlyRate));
            }

        } catch (Exception e) {
            System.out.println("Error reading employee file: " + e.getMessage());
        }

        return employees;
    }

    public ArrayList<AttendanceRecord> loadAttendanceRecords() {
        ArrayList<AttendanceRecord> attendanceRecords = new ArrayList<>();
        ArrayList<Employee> employees = loadEmployees();

        try (BufferedReader br = new BufferedReader(new FileReader(ATTENDANCE_FILE))) {
            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                int employeeNumber = Integer.parseInt(data[0].trim());
                String date = data[3].trim();
                String loginTime = data[4].trim();
                String logoutTime = data[5].trim();

                Employee employee = findEmployeeByNumber(employees, employeeNumber);

                if (employee != null) {
                    attendanceRecords.add(new AttendanceRecord(employee, date, loginTime, logoutTime));
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading attendance file: " + e.getMessage());
        }

        return attendanceRecords;
    }

    public Employee findEmployeeByNumber(ArrayList<Employee> employees, int employeeNumber) {
        for (Employee employee : employees) {
            if (employee.getEmployeeNumber() == employeeNumber) {
                return employee;
            }
        }

        return null;
    }

    private double parseNumber(String value) {
        try {
            String cleaned = value.replaceAll("[^0-9.\\-]", "");
            return Double.parseDouble(cleaned);
        } catch (Exception e) {
            return 0.0;
        }
    }
}