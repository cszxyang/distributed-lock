package com.github.cszxyang.dl.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisConfiguredPool {

    private static JedisPool pool;

    static {
        // 读取配置文件
        InputStream resourceAsStream = JedisConfiguredPool.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties pro = new Properties();
        try {
            pro.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获得池子对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(Integer.parseInt(pro.get("redis.maxIdle").toString()));// 最大闲置时间  秒
        config.setMinIdle(Integer.parseInt(pro.get("redis.minIdle").toString()));// 最小闲置时间  秒
        config.setMaxTotal(Integer.parseInt(pro.get("redis.maxTotal").toString()));  // 最大连接数

        // 创建 redis 连接池
        pool = new JedisPool(config, pro.get("redis.url").toString(), Integer.parseInt(pro.get("redis.port").toString()));

    }

    // 获得 jedis 资源方法
    public static Jedis getJedis(){
        return pool.getResource();
    }
}