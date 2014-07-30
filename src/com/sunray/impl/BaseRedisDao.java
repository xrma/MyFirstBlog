/**
 * 
 */
package com.sunray.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
    
	@Autowired
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
