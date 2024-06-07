package com.juaracoding.model;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private LocalDate dob;

    public Employee(int id, String name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", DOB=" + dob + "]";
    }
}

