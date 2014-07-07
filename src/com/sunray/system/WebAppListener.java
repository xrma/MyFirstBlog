/**
 * 
 */
package com.sunray.system;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/** 
 * @Title: WebAppListener.java
 * @Description: 
 * @Author: xrma
 * @CreateTime: Jul 1, 2014 4:25:49 PM
 * @CodeReviewer: 
 * @ReviewTime: 
 * @Company: CFCA
 */
public class WebAppListener implements ServletContextListener {

    /* (non-Javadoc)
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        
        String configPath = arg0.getServletContext().getInitParameter("system.config.path");
        SystemEnvironment.initialize(configPath);
    }

}
