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
public class CompanyServiceImpl implements CompanyService, CouponClient{

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private ClientType clientType = ClientType.COMPANY;

    private Company company;

    @Override
    public void addCoupon(Coupon coupon) throws Exception {
       couponRepository.save(coupon);
    }

    @Override
    public void removeCoupon(Coupon coupon) throws Exception {
        couponRepository.delete(coupon);
    }

    @Override
    public void updateCoupon(Coupon coupon) throws Exception {
      couponRepository.save(coupon);
    }

    @Override
    public Company getCompany(long companyId) throws Exception {
       Company company = companyRepository.findByCompanyId(companyId);
       return  company;
    }

    @Override
    public Coupon getCoupon(long couponId) throws Exception {
        Coupon coupon = couponRepository.findById(couponId);
        return coupon;
    }

    @Override
    public List<Coupon> getAllCompanyCoupons(Company company) throws Exception {
        List<Coupon> coupons = couponRepository.findAllByCompanyId(company.getCompanyId());
        return coupons;
    }

    @Override
    public void setCompany(Company company) {
            this.company = company;
        }

    @Override
    public CouponClient login(String userName, String password, ClientType clientType) {
        return null;
    }

}
