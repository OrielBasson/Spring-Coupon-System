package com.basson.Repositories;

import com.basson.JavaBeans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository <Company , Long> {

    public Company findByCompanyId (long companyId);

}
