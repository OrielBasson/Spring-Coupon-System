package com.basson.Controllers;

import com.basson.JavaBeans.ClientType;
import com.basson.JavaBeans.Company;
import com.basson.Services.AdminService;
import com.basson.Services.AdminServiceImpl;
import com.basson.Utilities.LoginMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ApplicationContext ctx;

    @Resource
    private LoginMethod loginMethod;

    	private AdminService getService() throws  Exception {
            AdminService admin = null;
			admin = (AdminService) loginMethod.login("admin", "1234", ClientType.ADMIN);
            System.out.println(admin);
			return admin;
	}


    @PostMapping("/createCompany")
    public ResponseEntity<?> createCompany(@RequestBody Company company) throws Exception{

        AdminService adminService = getService();

        if(adminService != null) {

            if (company != null ) {
                adminService.addCompany(company);
                ResponseEntity<?> result = new ResponseEntity<>("Added company successfully",HttpStatus.OK);
                return result;
            } else {
                ResponseEntity<?> result = new ResponseEntity<>("Added company successfully",HttpStatus.BAD_REQUEST);
                return result;
            }
        } else{
            ResponseEntity<?> unauthorized = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            return unauthorized;
        }
    }


	@GetMapping("/getAllCompanies")
    public ResponseEntity<?> getAllCompanies() throws Exception{

    	    AdminService adminService = getService();
      //    AdminService adminService = ctx.getBean(AdminServiceImpl.class);
    	    if(adminService == null){
                ResponseEntity<?> unauthorized = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                return unauthorized;
    	    } else {
                List<Company> companies = adminService.getAllCompanies();
                ResponseEntity<List<Company>> result = new ResponseEntity<>(companies, HttpStatus.OK);
                return result;
            }
    }





}

