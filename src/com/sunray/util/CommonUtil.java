/**
 * 
 */
package com.sunray.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sunray.entity.ArticleSort;

/**
 * @author Sunray
 *
 */
public class CommonUtil {
	public static String getArticleSortStr(List<ArticleSort> articleSortList){
		Collections.sort(articleSortList, articleSortComparator);
		StringBuilder articleSortListStr = new StringBuilder().append("[");
		for(ArticleSort articleSort : articleSortList){
			articleSortListStr.append("[").append(articleSort.getArticleSortId()).append(",'").append(articleSort.getArticleSortName()).append("'],");
		}
		(articleSortListStr.length() > 1 ? articleSortListStr.deleteCharAt(articleSortListStr.length() - 1) : articleSortListStr).append("]");
		return articleSortListStr.toString();
	}
	
	public static final Comparator<ArticleSort> articleSortComparator = new Comparator<ArticleSort>() {
        public int compare(ArticleSort o1, ArticleSort o2) {
            return (int) (o1.getArticleSortId() - o2.getArticleSortId());
        }
    };
}
