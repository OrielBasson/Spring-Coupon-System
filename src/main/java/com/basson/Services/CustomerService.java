package com.basson.Services;

import com.basson.JavaBeans.Coupon;
import com.basson.JavaBeans.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

    public Customer getCustomer(long customerId) throws Exception;

    public void purchaseCoupon(Coupon coupon) throws  Exception;

    public List<Coupon> getAllPurchaseCoupons(Customer customer) throws Exception;

    public List<Coupon> getAllAvailableCoupons() throws Exception;

}
