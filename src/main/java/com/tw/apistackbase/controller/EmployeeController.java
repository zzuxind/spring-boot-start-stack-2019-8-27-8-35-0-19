package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

   @Autowired
   EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(value = "nameLike",required = false) String nameLike){
        List<Employee> employeeList=employeeService.getAllEmployees(nameLike);
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("{employeeID}")
    public ResponseEntity<Employee> getEmployyById(@PathVariable int employeeID){
        Employee employee=employeeService.getEmployeeByID(employeeID);
        if(employee == null){
            ResponseEntity.status(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity addEmployee(@RequestBody Employee employee, HttpRequest httpRequest){
        HttpHeaders headers = httpRequest.getHeaders();
        employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping()
    public ResponseEntity updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("{employeeID}")
    public ResponseEntity deleteEmployee(int employeeID){
        employeeService.deleteEmployee(employeeID);
        return ResponseEntity.ok().build();
    }

}
