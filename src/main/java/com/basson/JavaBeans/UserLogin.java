package com.basson.JavaBeans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserLogin {

    private String username;
    private String password;
    private String type;

}
