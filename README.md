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

The system is a payroll management application for MotorPH that uses CSV files as its primary data source for employee information and attendance records. The application provides an interactive graphical user interface that allows users to search employees, process attendance information, and compute payroll details.

The system allows users to enter an employee number and retrieve employee information including employee name, birthday, position, and hourly rate. Once an employee is selected, the user can choose a payroll cutoff period and compute payroll information based on attendance records.

The application computes work hours using predefined company attendance rules. Working hours begin at 8:00 AM with a grace period until 8:10 AM. Login times beyond the grace period are treated as late entries. The system also applies a one-hour lunch deduction, limits work hours to a maximum of eight hours per day, and excludes overtime hours beyond the official work schedule.

The payroll computation process calculates the total hours worked for the selected cutoff period and determines the corresponding gross salary using the employee's hourly rate. Government deductions including SSS, PhilHealth, Pag-IBIG, and withholding tax are automatically calculated based on payroll rules and applied during payroll processing.

The application includes input validation and exception handling to prevent invalid or missing user inputs. User-friendly feedback messages are displayed to guide users and improve overall usability and interaction with the system.

---
