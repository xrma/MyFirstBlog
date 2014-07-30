/**
 * 
 */
package com.sunray.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunray.impl.ArticleSortDAO;
import com.sunray.util.SystemConstant;

/**
 * @author Sunray
 *
 */
@Service
public class ArticleSortService {
	@Resource
	public ArticleSortDAO articleSortDAO;
	
	public Long getArticleSortId(){
		return articleSortDAO.getArticleSortId();
	}
	
	public Long getIncrArticleSortId(){
		return articleSortDAO.getIncrArticleSortId();
	}
	
	public void addNewArticleSort(String newArticleSortName, String articleSortKey){
		articleSortDAO.addNewArticleSort(newArticleSortName, articleSortKey);
	}
	
	public String getArticleSortName(String articleSortKey){
		return articleSortDAO.getArticleSortName(articleSortKey);
	}
	
	public List<String> getArticleIdList(String articleSortId){
	    String articleSortKey = SystemConstant.SORT + articleSortId;
	    return articleSortDAO.getArticleIdByArticleSortId(articleSortKey);
	}
}
