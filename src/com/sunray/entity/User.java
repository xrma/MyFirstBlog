/**
 * 
 */
package com.sunray.entity;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @Title: User.java
 * @Description:
 * @Author: xrma
 * @CreateTime: Jul 7, 2014 2:05:08 PM
 * @CodeReviewer:
 * @ReviewTime:
 * @Company: CFCA
 */
public class User {
    @NotBlank(message = "username不能为空")
    private String userName;
    @NotBlank(message = "password不能为空")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

}
