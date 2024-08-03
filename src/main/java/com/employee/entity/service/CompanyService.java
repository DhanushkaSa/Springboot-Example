package com.employee.entity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.entity.Company;

@Service
public interface CompanyService {

    public Company save(Company company);

    public List<Company> getAll();

    public Company get(Long companyId);

    public Company update(Long companyId, Company company);

    public void delete(Long companyId);
}
