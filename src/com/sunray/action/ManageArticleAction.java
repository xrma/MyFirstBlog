/**
 * 
 */
package com.sunray.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunray.entity.Article;
import com.sunray.entity.ArticleSort;
import com.sunray.service.ArticleService;
import com.sunray.service.ArticleSortService;
import com.sunray.service.ArticleTagsService;
import com.sunray.util.CommonUtil;
import com.sunray.util.SystemConstant;
import com.sunray.util.TimeUtil;

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
    @Resource
    public ArticleTagsService articleTagsService;
    
    @RequestMapping("/DeleteArticle.do")
    public String DeleteArticle(String articleId, String sortId){
        articleService.delAeticle(articleId);
        articleSortService.delArticleIdFromSortId(sortId, articleId);
        articleService.delArticleIdFromArticleIdList(articleId);
        return "redirect:GoBackToLogin.do";
    }
    
    @RequestMapping("/modifyArticle.do")
    public String modifyArticle(String articleId, Model model){
        Article article = articleService.getArticle(articleId);
        Long articleSortMaxId = articleSortService.getArticleSortId();
        String articleSortListStr = this.getAllArticleSort(articleSortMaxId);
        List<String> articleTagsNameList = articleTagsService.getArticleTags(SystemConstant.ARTICLE_TAGS_START + articleId + SystemConstant.ARTICLE_TAGS_END);
        
        StringBuffer articleTagsStr = new StringBuffer();
        for(String articleTag : articleTagsNameList){
            articleTagsStr.append(articleTag).append(" ");
        }
        model.addAttribute("currentTime", TimeUtil.getCurrentTime());
        model.addAttribute("articleSortListStr", articleSortListStr);
        model.addAttribute("article", article);
        model.addAttribute("articleTagsStr", articleTagsStr.toString());
        return "publishedArticles";
    }
    
    private String getAllArticleSort(Long articleSortMaxId) {
        if (articleSortMaxId != null) {
            List<ArticleSort> articleSortList = new ArrayList<ArticleSort>();
            for (Long i = 1L; i <= articleSortMaxId; i++) {
                ArticleSort articleSort = new ArticleSort();
                articleSort.setArticleSortId(i);
                String articleSortName = articleSortService.getArticleSortName(SystemConstant.SORT_NAME_START + i + SystemConstant.SORT_NAME_END);
                articleSort.setArticleSortName(articleSortName);
                articleSortList.add(articleSort);
            }
            String articleSortListStr = CommonUtil.getArticleSortStr(articleSortList);
            return articleSortListStr;
        }else{
            return null;
        }
    }
}
