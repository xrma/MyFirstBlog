/**
 * 
 */
package com.sunray.impl;

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
}
