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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Component;

import com.sunray.exception.SunrayException;
import com.sunray.exception.SunrayMsgConstants;

/** 
 * @Title: ExceptionHandlerFilter.java
 * @Author: xrma
 * @CreateTime: Jul 29, 2014 3:37:11 PM
 * @CodeReviewer: 
 * @ReviewTime: 
 * @Company: CFCA
 */
@Component
public class ExceptionHandlerFilter implements Filter {

    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        Logger logger = LoggerFactory.getLogger(ExceptionHandlerFilter.class);
        try {
            chain.doFilter(request, response);
        } catch (Throwable e) {
            // TODO: handle exception
            String errorCode = null;
            String errorMessage = null;
            if(e instanceof ServletException){
                if (e.getCause() instanceof SunrayException) {
                    e = e.getCause();
                } else if (((ServletException) e).getRootCause() instanceof SunrayException) {
                    e = ((ServletException) e).getRootCause();
                }
            }
            if (e instanceof SunrayException){
                errorCode = ((SunrayException) e).getErrorCode();
                errorMessage = ((SunrayException) e).getErrorMessage();
            }else if (e.getCause() instanceof RedisConnectionFailureException){
                errorCode = "DB4001";
                errorMessage = SunrayMsgConstants.DB_MSG_CONSTANTS_4001;
            }else{
                errorCode = "ER9999";
                errorMessage = SunrayMsgConstants.ER_MEG_CONSTANTS_9999;
            }
            request.setAttribute("errorCode", errorCode);
            request.setAttribute("errorMessage", errorMessage);
            logger.error("error" + e);
            request.getRequestDispatcher("common/error.jsp").forward(request, response);
        }
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

}
