package com.basson.Controllers;

import com.basson.Services.CompanyService;
import com.basson.Services.CustomerService;
import com.basson.Utilities.LoginMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private HttpServletRequest request;

    private CustomerService getService() throws  Exception {
        try {
            CustomerService customerService = null;
            customerService = (CustomerService) request.getSession(false).getAttribute("service");
            System.out.println("Print Test from the controller .....   " + customerService);
            return customerService;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }




}
