package com.sunray.system;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @Description web application context created by file path
 * @Author jianghang
 * @CreateTime 2014-01-09 17:36:35
 * @CodeReviewer
 * @ReviewTime
 * @Company CFCA
 */
public class FileSystemXmlWebApplicationContext extends XmlWebApplicationContext {
    @Override
    protected Resource getResourceByPath(String path) {
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        return new FileSystemResource(path);
    }
}
