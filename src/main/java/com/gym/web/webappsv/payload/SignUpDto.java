package com.gym.web.webappsv.payload;

import lombok.Data;
//https://www.javaguides.net/2021/10/login-and-registration-rest-api-using-spring-boot-spring-security-hibernate-mysql-database.html
@Data
public class SignUpDto {
    private String name;
    private String username;
    private String email;
    private String password;
}
