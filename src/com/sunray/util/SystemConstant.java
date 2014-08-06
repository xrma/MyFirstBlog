/**
 * 
 */
package com.sunray.util;

/**
 * @Title: SystemConstant.java
 * @Description:
 * @Author: xrma
 * @CreateTime: Jul 2, 2014 3:30:10 PM
 * @CodeReviewer:
 * @ReviewTime:
 * @Company: CFCA
 */
public class SystemConstant {

	// 博客访问量
	public static final String WEB_VISIT_COUNT = "system:visit:count";

	// 文章分类总数
	public static final String ARTICALE_SORT_COUNTS = "articleSort:counts";
	public static final String SORT = "articleSort:";
	public static final String ARTICLE_TAGS_START = "article:";
	public static final String ARTICLE_TAGS_END = ":tags";
	//文章总数
	public static final String ARTICLE_COUNTS = "article:counts";
	public static final String ARTICLE_TITLE = "title";
	public static final String ARTICLE_AUTHOR = "author";
	public static final String ARTICLE_TIME = "time";
	public static final String ARTICLE_CONTENT = "content";
	public static final String ARTICLE_SORT_ID = "sortId";
	
	public static final String SORT_NAME_START = "sort:";
	public static final String SORT_NAME_END = ":name";

	// 文章id List 每篇文章的id单独存在一个list里，分页用
	public static final String ARTICLE_ID_LIST = "articleIdList";
	public static final int pageCount = 5;
	
	public static final int articleLength = 500;

}
