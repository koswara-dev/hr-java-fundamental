package com.juaracoding;

import com.juaracoding.controller.EmployeeController;
import com.juaracoding.model.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeController manager = new EmployeeController();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee by Name");
            System.out.println("6. Show Birthday Messages");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee date of birth (yyyy-MM-dd): ");
                    String dobStr = scanner.nextLine();
                    LocalDate dob = LocalDate.parse(dobStr, formatter);
                    manager.addEmployee(name, dob);
                    System.out.println("Employee added successfully.");
                    break;
                case 2:
                    System.out.println("All Employees:");
                    for (Employee emp : manager.getAllEmployees()) {
                        System.out.println(emp);
                    }
                    break;
                case 3:
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new employee name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new employee date of birth (yyyy-MM-dd): ");
                    String newDobStr = scanner.nextLine();
                    LocalDate newDob = LocalDate.parse(newDobStr, formatter);
                    if (manager.updateEmployee(updateId, newName, newDob)) {
                        System.out.println("Employee updated successfully.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    if (manager.deleteEmployee(deleteId)) {
                        System.out.println("Employee deleted successfully.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter employee name to search: ");
                    String searchName = scanner.nextLine();
                    ArrayList<Employee> searchResults = manager.searchEmployeeByName(searchName);
                    if (searchResults.isEmpty()) {
                        System.out.println("No employees found with that name.");
                    } else {
                        System.out.println("Search Results:");
                        for (Employee emp : searchResults) {
                            System.out.println(emp);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Birthday Messages:");
                    ArrayList<String> messages = manager.getBirthdayMessages();
                    if (messages.isEmpty()) {
                        System.out.println("No birthdays today.");
                    } else {
                        for (String message : messages) {
                            System.out.println(message);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
