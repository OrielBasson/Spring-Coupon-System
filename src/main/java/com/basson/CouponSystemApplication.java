package com.basson;

import com.basson.JavaBeans.Company;
import com.basson.Services.AdminService;
import com.basson.Services.AdminServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class CouponSystemApplication {
    public static void main(String[] args) throws Exception {

        ApplicationContext applicationContext = SpringApplication.run(CouponSystemApplication.class, args);

    }
}
