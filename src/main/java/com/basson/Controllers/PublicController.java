package com.basson.Controllers;

import com.basson.JavaBeans.Customer;
import com.basson.Services.PublicService;
import com.basson.Utilities.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.PostRemove;
import javax.servlet.http.HttpServletRequest;

@RestController
public class PublicController {

    @Autowired
    private PublicService publicService;

@PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Customer customer) throws Exception{
    if( customer != null ) {
        if (!Validations.checkIfCustomerExist(customer)){
                if( !customer.getCustomerName().contains(" ") && !customer.getPassword().contains(" ") &&
                !customer.getPassword().equals("") && !customer.getCustomerName().equals("")) {
            publicService.register(customer);
            return new ResponseEntity<>("Customer " + customer.getCustomerName() + " registered successfully. ", HttpStatus.OK);
         } else {
                    return new ResponseEntity<>("Bad request inserted, please try again.", HttpStatus.BAD_REQUEST);
                }
        } else {
            return new ResponseEntity<>("Customer already exist", HttpStatus.BAD_REQUEST);
        }
    } else {
        return new ResponseEntity<>("Null inserted, please try again.", HttpStatus.BAD_REQUEST);
    }
}

}
