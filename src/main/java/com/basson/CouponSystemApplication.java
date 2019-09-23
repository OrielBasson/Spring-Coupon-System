package com.basson;

import com.basson.JavaBeans.Company;
import com.basson.Services.AdminService;
import com.basson.Services.AdminServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CouponSystemApplication {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CouponSystemApplication.class,
                args);

        AdminService adminService = applicationContext.getBean(AdminServiceImpl.class);
        Company company = new Company(1, "TestCompany" , "1234" , "test@gmail.com");
        adminService.addCompany(company);

    }
}
