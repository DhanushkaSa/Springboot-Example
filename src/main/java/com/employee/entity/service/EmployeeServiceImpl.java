package com.employee.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee get(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Long employeeId, Employee employee) {
        Employee updateEmployee = employeeRepository.findById(employeeId).orElse(null);
        if (updateEmployee == null) {
            return null;
        } else {
            updateEmployee.setName(employee.getName());
            updateEmployee.setAge(employee.getAge());
            updateEmployee.setCompanyId(employee.getCompanyId());
            Employee updateData = employeeRepository.save(updateEmployee);
            return updateData;
        }
    }

    @Override
    public void delete(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
