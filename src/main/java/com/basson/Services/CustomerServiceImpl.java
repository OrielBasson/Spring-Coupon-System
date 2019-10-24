package com.basson.Services;

import com.basson.JavaBeans.ClientType;
import com.basson.JavaBeans.Coupon;
import com.basson.JavaBeans.Customer;
import com.basson.Repositories.CompanyRepository;
import com.basson.Repositories.CouponRepository;
import com.basson.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerServiceImpl implements CustomerService , CouponClient {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CouponRepository couponRepository;

    private Customer customer;

    private ClientType clientType = ClientType.CUSTOMER;

    @Override
    @Transactional
    public Customer getCustomer(long customerId) throws Exception {
       Customer customer = customerRepository.findCustomerById(customerId);
       return customer;
    }

    @Override
    @Transactional
    public void purchaseCoupon(Coupon coupon) throws Exception {
        Coupon couponFromDB = couponRepository.findById(coupon.getId());
        if(couponFromDB == null){
            throw new Exception("Coupon Not Available");
        }
        if (couponFromDB.getAmount() <= 0){

            throw new Exception("Coupon Not Available");
        }
        if (getAllPurchaseCoupons(this.customer).contains(couponFromDB)) {
            throw new Exception("Already bought");
        }

        List<Coupon> customerCoupons = getAllPurchaseCoupons(this.customer);
        customerCoupons.add(coupon);
        this.customer.setCoupons(customerCoupons);
        customerRepository.save(this.customer);
        coupon.setAmount((coupon.getAmount() -1));
        couponRepository.save(coupon);


        System.out.println("Customer " + customer.getCustomerName() + " purchased successfully Coupon " + coupon.getId());

    }

    @Override
    @Transactional
    public List<Coupon> getAllPurchaseCoupons(Customer customer) throws Exception {
        List<Coupon> coupons = customerRepository.findById(this.customer.getId()).get().getCoupons();
        return coupons;
    }

    @Override
    @Transactional
    public List<Coupon> getAllAvailableCoupons() throws Exception {
        List<Coupon> allCoupons = couponRepository.findAll();
        List<Coupon> myCoupons = getAllPurchaseCoupons(this.customer);
        allCoupons.removeIf(coupon -> myCoupons.removeIf(coupon2 -> coupon.getId() == coupon2.getId()));
        List<Coupon> notMyCoupons = allCoupons;
        for(Iterator<Coupon> iterator = notMyCoupons.iterator(); iterator.hasNext() ;){
            Coupon coupon = iterator.next();
            // remove from list if out of stock
            if (coupon.getAmount() < 1){
                iterator.remove();
            }
        }
        return notMyCoupons;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public CouponClient login(String userName, String password, ClientType clientType) {
        return null;
    }
}
