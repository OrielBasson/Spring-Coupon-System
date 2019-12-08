package com.basson;


import com.basson.Services.MyEmailServiceImpl;
import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@EnableEmailTools
@SpringBootApplication
public class CouponSystemApplication extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {

        // ApplicationContext applicationContext = SpringApplication.run(CouponSystemApplication.class, args);
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CouponSystemApplication.class, args);

    }
}
