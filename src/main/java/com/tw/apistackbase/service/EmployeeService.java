package com.tw.apistackbase.service;

import com.tw.apistackbase.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    static List<Employee> employeesList = Employee.employeeData();

    public List<Employee> getAllEmployees(String nameLike){
        List<Employee> nameLikeEmployeeList=new ArrayList<>();
        if(nameLike != null){
            for (Employee employee1:employeesList){
                if(employee1.getName().contains(nameLike)){
                    nameLikeEmployeeList.add(employee1);
                }
            }
            return nameLikeEmployeeList;

        }


        return employeesList;
    }

    public Employee getEmployeeByID(int employeeID){
        for (Employee employee:employeesList) {
            if (employee.getEmployeeId() == employeeID) {
                return employee;
            }
        }
        return null;
    }


    public void addEmployee(Employee employee) {
        employeesList.add(employee);
    }

    public void updateEmployee(Employee employee) {
        int employeeId=employee.getEmployeeId();
        Employee employee1=getEmployeeByID(employeeId);
        employee1=employee;
    }

    public void deleteEmployee(int employeeID) {
        Employee employee=getEmployeeByID(employeeID);
        employeesList.remove(employee);
    }
}
