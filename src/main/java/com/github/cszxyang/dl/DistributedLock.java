package com.github.cszxyang.dl;

public interface DistributedLock {

    boolean lock();

    boolean unLock();
}
