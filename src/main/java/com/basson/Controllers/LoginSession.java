package com.basson.Controllers;


import com.basson.JavaBeans.ClientType;
import com.basson.JavaBeans.Coupon;
import com.basson.JavaBeans.UserLogin;
import com.basson.Services.CouponClient;
import com.basson.Utilities.LoginMethod;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;


@RestController
@Scope("session")
public class LoginSession {

    @Autowired
    private LoginMethod loginMethod;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin) throws Exception {

//        Gson gson = new Gson();
//        UserLogin userFromJson = gson.fromJson(jsonOfUser, UserLogin.class);

        System.out.println(userLogin);
//        System.out.println(userFromJson);

            String type = userLogin.getType();
            ClientType clientType = ClientType.valueOf(type);

            CouponClient facade = loginMethod.login(userLogin.getUsername(), userLogin.getPassword(), clientType);

            System.out.println(facade);

            // Checking whether there is a open session

            ServletRequestAttributes attr = (ServletRequestAttributes)
                    RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(false);

            //       HttpSession session = request.getSession(false);

            if (session != null) {
                session.invalidate(); // killing the session if exist
            }
            session = attr.getRequest().getSession(true); // create a new session for a new client

            if (facade != null) {
                System.out.println("Facade debug - OK");

                // updating the session with the login facade
                session.setAttribute("facade", facade);

                // response.addCookie(cookie);
                Cookie cookie = new Cookie("Set-Cookie", "JSESSIONID=" + attr.getRequest().getSession().getId() + ";path=/; HttpOnly; domain=/localhost; secure=false;");
                cookie.setComment(type);
                String goodResponse = new Gson().toJson(cookie);

                switch (clientType) {
                    case ADMIN:
                        return new ResponseEntity<>(goodResponse, HttpStatus.OK);
                    case COMPANY:
                        return new ResponseEntity<>(goodResponse, HttpStatus.OK);

                    case CUSTOMER:
                        return new ResponseEntity<>(goodResponse, HttpStatus.OK);
                }
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }





}
