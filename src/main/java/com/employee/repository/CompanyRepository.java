package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{
    
}
