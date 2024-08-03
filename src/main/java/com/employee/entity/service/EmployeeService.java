package com.employee.entity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.entity.Employee;

@Service
public interface EmployeeService {

    public Employee save(Employee employee);

    public Employee get(Long employeeId);

    public List<Employee> getAll();

    public Employee update(Long employeeId, Employee employee);

    public void delete(Long employeeId);
}
