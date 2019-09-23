package com.basson.Utilities;
import com.basson.JavaBeans.Company;
import com.basson.Services.*;
import org.springframework.context.ApplicationContext;


import com.basson.JavaBeans.ClientType;
import com.basson.Repositories.CompanyRepository;
import com.basson.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginMethod {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private AdminService adminService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public CouponClient login(String userName, String password, ClientType clientType) throws Exception {

        try {
            switch (clientType) {

                case ADMIN:
                        if (userName.equals("admin") && password.equals("1234")) {
                        AdminService adminServiceBean = ctx.getBean(AdminServiceImpl.class);
                        System.out.println("adminServiceBean syso ..." + adminServiceBean);
                        return (CouponClient) adminServiceBean;
                    } else {
                        throw new Exception("invalid details for Admin user. ");
                    }
                case COMPANY:


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
