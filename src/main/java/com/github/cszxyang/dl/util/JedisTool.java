package com.github.cszxyang.dl.util;

import redis.clients.jedis.Jedis;

public class JedisTool {

    public void setNx(String key, String val, long expire) {
        Jedis jedis = JedisConfiguredPool.getJedis();
        String result = jedis.set(key, val, "NX", "PX", expire);
    }
}
