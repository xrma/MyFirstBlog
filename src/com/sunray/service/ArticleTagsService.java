/**
 * 
 */
package com.sunray.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunray.dao.ArticleTagsDAO;

/**
 * @author Sunray
 *
 */
@Service
public class ArticleTagsService {
	@Resource
	public ArticleTagsDAO articleTagsDAO;
	
	public List<String> getArticleTags(String articleId){
		Set<String> articleTagsNameSet = articleTagsDAO.getArticleTagsByArticleId(articleId);
		List<String> articleTagsNameList = new ArrayList<String>();
		
		for(String articleTagsName : articleTagsNameSet){
			articleTagsNameList.add(articleTagsName);
		}
		
		return articleTagsNameList;
	}
}
