/**
 * 
 */
package com.sunray.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunray.entity.Article;
import com.sunray.entity.ArticleSort;
import com.sunray.entity.User;
import com.sunray.impl.SystemParameterDAO;
import com.sunray.service.ArticleService;
import com.sunray.service.ArticleSortService;
import com.sunray.service.ArticleTagsService;
import com.sunray.service.LoginService;
import com.sunray.util.SystemConstant;

/**
 * @Title: LoginAction.java
 * @Description:
 * @Author: xrma
 * @CreateTime: Jul 4, 2014 12:13:17 PM
 * @CodeReviewer:
 * @ReviewTime:
 * @Company: CFCA
 */
@Controller
public class LoginAction {
	@Resource
	private LoginService loginService;
	@Resource
	private ArticleService articleService;
	@Resource
	private SystemParameterDAO systemParameterDAO;
	@Resource
	private ArticleSortService articleSortService;
	@Resource
	public ArticleTagsService articleTagsService;

	@RequestMapping("/index.in")
	public String goToIndex(Model model) {
		// List<Article> articleList = this.getArticle();
		// request.setAttribute("articleList", articleList);
		// 1. 访问量
		Long visitCount = Long.parseLong(systemParameterDAO.getCount()) + 1953L;
		Map<Long, ArticleSort> articleSortMap = this.initPage();
		// 文章列表
		List<Article> articleList = this.getArticle();
		model.addAttribute("visitCount", visitCount);
		model.addAttribute("articleSortMap", articleSortMap);
		model.addAttribute("articleList", articleList);
		return "index";
	}

	private List<Article> getArticle() {
		Long begin = 0L;
		Long end = 9L;
		List<Article> articleList = articleService.getAricleList(begin, end);
		return articleList;
	}

	@RequestMapping("/LoginAction.login")
	public String forward(HttpSession session, HttpServletRequest request, HttpServletResponse response, User user, Model model) {
		boolean isExistsUser = loginService.isExistsUser(user);
		if (isExistsUser) {
		    session.setAttribute("user", user);
			// 1. 访问量
			Long visitCount = Long.parseLong(systemParameterDAO.getCount());
			Map<Long, ArticleSort> articleSortMap = this.initPage();
			// 文章列表
			List<Article> articleList = this.getArticle();
			model.addAttribute("visitCount", visitCount);
			model.addAttribute("articleSortMap", articleSortMap);
			model.addAttribute("articleList", articleList);
			return "/manageIndex";
		} else {
			return "/error";
		}
	}
	
	@RequestMapping("/GoBackToLogin.do")
	public String goBackToLogin(Model model){
		Long visitCount = Long.parseLong(systemParameterDAO.getCount());
		Map<Long, ArticleSort> articleSortMap = this.initPage();
		// 文章列表
		List<Article> articleList = this.getArticle();
		model.addAttribute("visitCount", visitCount);
		model.addAttribute("articleSortMap", articleSortMap);
		model.addAttribute("articleList", articleList);
		return "/manageIndex";
	}
	
	@RequestMapping("/ArticleDetail.login")
	public String getArticle(String articleId, Model model){
		Article article = articleService.getArticle(articleId);
		String articleSortId = article.getArticleSortId();
		String articleSortName = articleSortService.getArticleSortName(SystemConstant.SORT_NAME_START + articleSortId + SystemConstant.SORT_NAME_END);
		List<String> articleTagsNameList = articleTagsService.getArticleTags(SystemConstant.ARTICLE_TAGS_START + articleId + SystemConstant.ARTICLE_TAGS_END);
		Map<Long, ArticleSort> articleSortMap = this.initPage();
		
		model.addAttribute("article", article);
		model.addAttribute("articleSortMap", articleSortMap);
		model.addAttribute("articleSortName", articleSortName);
		model.addAttribute("articleTagsNameList", articleTagsNameList);
		return "articleDetail";
	}

	private Map<Long, ArticleSort> initPage() {
		// 2. 获得所有文章分类
		// 2.1 查询文章分类最大值
		Long maxSortId = articleSortService.getArticleSortId();
		// 2.2 查询所有文章分类
		Map<Long, ArticleSort> articleSortMap = new HashMap<Long, ArticleSort>();
		if (maxSortId != null) {
			for (int i = 1; i <= maxSortId; i++) {
				ArticleSort articleSort = new ArticleSort();
				articleSort.setArticleSortId(Long.valueOf(i));
				String articleSortName = articleSortService.getArticleSortName(SystemConstant.SORT_NAME_START + i + SystemConstant.SORT_NAME_END);
				articleSort.setArticleSortName(articleSortName);

				List<String> articleIdList = articleSortService.getArticleIdList(i + "");
				articleSort.setArticleCount(articleIdList.size());
				articleSortMap.put(articleSort.getArticleSortId(), articleSort);
			}
		}
		return articleSortMap;
	}
}
