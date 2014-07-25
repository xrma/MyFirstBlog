/**
 * 
 */
package com.sunray.dao;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import com.sunray.impl.SystemParameterImpl;
import com.sunray.util.SystemConstant;

/**
 * @Title: SystemParameterDAO.java
 * @Description:
 * @Author: xrma
 * @CreateTime: Jul 2, 2014 3:03:11 PM
 * @CodeReviewer:
 * @ReviewTime:
 * @Company: CFCA
 */
@Repository
public class SystemParameterDAO extends BaseRedisDao<String, Long> implements SystemParameterImpl {
	private static Logger logger = Logger.getLogger(SystemParameterDAO.class);
    /*
     * (non-Javadoc)
     * 
     * @see com.sunray.impl.SystemParameterImpl#getCount(java.lang.String)
     */
    @Override
    public String getCount() {
    	logger.info("getCount(SystemParameterDAO) begin...");
        // TODO Auto-generated method stub
        String result = (String) redisTemplate.execute(new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection redisConn) throws DataAccessException {
                // TODO Auto-generated method stub
                RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                byte[] webVisitCountByte = redisSerializer.serialize(SystemConstant.WEB_VISIT_COUNT);
                String webVisitCount = redisSerializer.deserialize(redisConn.get(webVisitCountByte));
                return webVisitCount;
            }
        });
        logger.info("getCount(SystemParameterDAO) end.");
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sunray.impl.SystemParameterImpl#update()
     */
    @Override
    public void update() {
    	logger.info("update(SystemParameterDAO) begin...");
        // TODO Auto-generated method stub
        redisTemplate.execute(new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection redisConn) throws DataAccessException {
                // TODO Auto-generated method stub
                RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                byte[] webVisitCountByte = redisSerializer.serialize(SystemConstant.WEB_VISIT_COUNT);
                redisConn.incr(webVisitCountByte);
                return null;
            }
        });
        logger.info("update(SystemParameterDAO) end.");
    }
}
