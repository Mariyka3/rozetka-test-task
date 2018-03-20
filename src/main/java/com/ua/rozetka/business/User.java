package com.ua.rozetka.business;


import com.ua.rozetka.util.PropertiesUtil;

/**
 * Created by mariia.dibrivna on 3/20/2018.
 */
public class User {
    private String login;
    private String password;

    public User() {
        PropertiesUtil propertiesUtil = PropertiesUtil.getInstance();
        login = propertiesUtil.get("credentials.properties", "login");
        password = propertiesUtil.get("credentials.properties", "password");
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
