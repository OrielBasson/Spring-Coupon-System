package com.basson.Services;

import com.basson.JavaBeans.Coupon;
import com.basson.JavaBeans.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

    public Customer getCustomer() throws Exception;

    public void purchaseCoupon(long couponId) throws  Exception;

    public List<Coupon> getAllPurchaseCoupons() throws Exception;

    public List<Coupon> getAllAvailableCoupons() throws Exception;

}
