/**
 * 
 */
package com.sunray.impl;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import com.sunray.dao.LoginImpl;

/** 
 * @Title: LoginDAO.java
 * @Description: 
 * @Author: xrma
 * @CreateTime: Jul 7, 2014 3:31:50 PM
 * @CodeReviewer: 
 * @ReviewTime: 
 * @Company: CFCA
 */
@Repository
public class LoginDAO extends BaseRedisDao<String, String> implements LoginImpl {
	private static Logger logger = Logger.getLogger(LoginDAO.class);
    /* (non-Javadoc)
     * @see com.sunray.impl.LoginImpl#getUserId(java.lang.String)
     */
    @Override
    public String getUserId(final String userName) {
    	logger.info("getUserId(LoginDAO) begin...");
        // TODO Auto-generated method stub
        String userId = redisTemplate.execute(new RedisCallback<String>() {

            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                // TODO Auto-generated method stub
                RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                byte[] userNameKEY = redisSerializer.serialize(userName);
                byte[] result = connection.get(userNameKEY);
                String userId = redisSerializer.deserialize(result);
                return userId;
            }
        });
        logger.info("getUserId(LoginDAO) end.");
        return userId;
    }

    /* (non-Javadoc)
     * @see com.sunray.impl.LoginImpl#getUserPassward(java.lang.String)
     */
    @Override
    public String getUserPassward(final String passwordId) {
    	logger.info("getUserPassward(LoginDAO) begin...");
        // TODO Auto-generated method stub
        String password = redisTemplate.execute(new RedisCallback<String>() {

            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                // TODO Auto-generated method stub
                RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                byte[] passwordKEY = redisSerializer.serialize(passwordId);
                byte[] result = connection.get(passwordKEY);
                String password = redisSerializer.deserialize(result);
                return password;
            }
        });
        logger.info("getUserPassward(LoginDAO) end.");
        return password;
    }

}
