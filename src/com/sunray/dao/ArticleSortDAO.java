/**
 * 
 */
package com.sunray.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import com.sunray.impl.ArticleSortImpl;
import com.sunray.util.StringUtil;
import com.sunray.util.SystemConstant;

/**
 * @author Sunray
 * 
 */
@Repository
public class ArticleSortDAO extends BaseRedisDao<String, List<String>> implements ArticleSortImpl {
	private static Logger logger = Logger.getLogger(ArticleSortDAO.class);

	@Override
	public Long getIncrArticleSortId() {
		logger.info("getIncrArticleSortId(ArticleSortDAO) begin...");
		// TODO Auto-generated method stub
		Long result = redisTemplate.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
				// TODO Auto-generated method stub
				RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                byte[] articaleSortCounts = redisSerializer.serialize(SystemConstant.ARTICALE_SORT_COUNTS);
                Long result = redisConnection.incr(articaleSortCounts);
                return result;
			}
		});
		logger.info("getIncrArticleSortId(ArticleSortDAO) end.");
		return result;
	}

	@Override
	public void addNewArticleSort(final String newArticleSortName, final String articleSortKey) {
		logger.info("addNewArticleSort(ArticleSortDAO) begin...");
		// TODO Auto-generated method stub
		redisTemplate.execute(new RedisCallback<String>(){

			@Override
			public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
				// TODO Auto-generated method stub
				RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
				byte[] articleSortKeyByte = redisSerializer.serialize(articleSortKey);
				byte[] newArticleSortNameByte = redisSerializer.serialize(newArticleSortName);
				redisConnection.set(articleSortKeyByte, newArticleSortNameByte);
				return null;
			}
		});
		logger.info("addNewArticleSort(ArticleSortDAO) end.");
	}

	@Override
	public String getArticleSortName(final String articleSortKey) {
		logger.info("getArticleSortName(ArticleSortDAO) begin...");
		// TODO Auto-generated method stub
		String articleSortName = redisTemplate.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
				// TODO Auto-generated method stub
				RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
				byte[] articleSortKeyByte = redisSerializer.serialize(articleSortKey);
				String articleSortName =  redisSerializer.deserialize(redisConnection.get(articleSortKeyByte));
				return articleSortName;
			}
			
		});
		logger.info("getArticleSortName(ArticleSortDAO) end.");
		return articleSortName;
	}

	@Override
	public Long getArticleSortId() {
		logger.info("getArticleSortId(ArticleSortDAO) begin...");
		// TODO Auto-generated method stub
		Long result = redisTemplate.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
				// TODO Auto-generated method stub
				RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                byte[] articaleSortCounts = redisSerializer.serialize(SystemConstant.ARTICALE_SORT_COUNTS);
                String result = redisSerializer.deserialize(redisConnection.get(articaleSortCounts));
                if(StringUtil.isNotEmpty(result)){
                	return Long.parseLong(result);
                }else{
                	return null;
                }
			}
		});
		logger.info("getArticleSortId(ArticleSortDAO) end.");
		return result;
	}

	@Override
	public void saveArticleSortList(final String articleId, final String articleSortIdKEY) {
		logger.info("saveArticleSortList(ArticleSortDAO) begin...");
		// TODO Auto-generated method stub
		redisTemplate.execute(new RedisCallback<Object>() {

			@Override
			public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
				// TODO Auto-generated method stub
				RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                byte[] articleSortIdKEYByte = redisSerializer.serialize(articleSortIdKEY);
                byte[] articleIdByte = redisSerializer.serialize(articleId);
				redisConnection.lPush(articleSortIdKEYByte, articleIdByte);
				return null;
			}
		});
		logger.info("saveArticleSortList(ArticleSortDAO) begin...");
	}

}
