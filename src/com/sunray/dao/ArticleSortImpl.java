/**
 * 
 */
package com.sunray.dao;

import java.util.List;

/**
 * @author Sunray
 *
 */
public interface ArticleSortImpl {
	public Long getArticleSortId();
	
	public void addNewArticleSort(String newArticleSortName, String articleSortKey);
	
	public String getArticleSortName(String articleSortKey);

	public Long getIncrArticleSortId();
	
	public void saveArticleSortList(String articleId, String articleSortId);
	
	public List<String> getArticleIdByArticleSortId(String articleSortKey);
}
