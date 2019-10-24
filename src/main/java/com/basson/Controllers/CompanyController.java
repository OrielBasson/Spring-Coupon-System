package com.basson.Controllers;

import com.basson.JavaBeans.ClientType;
import com.basson.Services.AdminService;
import com.basson.Services.CompanyService;
import com.basson.Utilities.LoginMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Resource
    private LoginMethod loginMethod;

    private CompanyService getService() throws  Exception {
        CompanyService company = null;
        company = (CompanyService) loginMethod.login("admin", "1234", ClientType.ADMIN);
        return company;
    }

//
//    private CompanyService getCompanyService() {
//        try {
//            CompanyService companyService = null;
//            companyService = (CompanyService) request.getSession(false).getAttribute("facade");
//            return companyService;
//        } catch (Exception e){
//            return null;
//        }
//    }


}
