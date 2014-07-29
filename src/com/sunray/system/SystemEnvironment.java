/**
 * 
 */
package com.sunray.system;

import java.io.File;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.context.WebApplicationContext;

/** 
 * @Title: SystemEnvironment.java
 * @Description: 
 * @Author: xrma
 * @CreateTime: Jul 1, 2014 4:30:22 PM
 * @CodeReviewer: 
 * @ReviewTime: 
 * @Company: CFCA
 */
public class SystemEnvironment {
    private static Logger logger;
    public static FileSystemXmlWebApplicationContext APPLICATION_CONTEXT;
    
    private final static String springConfig = "spring.xml";
    private final static String log4jConfig = "log4j.properties";
    
    public static void initialize(String configPath, ServletContextEvent servletContextEvent){
        //log4j初始化
        String log4jCof = configPath + File.separatorChar + log4jConfig;
        PropertyConfigurator.configure(log4jCof);
        logger = Logger.getLogger(SystemEnvironment.class);
        try{
	        String springCof = configPath + File.separatorChar + springConfig;
	        APPLICATION_CONTEXT = new FileSystemXmlWebApplicationContext();
	        APPLICATION_CONTEXT.setConfigLocation(springCof);
	        APPLICATION_CONTEXT.setServletContext(servletContextEvent.getServletContext());
	        APPLICATION_CONTEXT.refresh();
	        servletContextEvent.getServletContext().setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, APPLICATION_CONTEXT);
	        logger.info("spring config：" + springCof);
	        
	        System.out.println("==============================");
	        System.out.println("xrma's blog start!");
	        System.out.println("==============================");
        }catch(Throwable e){
            e.printStackTrace();
            logger.error(e);
        }
    }

}
