/**
 * 
 */
package com.sunray.impl;

import java.util.Set;


/**
 * @author Sunray
 *
 */
public interface ArticleTagsImpl {
	void saveArticleTags(String articleTagsKEY, String[] articleTagsArr);
	Set<String> getArticleTagsByArticleId(String articleId);
}
