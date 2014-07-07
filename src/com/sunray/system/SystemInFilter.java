/**
 * 
 */
package com.sunray.system;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.sunray.dao.SystemParameterDAO;
import com.sunray.entity.Article;
import com.sunray.service.ArticleService;
import com.sunray.util.SystemConstant;

/**
 * @Title: SystemInFilter.java
 * @Description:
 * @Author: xrma
 * @CreateTime: Jul 2, 2014 11:36:07 AM
 * @CodeReviewer:
 * @ReviewTime:
 * @Company: CFCA
 */
public class SystemInFilter implements Filter {

    private SystemParameterDAO systemParameterDAO = (SystemParameterDAO) SystemEnvironment.APPLICATION_CONTEXT.getBean("systemParameterDAO");
    private ArticleService articleService = (ArticleService) SystemEnvironment.APPLICATION_CONTEXT.getBean("articleService");

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
        request.setAttribute(SystemConstant.WEB_VISIT_COUNT, systemParameterDAO.getCount());
        List<Article> articleList = this.getArticle();
        request.setAttribute("articleList", articleList);
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
    
    private List<Article> getArticle(){
        Long begin = 0L;
        Long end = 9L;
        List<Article> articleList = articleService.getAricleList(begin, end);
        return articleList;
    }

}
