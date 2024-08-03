package com.employee.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Company;
import com.employee.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company get(Long companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }

    @Override
    public Company update(Long companyId, Company company) {
        Company updateCompany = companyRepository.findById(companyId).orElse(null);
        if (updateCompany == null) {
            return null;
        } else {
            updateCompany.setName(company.getName());
            updateCompany.setLocation(company.getLocation());
            updateCompany.setEmployee(company.getEmployee());
            Company updateData = companyRepository.save(updateCompany);
            return updateData;

        }
    }

    @Override
    public void delete(Long companyId) {
        companyRepository.deleteById(companyId);
    }

}
