package com.basson.Services;

import com.basson.JavaBeans.ClientType;

public class ClientTypeService {

    public interface CouponClientFacade {

        public CouponClientFacade login(String name, String password, ClientType clientType);

    }

}
