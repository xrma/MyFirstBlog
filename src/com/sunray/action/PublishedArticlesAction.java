/**
 * 
 */
package com.sunray.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunray.entity.Article;
import com.sunray.util.TimeUtil;

/**
 * @author Sunray
 *
 */
@Controller
public class PublishedArticlesAction {
	
	@RequestMapping("publishedArticlesForword.do")
	public String publishedArticlesForword(Model model){
		model.addAttribute("currentTime", TimeUtil.getCurrentTime());
		return "publishedArticles";
	}
	
	@RequestMapping("publishedArticles.do")
	public String publishedArticles(Article article){
		return "";
	}
}
