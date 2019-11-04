package com.basson.Services;

import com.basson.JavaBeans.Customer;
import com.basson.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PublicServiceImpl implements PublicService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public void register(Customer customer) throws Exception {
        customerRepository.save(customer);
    }
}
