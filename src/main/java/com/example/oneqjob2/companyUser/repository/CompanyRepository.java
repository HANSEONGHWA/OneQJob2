package com.example.oneqjob2.companyUser.repository;

import com.example.oneqjob2.entity.CompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyUser, Long> {
}
