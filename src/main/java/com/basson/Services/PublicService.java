package com.basson.Services;

import com.basson.JavaBeans.Coupon;
import com.basson.JavaBeans.Customer;
import org.springframework.http.ResponseEntity;

public interface PublicService {
    public void register(Customer customer) throws  Exception;
}
