package com.basson.Services;

import com.basson.JavaBeans.Coupon;
import com.basson.JavaBeans.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer getCustomer() throws Exception {
        return null;
    }

    @Override
    public void purchaseCoupon(long couponId) throws Exception {

    }

    @Override
    public List<Coupon> getAllPurchaseCoupons() throws Exception {
        return null;
    }

    @Override
    public List<Coupon> getAllAvailableCoupons() throws Exception {
        return null;
    }
}
