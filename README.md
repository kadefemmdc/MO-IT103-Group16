# MO-IT103-Group16
Date Added: 5/26/2026

Milestone 1: MotorPH Employee App GUI Development and Interface Refinement

## Team Details

Katrina Anne Defe

Samantha Loraine Tadina

Geneveve Apostol

Gjoshan Agnon

Joy Mae Pedoy

---

## Program Details

The MotorPH Employee App is a Java Swing-based payroll management system developed as part of Computer Programming 2 (CP2) Milestone 1. The project converts the previous console-based payroll application into a graphical user interface while maintaining the core payroll logic from CP1.

The system allows users to search employees using their employee number and displays employee details including employee name, birthday, position, and hourly rate.

The system reads employee information and attendance records from CSV files and computes payroll information based on MotorPH business rules. Attendance computation includes a work start time of 8:00 AM, a grace period until 8:10 AM, a one-hour lunch deduction, a work end limit of 5:00 PM, and a maximum daily work limit of 8 hours. Overtime is excluded in this milestone implementation.

The application supports payroll cutoff selection from June to December and computes total hours worked for the selected payroll period. Gross pay is calculated using the employee hourly rate, and government deductions including SSS, PhilHealth, Pag-IBIG, and withholding tax are applied based on the combined monthly gross salary during the second cutoff period.

The system uses validation and exception handling to prevent invalid user inputs and displays user-friendly messages to improve usability and interface interaction.

---

