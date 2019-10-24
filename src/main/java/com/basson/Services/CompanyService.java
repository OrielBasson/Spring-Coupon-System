package com.basson.Services;

import com.basson.JavaBeans.Company;
import com.basson.JavaBeans.Coupon;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyService {

    public void addCoupon(Coupon coupon) throws Exception;

    public void removeCoupon (Coupon coupon) throws Exception;

    public void updateCoupon(Coupon coupon) throws Exception;

    public Company getCompany(long companyId) throws Exception;

    public Coupon getCoupon(long couponId) throws Exception;

    public List<Coupon> getAllCompanyCoupons(Company company) throws  Exception;

    public void setCompany(Company company);

}
