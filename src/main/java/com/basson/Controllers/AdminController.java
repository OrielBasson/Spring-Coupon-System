package com.basson.Controllers;

import com.basson.JavaBeans.ClientType;
import com.basson.JavaBeans.Company;
import com.basson.Services.AdminService;
import com.basson.Utilities.LoginMethod;
import com.basson.Utilities.Validations;
import com.google.gson.Gson;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {

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
                ResponseEntity<?> result = new ResponseEntity<>("Added company Failed",HttpStatus.BAD_REQUEST);
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
    	    if(adminService != null){
                List<Company> companies = adminService.getAllCompanies();
                ResponseEntity<List<Company>> result = new ResponseEntity<>(companies, HttpStatus.OK);
                return result;
    	    } else {
                ResponseEntity<?> unauthorized = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                return unauthorized;
            }
    }

    @GetMapping("/getCompany/{companyId}")
    public ResponseEntity<?> getCompany(@PathVariable("companyId") long companyId) throws Exception {

        AdminService adminService = getService();
        if(adminService != null){
            Company company = null;
            company = adminService.getCompany(companyId);
            if(company != null ){
                return new ResponseEntity<>(company ,HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Wrong company id" ,HttpStatus.BAD_REQUEST);
            }
        } else {
            ResponseEntity<?> unauthorized = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            return unauthorized;
        }
    }

    @DeleteMapping("/removeCompany/{companyId}")
    public ResponseEntity<?> removeCompany(@PathVariable("companyId") long companyId) throws Exception {

        AdminService adminService = getService();
        if(adminService != null){
            Company company = null;
            company = adminService.getCompany(companyId);
            if(company != null) {
                adminService.removeCompany(company);
            } else {
                return new ResponseEntity<>("Removed Company Failed" ,HttpStatus.BAD_REQUEST);
            }
            ResponseEntity<?> result = new ResponseEntity<>("Removed Company Successfully" ,HttpStatus.OK);
            return result;
        } else {
            ResponseEntity<?> unauthorized = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            return unauthorized;
        }
    }

    @PostMapping("/updateCompany")
    public ResponseEntity<?> updateCompany(@RequestBody String companyJson) throws Exception{

       AdminService adminService = getService();
        if (adminService != null) {
            Gson gson = new Gson();

            Company companyFromJson = gson.fromJson(companyJson, Company.class);

            if (companyFromJson.getCompanyId() > 0) {

                if (Validations.checkIfCompanyExist(adminService.getCompany(companyFromJson.getCompanyId()))) {
                    Company company = adminService.getCompany(companyFromJson.getCompanyId());

                    if ( company != null ) {
                        if (companyFromJson.getEmail() != null && !companyFromJson.getEmail().isEmpty()) {
                            company.setEmail(companyFromJson.getEmail());
                            adminService.updateCompany(company);
                        } else {
                            return new ResponseEntity<>("Invalid new email, please try again" ,HttpStatus.BAD_REQUEST);
                        }
                        if (companyFromJson.getPassword() != null && !companyFromJson.getPassword().isEmpty()) {
                            company.setPassword(companyFromJson.getPassword());
                            adminService.updateCompany(company);
                        } else {
                            return new ResponseEntity<>("Invalid new password, please try again" ,HttpStatus.BAD_REQUEST);
                        }
                        return new ResponseEntity<>("Company  " + company.getCompName() + " Updated Successfully " ,HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>("There is no such company in DB" ,HttpStatus.BAD_REQUEST);
                    }
                } else {
                    return new ResponseEntity<>("There is no company with the id that inserted, please try again! " ,HttpStatus.BAD_REQUEST);
                }
            }
            return new ResponseEntity<>("Invalid - id that inserted <= 0 " ,HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Unauthorized!" , HttpStatus.UNAUTHORIZED);
        }
    }







}

