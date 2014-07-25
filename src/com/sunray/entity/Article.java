/**
 * 
 */
package com.sunray.entity;

import java.io.Serializable;

/**
 * @Title: Article.java
 * @Description:
 * @Author: xrma
 * @CreateTime: Jul 3, 2014 4:28:42 PM
 * @CodeReviewer:
 * @ReviewTime:
 * @Company: CFCA
 */
public class Article implements Serializable {
    private static final long serialVersionUID = 3828287985507938295L;
    private String title;//标题
    private String content;//内容
    private String author;
    private String time;//时间
    private String slug;//标签
    private String sort;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
    
    
}
