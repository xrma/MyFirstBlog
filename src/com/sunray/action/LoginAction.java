/**
 * 
 */
package com.sunray.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import com.sunray.dao.SystemParameterDAO;
import com.sunray.entity.Article;
import com.sunray.entity.User;
import com.sunray.service.ArticleService;
import com.sunray.service.LoginService;
import com.sunray.system.SystemEnvironment;
import com.sunray.util.SystemConstant;

/**
 * @Title: LoginAction.java
 * @Description:
 * @Author: xrma
 * @CreateTime: Jul 4, 2014 12:13:17 PM
 * @CodeReviewer:
 * @ReviewTime:
 * @Company: CFCA
 */
public class LoginAction {
    private LoginService loginService = (LoginService) SystemEnvironment.APPLICATION_CONTEXT.getBean("loginService");
    private ArticleService articleService = (ArticleService) SystemEnvironment.APPLICATION_CONTEXT.getBean("articleService");
    private SystemParameterDAO systemParameterDAO = (SystemParameterDAO) SystemEnvironment.APPLICATION_CONTEXT.getBean("systemParameterDAO");

    private final String manageIndex = "/manageIndex";
    private final String exceptionPage = "/error";

    @RequestMapping("/LoginAction.do")
    public String forward(HttpServletRequest request, HttpServletResponse response, @Valid User user, Map<String, Object> model) {
        boolean isExistsUser = loginService.isExistsUser(user);
        if (isExistsUser) {
        	Long begin = 0L;
            Long end = 9L;
            List<Article> articleList = articleService.getAricleList(begin, end);
            model.put("articleList", articleList);
            model.put(SystemConstant.WEB_VISIT_COUNT, systemParameterDAO.getCount());
            return manageIndex;
        } else {
            return exceptionPage;
        }
    }
}
