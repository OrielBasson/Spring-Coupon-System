package com.basson.Services;

import com.basson.JavaBeans.ClientType;
import com.basson.JavaBeans.Company;
import com.basson.JavaBeans.Coupon;
import com.basson.Repositories.CompanyRepository;
import com.basson.Repositories.CouponRepository;
import com.basson.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private ClientType clientType = ClientType.COMPANY;

    @Override
    public void addCoupon(Coupon coupon) throws Exception {

    }

    @Override
    public void removeCoupon(Coupon coupon) throws Exception {

    }

    @Override
    public void updateCoupon(Coupon coupon) throws Exception {

    }

    @Override
    public Company getCompany() throws Exception {
        return null;
    }

    @Override
    public Coupon getCoupon(long couponId) throws Exception {
        return null;
    }

    @Override
    public List<Coupon> getAllCompanyCoupons() throws Exception {
        return null;
    }
}
