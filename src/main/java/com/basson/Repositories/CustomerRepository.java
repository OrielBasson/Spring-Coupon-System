package com.basson.Repositories;

import com.basson.JavaBeans.Company;
import com.basson.JavaBeans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <Customer , Long> {

    public Customer findCustomerById (long customerId);

    public Customer findCustomerByCustomerName(String customerName);

    public Customer findByCustomerNameAndAndPassword(String name, String password);

    public boolean existsById(long id);

}

