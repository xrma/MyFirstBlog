/**
 * 
 */
package com.sunray.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunray.entity.Article;
import com.sunray.impl.ArticleDAO;
import com.sunray.impl.ArticleSortDAO;
import com.sunray.impl.ArticleTagsDAO;
import com.sunray.util.SystemConstant;

/**
 * @Title: ArticleService.java
 * @Description:
 * @Author: xrma
 * @CreateTime: Jul 3, 2014 5:37:26 PM
 * @CodeReviewer:
 * @ReviewTime:
 * @Company: CFCA
 */
@Service
public class ArticleService {
    @Resource
    private ArticleDAO articleDAO;
    @Resource
    private ArticleSortDAO articleSortDAO;
    @Resource
    private ArticleTagsDAO articleTagsDAO;

    public List<Article> getAricleList(Long begin, Long end) {
        List<String> articleIdList = articleDAO.getArticleIdList(begin, end);
        
        List<Article> articleList = new ArrayList<Article>();

        for (String articleId : articleIdList) {
            Map<String, String> articleMap = articleDAO.getArticleMap(articleId);
            Article article = new Article();
            article.setArticleId(articleId.replace(SystemConstant.ARTICLE_TAGS_START, ""));
        	article.setTitle(articleMap.get(SystemConstant.ARTICLE_TITLE));
            article.setContent(articleMap.get(SystemConstant.ARTICLE_CONTENT));
            article.setAuthor(articleMap.get(SystemConstant.ARTICLE_AUTHOR));
            article.setTime(articleMap.get(SystemConstant.ARTICLE_TIME));
            article.setArticleSortId(articleMap.get(SystemConstant.ARTICLE_SORT_ID));
            articleList.add(article);
        }

        return articleList;
    }
    
    public Article getArticle(String articleId){
    	Map<String, String> articleMap = articleDAO.getArticleMap(SystemConstant.ARTICLE_TAGS_START + articleId);
    	Article article = new Article();;
    	article.setArticleId(articleId);
    	article.setTitle(articleMap.get(SystemConstant.ARTICLE_TITLE));
        article.setContent(articleMap.get(SystemConstant.ARTICLE_CONTENT));
        article.setAuthor(articleMap.get(SystemConstant.ARTICLE_AUTHOR));
        article.setTime(articleMap.get(SystemConstant.ARTICLE_TIME));
        article.setArticleSortId(articleMap.get(SystemConstant.ARTICLE_SORT_ID));
        return article;
    }
    
    public Long getArticleCounts(){
    	return articleDAO.getArticleCounts();
    }
    
    public void saveArticle(Long aricleId, Article article){
    	String articleKey = SystemConstant.ARTICLE_TAGS_START + aricleId;
    	article.setAuthor("xrma");
    	articleDAO.saveArticle(articleKey, article);
    }
    
    public void saveArticleIdList(Long aricleId){
    	String articleIdKey = SystemConstant.ARTICLE_TAGS_START + aricleId;
    	articleDAO.saveArticleIdList(articleIdKey);
    }
    
    public void saveArticleSortList(String articleSortId, String articleId){
    	String articleSortKEY = SystemConstant.SORT + articleSortId;
    	articleSortDAO.saveArticleSortList(articleId, articleSortKEY);
    }
    
    public void saveArticleTags(String articleId, String[] articleTagsArr){
    	String articleTagsKEY = SystemConstant.ARTICLE_TAGS_START + articleId + SystemConstant.ARTICLE_TAGS_END;
    	articleTagsDAO.saveArticleTags(articleTagsKEY, articleTagsArr);
    }
}
