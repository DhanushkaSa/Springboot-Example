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

import com.employee.entity.Company;
import com.employee.service.CompanyService;


@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/company")
    public ResponseEntity<?> createCompany(@RequestBody Company company) {
        Company newCompany = companyService.save(company);
        if (newCompany == null) {
            return ResponseEntity.status(404).body("Company not found");
        } else {
            return ResponseEntity.status(201).body(newCompany);
        }
    }

    @GetMapping("/company")
    public ResponseEntity<?> getAll(){
        List<Company> CompanyList=companyService.getAll();
        return ResponseEntity.status(200).body(CompanyList);
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<?>get(@PathVariable Long companyId){
        Company company=companyService.get(companyId);
        if(company==null){
            return ResponseEntity.status(404).body("Company not found !!");
        }
        else{
            return ResponseEntity.status(200).body(company);
        }
    }

    @PutMapping("/company/{companyId}")
    public ResponseEntity<?>updateCompany(@PathVariable Long companyId,@RequestBody Company company){
          Company updateCompany=companyService.update(companyId,company);
          if(updateCompany==null){
               return ResponseEntity.status(404).body("Update Fail !!");
          }
          else{
            return ResponseEntity.status(200).body(updateCompany);
          }
    }

    @DeleteMapping("/company/{companyId}")
    public void deleteCompany(@PathVariable Long companyId){
           companyService.delete(companyId);
    }
}
