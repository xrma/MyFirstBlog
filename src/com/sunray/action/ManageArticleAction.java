/**
 * 
 */
package com.sunray.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunray.service.ArticleService;
import com.sunray.service.ArticleSortService;

/** 
 * @Title: ManageArticle.java
 * @Author: xrma
 * @CreateTime: Jul 30, 2014 4:11:56 PM
 * @CodeReviewer: 
 * @ReviewTime: 
 * @Company: CFCA
 */
@Controller
public class ManageArticleAction {
    @Resource
    public ArticleService articleService;
    @Resource
    public ArticleSortService articleSortService;
    
    @RequestMapping("/DeleteArticle.do")
    public String DeleteArticle(String articleId, String sortId){
        articleService.delAeticle(articleId);
        articleSortService.delArticleIdFromSortId(sortId, articleId);
        articleService.delArticleIdFromArticleIdList(articleId);
        return "redirect:GoBackToLogin.do";
    }
}
