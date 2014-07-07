/**
 * 
 */
package com.sunray.impl;

import java.util.List;
import java.util.Map;

/** 
 * @Title: ArticleImpl.java
 * @Description: 
 * @Author: xrma
 * @CreateTime: Jul 3, 2014 5:04:02 PM
 * @CodeReviewer: 
 * @ReviewTime: 
 * @Company: CFCA
 */
public interface ArticleImpl {

    /**
     * @param begin
     * @param end
     * @return
     */
    List<String> getArticleIdList(final Long begin, final Long end);

    /**
     * @param articleId
     * @return
     */
    Map<String, String> getArticleMap(final String articleId);
}
