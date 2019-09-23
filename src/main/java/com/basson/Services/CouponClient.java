package com.basson.Services;

import com.basson.JavaBeans.ClientType;
import org.springframework.stereotype.Component;

    public interface CouponClient {

        public CouponClient login(String userName, String password, ClientType clientType);

    }
