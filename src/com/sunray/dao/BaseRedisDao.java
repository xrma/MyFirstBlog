/**
 * 
 */
package com.sunray.dao;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/** 
 * @Title: BaseRedisDao.java
 * @Description: 
 * @Author: xrma
 * @CreateTime: Jul 2, 2014 2:21:53 PM
 * @CodeReviewer: 
 * @ReviewTime: 
 * @Company: CFCA
 */
public abstract class BaseRedisDao<K, V> {
    
    protected RedisTemplate<K, V> redisTemplate;

    public RedisTemplate<K, V> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    
    protected RedisSerializer<String> getRedisSerializer(){
        return redisTemplate.getStringSerializer();
    }

}
