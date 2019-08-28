package com.tw.apistackbase.entity;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int employeeId;
    private String name;
    private  int age;
    private String gender;

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Employee(int employeeId, String name, int age, String gender) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Employee() {
    }

    public static List<Employee> employeeData(){
        List<Employee> userList = new ArrayList<>();
        Employee userOne = new Employee(1, "xiaoming",10,"female");
        Employee userTwo = new Employee(2, "xiaohong",5,"male");
        Employee userThree = new Employee(3, "xiaohua",60,"female");
        userList.add(userOne);
        userList.add(userTwo);
        userList.add(userThree);
        return userList;
    }
}
