/**
 * 
 */
package com.sunray.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sunray.dao.LoginDAO;
import com.sunray.entity.User;
import com.sunray.util.StringUtil;

/**
 * @Title: LoginService.java
 * @Description:
 * @Author: xrma
 * @CreateTime: Jul 7, 2014 3:30:26 PM
 * @CodeReviewer:
 * @ReviewTime:
 * @Company: CFCA
 */
@Component
public class LoginService {
    @Resource
    private LoginDAO loginDAO;

    public boolean isExistsUser(User user) {
        // userId --> user:[id]:username(例：user:1:username)
        String userId = loginDAO.getUserId(user.getUserName());
        if (StringUtil.isNotEmpty(userId)) {
            String[] idArr = userId.split(":");
            String id = idArr[1];

            // passwordId --> user:[id]:password(例：user:1:password)
            String passwordId = "user:" + id + ":password";
            String password = loginDAO.getUserPassward(passwordId);

            if (user.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
