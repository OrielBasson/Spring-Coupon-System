package com.basson.Services;

import com.basson.JavaBeans.Coupon;
import com.basson.JavaBeans.CouponType;
import com.basson.JavaBeans.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PublicService {
    public void register(Customer customer) throws  Exception;

    public List<Coupon> getAllCoupons() throws Exception;

}
