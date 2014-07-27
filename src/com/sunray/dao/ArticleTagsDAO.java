/**
 * 
 */
package com.sunray.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import com.sunray.impl.ArticleTagsImpl;

/**
 * @author Sunray
 *
 */
@Repository
public class ArticleTagsDAO extends BaseRedisDao<String, List<String>> implements ArticleTagsImpl {

	@Override
	public void saveArticleTags(final String articleTagsKEY, final String[] articleTagsArr) {
		// TODO Auto-generated method stub
		redisTemplate.execute(new RedisCallback<Object>() {

			@Override
			public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
				// TODO Auto-generated method stub
				RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
				byte[] articleTags = redisSerializer.serialize(articleTagsKEY);
				for(int i=0; i<articleTagsArr.length; i++){
					byte[] articleTagsEach = redisSerializer.serialize(articleTagsArr[i]);
					redisConnection.sAdd(articleTags, articleTagsEach);
				}
				return null;
			}
		});
	}

	@Override
	public Set<String> getArticleTagsByArticleId(final String articleId) {
		// TODO Auto-generated method stub
		Set<String> reuslt = redisTemplate.execute(new RedisCallback<Set<String>>() {

			@Override
			public Set<String> doInRedis(RedisConnection redisConnection) throws DataAccessException {
				// TODO Auto-generated method stub
				RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
				byte[] articleIdByte = redisSerializer.serialize(articleId);
				Set<byte[]> articleTagsByte = redisConnection.sMembers(articleIdByte);
				Set<String> articleTagsNameSet = new HashSet<String>();
				for(byte[] articleTags : articleTagsByte){
					articleTagsNameSet.add(redisSerializer.deserialize(articleTags));
				}
				return articleTagsNameSet;
			}
		});
		return reuslt;
	}

}
