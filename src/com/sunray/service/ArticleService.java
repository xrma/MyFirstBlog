/**
 * 
 */
package com.sunray.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sunray.dao.ArticleDAO;
import com.sunray.entity.Article;

/**
 * @Title: ArticleService.java
 * @Description:
 * @Author: xrma
 * @CreateTime: Jul 3, 2014 5:37:26 PM
 * @CodeReviewer:
 * @ReviewTime:
 * @Company: CFCA
 */
@Component
public class ArticleService {
    @Resource
    private ArticleDAO articleDAO;

    public List<Article> getAricleList(Long begin, Long end) {
        List<String> articleIdList = articleDAO.getArticleIdList(begin, end);
        
        List<Article> articleList = new ArrayList<Article>();

        for (String articleId : articleIdList) {
            Map<String, String> articleMap = articleDAO.getArticleMap(articleId);
            Article article = new Article();;
            article.setTitle(articleMap.get("title"));
            article.setContent(articleMap.get("content"));
            article.setAuthor(articleMap.get("author"));
            article.setSlug(articleMap.get("slug"));
            article.setTime(articleMap.get("time"));
            articleList.add(article);
        }

        return articleList;
    }
}
