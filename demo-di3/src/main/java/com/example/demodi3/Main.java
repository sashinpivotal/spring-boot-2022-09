package com.example.demodi3;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee("sang", new USAddress("12345", "boston"));
        String employeeInfo = employee.getEmployeeInfo();
        System.out.println("employee info = " + employeeInfo);
    }
}
