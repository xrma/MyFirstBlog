/**
 * 
 */
package com.sunray.system;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.sunray.dao.SystemParameterDAO;

/**
 * @Title: SystemInFilter.java
 * @Description:
 * @Author: xrma
 * @CreateTime: Jul 2, 2014 11:36:07 AM
 * @CodeReviewer:
 * @ReviewTime:
 * @Company: CFCA
 */
@Component
public class SystemInFilter implements Filter {
    @Resource
    private SystemParameterDAO systemParameterDAO;

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest request = (HttpServletRequest) req;
        resp.setCharacterEncoding("UTF-8");
        if (request.getSession().isNew()) {
            systemParameterDAO.update();
        }
        chain.doFilter(req, resp);
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }
}
