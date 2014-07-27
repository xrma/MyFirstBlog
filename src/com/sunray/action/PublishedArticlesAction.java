/**
 * 
 */
package com.sunray.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunray.entity.Article;
import com.sunray.entity.ArticleSort;
import com.sunray.exception.SunrayException;
import com.sunray.exception.SunrayMsgConstants;
import com.sunray.service.ArticleService;
import com.sunray.service.ArticleSortService;
import com.sunray.service.ArticleTagsService;
import com.sunray.util.CommonUtil;
import com.sunray.util.StringUtil;
import com.sunray.util.SystemConstant;
import com.sunray.util.TimeUtil;

/**
 * @author Sunray
 * 
 */
@Controller
public class PublishedArticlesAction {
	@Resource
	public ArticleSortService articleSortService;
	@Resource
	public ArticleService articleService;
	@Resource
	public ArticleTagsService articleTagsService;

	@RequestMapping("publishedArticlesForword.do")
	public String publishedArticlesForword(Model model) {
		Long articleSortMaxId = articleSortService.getArticleSortId();
		String articleSortListStr = this.getAllArticleSort(articleSortMaxId);
		model.addAttribute("currentTime", TimeUtil.getCurrentTime());
		model.addAttribute("articleSortListStr", articleSortListStr);
		return "publishedArticles";
	}

	@RequestMapping("publishedArticles.do")
	public String publishedArticles(Article article, Model model) {
		// 1.从redis得到文章id的最大值
		Long articleIdMax = articleService.getArticleCounts();
		// 2.存储文章基本信息【title，author，time，content】
		articleService.saveArticle(articleIdMax, article);
		// 3.存储文章所属分类
		articleService.saveArticleSortList(article.getArticleSortId(), articleIdMax + "");
		// 4.存文章标签
		String tags = article.getTags();
		String[] tagsArr = tags.split(" ");
		articleService.saveArticleTags(articleIdMax + "", tagsArr);
		
		
		
		//=================
		
		
		
		Article articleQuery = articleService.getArticle(articleIdMax + "");
		String articleSortId = articleQuery.getArticleSortId();
		String articleSortName = articleSortService.getArticleSortName("sort:" + articleSortId + ":name");
		List<String> articleTagsNameList = articleTagsService.getArticleTags(SystemConstant.ARTICLE_TAGS_START + articleIdMax + SystemConstant.ARTICLE_TAGS_END);
		model.addAttribute("title", articleQuery.getTitle());
		model.addAttribute("time", articleQuery.getTime());
		model.addAttribute("author", articleQuery.getAuthor());
		model.addAttribute("content", articleQuery.getContent());
		model.addAttribute("articleSortName", articleSortName);
		model.addAttribute("articleTagsNameList", articleTagsNameList);
		return "success";
	}

	@RequestMapping("addArticleSort.do")
	@ResponseBody
	public Map<String, Object> addSort(String newArticleSortName, Model model) throws SunrayException {
		if (this.checkSort(newArticleSortName)) {
			Long articleSortMaxId = articleSortService.getIncrArticleSortId();
			String articleSortKey = "sort:" + articleSortMaxId + ":name";
			articleSortService.addNewArticleSort(newArticleSortName, articleSortKey);
			String articleSortListStr = this.getAllArticleSort(articleSortMaxId);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("articleSortListStr", articleSortListStr);
			map.put("flag", true);
			return map;
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("errorMsg", SunrayMsgConstants.CO_MSG_CONSTANTS_2001);
			map.put("flag", false);
			return map;
		}

	}

	private String getAllArticleSort(Long articleSortMaxId) {
		if (articleSortMaxId != null) {
			List<ArticleSort> articleSortList = new ArrayList<ArticleSort>();
			for (Long i = 1L; i <= articleSortMaxId; i++) {
				ArticleSort articleSort = new ArticleSort();
				articleSort.setArticleSortId(i);
				String articleSortName = articleSortService.getArticleSortName("sort:" + i + ":name");
				articleSort.setArticleSortName(articleSortName);
				articleSortList.add(articleSort);
			}
			String articleSortListStr = CommonUtil.getArticleSortStr(articleSortList);
			return articleSortListStr;
		}else{
			return null;
		}
	}

	private boolean checkSort(String newArticleSortName) {
		Long articleSortMaxId = articleSortService.getArticleSortId();
		String articleSortListStr = this.getAllArticleSort(articleSortMaxId);
		if (StringUtil.isNotEmpty(articleSortListStr)) {
			if (articleSortListStr.indexOf(newArticleSortName) == -1) {
				return true;
			} else {
				return false;
			}
		}else{
			return true;
		}
	}

}
