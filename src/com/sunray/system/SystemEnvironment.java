/**
 * 
 */
package com.sunray.system;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
    public static ApplicationContext APPLICATION_CONTEXT;
    
    private final static String springConfig = "spring.xml";
    private final static String log4jConfig = "log4j.properties";
    
    public static void initialize(String configPath){
        //log4j初始化
        String log4jCof = configPath + File.separatorChar + log4jConfig;
        PropertyConfigurator.configure(log4jCof);
        logger = Logger.getLogger(SystemEnvironment.class);
        
        String springCof = configPath + File.separatorChar + springConfig;
        APPLICATION_CONTEXT = new FileSystemXmlApplicationContext(springCof);
        logger.info("spring file:" + springCof);
    }

}
