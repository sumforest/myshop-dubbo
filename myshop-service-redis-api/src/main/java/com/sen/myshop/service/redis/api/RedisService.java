package com.sen.myshop.service.redis.api;

/**
 * @Auther: Sen
 * @Date: 2019/10/5 21:29
 * @Description: redis服务提供者接口
 */
public interface RedisService {

    /**
     * 设置缓存的键值对
     * @param key 键
     * @param value 值
     */
    void set(String key, Object value);

    /**
     * 这只缓存的键值对、超时时间
     * @param key 键
     * @param value 值
     * @param seconds 超时时间
     */
    void set(String key, Object value,long seconds);

    /**
     * 删除redis的数据
     * @param key 键
     */
    void delete(String key);

    /**
     * 获取redis的数据
     * @param key 键
     */
    void get(String key);
}
