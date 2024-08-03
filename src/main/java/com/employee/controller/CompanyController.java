package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Company;
import com.employee.entity.service.CompanyService;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Postmapping("/company")
    public ResponseEntity<?> createCompany(@RequestBody Company company) {
        Company newCompany = companyService.save(company);
        if (newCompany == null) {
            return ResponseEntity.status(404).body("Company not found");
        } else {
            return ResponseEntity.status(201).body(newCompany);
        }
    }
}
