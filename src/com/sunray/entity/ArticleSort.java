/**
 * 
 */
package com.sunray.entity;

import java.io.Serializable;

/**
 * @author Sunray
 * 
 */
public class ArticleSort implements Serializable{
	
	private static final long serialVersionUID = 6140783406706755990L;
	
	private Long articleSortId;
	private String articleSortName;

	public Long getArticleSortId() {
		return articleSortId;
	}

	public void setArticleSortId(Long articleSortId) {
		this.articleSortId = articleSortId;
	}

	public String getArticleSortName() {
		return articleSortName;
	}

	public void setArticleSortName(String articleSortName) {
		this.articleSortName = articleSortName;
	}

}
