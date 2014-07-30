/**
 * 
 */
package com.sunray.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import com.sunray.dao.ArticleImpl;
import com.sunray.entity.Article;
import com.sunray.util.SystemConstant;

/**
 * @Title: ArticleDAO.java
 * @Description:
 * @Author: xrma
 * @CreateTime: Jul 3, 2014 5:05:14 PM
 * @CodeReviewer:
 * @ReviewTime:
 * @Company: CFCA
 */
@Repository
public class ArticleDAO extends BaseRedisDao<String, List<String>> implements ArticleImpl {
	 private static Logger logger = Logger.getLogger(ArticleDAO.class);
    /*
     * (non-Javadoc)
     * 
     * @see com.sunray.impl.ArticleImpl#getArticleImpl()
     */
    @Override
    public List<String> getArticleIdList(final Long begin, final Long end) {
    	logger.info("getArticleIdList(ArticleDAO) begin...");
        // TODO Auto-generated method stub
        List<String> articleIdList = (List<String>) redisTemplate.execute(new RedisCallback<List<String>>() {

            @Override
            public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
                // TODO Auto-generated method stub
                RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                byte[] articleIdListKEY = redisSerializer.serialize(SystemConstant.ARTICLE_ID_LIST);
                List<byte[]> articleIdListByte = connection.lRange(articleIdListKEY, begin, end);
                List<String> resultList = new ArrayList<String>();
                for (int i = 0; i < articleIdListByte.size(); i++) {
                    resultList.add(redisSerializer.deserialize(articleIdListByte.get(i)));
                }

                return resultList;
            }
        });
        logger.info("getArticleIdList(ArticleDAO) end.");
        return articleIdList;
    }

    @Override
    public Map<String, String> getArticleMap(final String articleId) {
    	logger.info("getArticleMap(ArticleDAO) begin...");
        Map<String, String> articleMap = redisTemplate.execute(new RedisCallback<Map<String, String>>() {

            @Override
            public Map<String, String> doInRedis(RedisConnection connection) throws DataAccessException {
                // TODO Auto-generated method stub
                RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                byte[] articleIdKEY = redisSerializer.serialize(articleId);
                Map<byte[], byte[]> articleMapByte = connection.hGetAll(articleIdKEY);

                Map<String, String> resultMap = new HashMap<String, String>();

                Set<Entry<byte[], byte[]>> set = articleMapByte.entrySet();

                for (Map.Entry<byte[], byte[]> entryMap : set) {
                    resultMap.put(redisSerializer.deserialize(entryMap.getKey()), redisSerializer.deserialize(entryMap.getValue()));
                }

                return resultMap;
            }
        });
        logger.info("getArticleMap(ArticleDAO) end.");
        return articleMap;
    }

	@Override
	public Long getArticleCounts() {
		logger.info("getArticleCounts(ArticleDAO) begin...");
		// TODO Auto-generated method stub
		Long result = redisTemplate.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
				// TODO Auto-generated method stub
				RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                byte[] articleCountsKEY = redisSerializer.serialize(SystemConstant.ARTICLE_COUNTS);
                Long result = redisConnection.incr(articleCountsKEY);
                return result;
			}
			
		});
		logger.info("getArticleCounts(ArticleDAO) end.");
		return result;
	}

	@Override
	public void saveArticle(final String articleIdKey, final Article article) {
		logger.info("saveArticle(ArticleDAO) begin...");
		// TODO Auto-generated method stub
		redisTemplate.execute(new RedisCallback<Object>() {

			@Override
			public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
				// TODO Auto-generated method stub
				RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                byte[] articleKEY = redisSerializer.serialize(articleIdKey);
                
                Map<byte[], byte[]> articleMapByte = new HashMap<byte[], byte[]>();
            	articleMapByte.put(redisSerializer.serialize(SystemConstant.ARTICLE_TITLE), redisSerializer.serialize(article.getTitle()));
            	articleMapByte.put(redisSerializer.serialize(SystemConstant.ARTICLE_AUTHOR), redisSerializer.serialize(article.getAuthor()));
            	articleMapByte.put(redisSerializer.serialize(SystemConstant.ARTICLE_TIME), redisSerializer.serialize(article.getTime()));
            	articleMapByte.put(redisSerializer.serialize(SystemConstant.ARTICLE_CONTENT), redisSerializer.serialize(article.getContent()));
            	articleMapByte.put(redisSerializer.serialize(SystemConstant.ARTICLE_SORT_ID), redisSerializer.serialize(article.getArticleSortId()));
                redisConnection.hMSet(articleKEY, articleMapByte);
                
				return null;
			}
		});
		logger.info("saveArticle(ArticleDAO) end.");
	}

	@Override
	public void saveArticleIdList(final String articleIdKey) {
		logger.info("saveArticleIdList(ArticleDAO) begin...");
		// TODO Auto-generated method stub
		
		redisTemplate.execute(new RedisCallback<Object>() {

			@Override
			public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
				// TODO Auto-generated method stub
				RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                byte[] articleIdKEY = redisSerializer.serialize(articleIdKey);
                redisConnection.lPush(redisSerializer.serialize(SystemConstant.ARTICLE_ID_LIST), articleIdKEY);
				return null;
			}
			
		});
		logger.info("saveArticleIdList(ArticleDAO) end.");
	}

}
