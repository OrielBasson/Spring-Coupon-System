package com.basson.Services;

import com.basson.JavaBeans.ClientType;
import com.basson.JavaBeans.Company;
import com.basson.JavaBeans.Coupon;
import com.basson.Repositories.CompanyRepository;
import com.basson.Repositories.CouponRepository;
import com.basson.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
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
        Coupon requestedCoupon = couponRepository.findById(couponId);
        List<Coupon> companyCoupons = getAllCompanyCoupons(getCompany());
        for(Iterator<Coupon> iterator = companyCoupons.iterator(); iterator.hasNext(); ) {
            Coupon companyCoupon = iterator.next();
            if (companyCoupon.getId() == requestedCoupon.getId()){
                return requestedCoupon;
            }
        }
        return null;
    }

    @Override
    public List<Coupon> getAllCompanyCoupons(Company company) throws Exception {
        List<Coupon> coupons = couponRepository.findAllByCompanyId(getCompany().getCompanyId());
        return coupons;
    }

    @Override
    public void setCompany(Company company) {
            this.company = company;
        }

    @Override
    public Company getCompany() {
        return this.company;
    }

    @Override
    public CouponClient login(String userName, String password, ClientType clientType) {
        return null;
    }

}
