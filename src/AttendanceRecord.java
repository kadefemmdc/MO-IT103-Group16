import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AttendanceRecord {
    private Employee employee;
    private String date;
    private String loginTime;
    private String logoutTime;
    private double hoursWorked;

    public AttendanceRecord(Employee employee, String date, String loginTime, String logoutTime) {
        this.employee = employee;
        this.date = date;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.hoursWorked = computeHoursWorked();
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getDate() {
        return date;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double computeHoursWorked() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");

            LocalTime login = LocalTime.parse(loginTime, formatter);
            LocalTime logout = LocalTime.parse(logoutTime, formatter);

            LocalTime start = LocalTime.of(8, 0);
            LocalTime grace = LocalTime.of(8, 10);
            LocalTime end = LocalTime.of(17, 0);

            if (login.isBefore(start)) {
                login = start;
            }

            if (logout.isAfter(end)) {
                logout = end;
            }

            if (!login.isAfter(grace)) {
                login = start;
            }

            if (!logout.isAfter(login)) {
                return 0.0;
            }

            long minutesWorked = Duration.between(login, logout).toMinutes();

            if (minutesWorked <= 60) {
                return 0.0;
            }

            minutesWorked -= 60;

            double hours = minutesWorked / 60.0;

            if (hours > 8.0) {
                hours = 8.0;
            }

            return hours;

        } catch (Exception e) {
            return 0.0;
        }
    }
}