package com.juaracoding.controller;

import com.juaracoding.model.Employee;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeController {
    private ArrayList<Employee> employees = new ArrayList<>();
    private int idCounter = 1;

    public void addEmployee(String name, LocalDate dob) {
        employees.add(new Employee(idCounter++, name, dob));
    }

    public ArrayList<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public boolean updateEmployee(int id, String newName, LocalDate newDob) {
        Employee emp = getEmployeeById(id);
        if (emp != null) {
            emp.setName(newName);
            emp.setDob(newDob);
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(int id) {
        Employee emp = getEmployeeById(id);
        if (emp != null) {
            employees.remove(emp);
            return true;
        }
        return false;
    }

    public ArrayList<Employee> searchEmployeeByName(String name) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(emp);
            }
        }
        return result;
    }

    public ArrayList<String> getBirthdayMessages() {
        ArrayList<String> messages = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Employee emp : employees) {
            if (emp.getDob().getDayOfMonth() == today.getDayOfMonth() && emp.getDob().getMonth() == today.getMonth()) {
                messages.add("Happy Birthday " + emp.getName() + "!");
            }
        }
        return messages;
    }
}

