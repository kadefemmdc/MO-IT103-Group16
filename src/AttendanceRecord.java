import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AttendanceRecord {

    private Employee employee;
    private String date;
    private String loginTime;
    private String logoutTime;
    private double hoursWorked;

    public AttendanceRecord(
            Employee employee,
            String date,
            String loginTime,
            String logoutTime
    ) {
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

    public String getLoginTime() {
        return loginTime;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double computeHoursWorked() {

        try {
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("H:mm");

            LocalTime login =
                    LocalTime.parse(loginTime, formatter);

            LocalTime logout =
                    LocalTime.parse(logoutTime, formatter);

            // MotorPH official work start time is 8:00 AM.
            LocalTime workStart =
                    LocalTime.of(8, 0);

            // Employees who log in at 8:10 AM or earlier are still on time.
            LocalTime gracePeriod =
                    LocalTime.of(8, 10);

            // Workday ends at 5:00 PM.
            // Overtime after 5:00 PM is not included in this MS1 version.
            LocalTime workEnd =
                    LocalTime.of(17, 0);

            // Logins earlier than 8:00 AM are treated as 8:00 AM.
            if (login.isBefore(workStart)) {
                login = workStart;
            }

            // 8:10 AM or earlier is treated as 8:00 AM.
            // 8:11 AM onwards uses the actual login time, causing late deduction.
            if (!login.isAfter(gracePeriod)) {
                login = workStart;
            }

            // Logouts later than 5:00 PM are capped at 5:00 PM.
            if (logout.isAfter(workEnd)) {
                logout = workEnd;
            }

            // If logout is not later than login, no valid work hours are counted.
            if (!logout.isAfter(login)) {
                return 0.0;
            }

            long minutesWorked =
                    Duration.between(login, logout).toMinutes();

            // Deduct the standard 1-hour lunch break.
            if (minutesWorked <= 60) {
                return 0.0;
            }

            minutesWorked -= 60;

            double hours =
                    minutesWorked / 60.0;

            // Maximum counted work hours per day is 8.
            if (hours > 8.0) {
                hours = 8.0;
            }

            return hours;

        } catch (Exception e) {
            return 0.0;
        }
    }
}