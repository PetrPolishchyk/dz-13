package com.rd.employee;

public class Main {
    public static void main(String[] args) {
        System.out.println("Begin");
        Employee employeeFirst = new Employee(10, "Peter", "Polishchuk", "email@gmail.com", 35);
        int ageFirst = employeeFirst.getAge();
        String firstNameFirst = employeeFirst.getFirstName();
        String lastNameFirst = employeeFirst.getLastName();
        String emailFirst = employeeFirst.getEmail();

        System.out.println(firstNameFirst + " " + lastNameFirst + " " + emailFirst + " " + ageFirst);
    }
}
