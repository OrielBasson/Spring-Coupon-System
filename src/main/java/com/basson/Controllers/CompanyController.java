package com.basson.Controllers;

import com.basson.Services.CompanyService;
import com.basson.Utilities.LoginMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private HttpServletRequest request;

    private CompanyService getService() throws  Exception {
        try {
            CompanyService companyService = null;
            companyService = (CompanyService) request.getSession(false).getAttribute("service");
            System.out.println("Print Test from the controller .....   " + companyService);
            return companyService;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }





}
