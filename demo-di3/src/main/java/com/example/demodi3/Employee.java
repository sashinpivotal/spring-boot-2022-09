package com.example.demodi3;

public class Employee {

    private String name = "sang";
    private IAddress address;

    // Example where we are NOT using DI
    // Problems of this coding style
    // - tight coupling of the Employee class with
    //   particular dependency implementation
    // - you cannot mock your dependency object
//    public Employee() {
//        address = new USAddress();
//    }

    public Employee(String name, IAddress address) {
        this.name = name;
        this.address = address;
    }

    public String getEmployeeInfo() {
        String employeeInfo = name + " lives at " + address.getAddressInfo();
        return employeeInfo.toUpperCase();
    }
}
