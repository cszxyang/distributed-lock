package com.github.cszxyang.dl.redis;

import com.github.cszxyang.dl.DistributedLock;

public class RedisLock implements DistributedLock {



    public boolean lock() {
        return false;
    }

    public boolean unLock() {
        return false;
    }
}
