package com.basson.Utilities;
import com.basson.JavaBeans.Company;
import com.basson.JavaBeans.Customer;
import com.basson.Services.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;


import com.basson.JavaBeans.ClientType;
import com.basson.Repositories.CompanyRepository;
import com.basson.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoginMethod {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private AdminService adminService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public CouponClient login(String userName, String password, ClientType clientType){

        try {
            switch (clientType) {

                case ADMIN:
                        if (userName.equals("admin") && password.equals("1234")) {
                        AdminService adminServiceBean = ctx.getBean(AdminServiceImpl.class);
                        System.out.println("adminServiceBean syso ..." + adminServiceBean);
                        return (CouponClient) adminServiceBean;
                    } else {
                            System.out.println("null after inputs  (LoginMethod.Class)  ");
                            return null;
                    }
                case COMPANY:
                    Company company = companyRepository.findByCompNameAndPassword(userName, password);
                    if (company != null) {
                        CompanyService companyServiceBean = ctx.getBean(CompanyServiceImpl.class);
                        companyServiceBean.setCompany(company);
                        System.out.println("Company " + company.getCompName() + " logged in to system");
                        return (CouponClient) companyServiceBean;
                    } else {
                        System.out.println("null after inputs  (LoginMethod.Class)  ");
                        return null;
                    }
                case CUSTOMER:
                    Customer customer = customerRepository.findByCustomerNameAndAndPassword(userName, password);
                    if (customer != null) {
                        CustomerService customerServiceBean = ctx.getBean(CustomerServiceImpl.class);
                        customerServiceBean.setCustomer(customer);
                        System.out.println("Customer " + customer.getCustomerName() + " logged in to system");
                        return (CouponClient) customerServiceBean;
                    } else {
                        System.out.println("null after inputs  (LoginMethod.Class)  ");
                        return null;
                    }
            }
        } catch (Exception e){
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println("null return after inputs ...");
        return null;
    }



}
