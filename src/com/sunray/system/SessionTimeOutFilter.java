/**
 * 
 */
package com.sunray.system;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.sunray.entity.User;
import com.sunray.exception.SunrayException;
import com.sunray.exception.SunrayMsgConstants;

/** 
 * @Title: SessionTimeOutFilter.java
 * @Author: xrma
 * @CreateTime: Jul 29, 2014 3:00:53 PM
 * @CodeReviewer: 
 * @ReviewTime: 
 * @Company: CFCA
 */

public class SessionTimeOutFilter implements Filter{

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest request = (HttpServletRequest) req;
        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
            chain.doFilter(req, resp);
        }else{
            throw new ServletException(new SunrayException("FI9001", SunrayMsgConstants.FI_MSG_CONSTANTS_9001));
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        
    }

}
