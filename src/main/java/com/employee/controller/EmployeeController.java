package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.Company;
import com.employee.entity.Employee;
import com.employee.service.CompanyService;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.status(200).body(employeeService.getAll());
    }

    @PostMapping("/employee")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employee) {
        if (employee == null) {
            return ResponseEntity.status(404).body("Employee error!!!");
        } else {
            Employee newEmployee = new Employee();
            newEmployee.setName(employee.getName());
            newEmployee.setAge(employee.getAge());
            Company company = companyService.get(employee.getCompanyid());
            newEmployee.setCompanyId(company);
            return ResponseEntity.status(201).body(employeeService.save(newEmployee));
        }
    }

    @GetMapping("/employee/{employeeid}")
    public ResponseEntity<?> get(@PathVariable Long employeeid) {
        Employee employee = employeeService.get(employeeid);
        if (employee == null) {
            return ResponseEntity.status(404).body("Insert employee ");
        } else {
            return ResponseEntity.status(200).body(employee);
        }
    }

    @PutMapping("/employee/{employeeid}")
    public ResponseEntity<?> update(@PathVariable Long employeeid, @RequestBody EmployeeDTO employee) {

        Employee newEmployee = new Employee();
        newEmployee.setName(employee.getName());
        newEmployee.setAge(employee.getAge());
        Company company = companyService.get(employee.getCompanyid());
        newEmployee.setCompanyId(company);
        return ResponseEntity.status(200).body(employeeService.update(employeeid, newEmployee));

    }

    @DeleteMapping("/employee/{employeeid}")
    public void delete(@PathVariable Long employeeid) {
        employeeService.delete(employeeid);
    }
}
