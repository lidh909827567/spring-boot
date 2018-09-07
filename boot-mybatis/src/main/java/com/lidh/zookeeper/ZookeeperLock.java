package com.lidh.zookeeper;

/**
 * Created by lidhk on 2018/8/29.
 *
 * @author lidhk
 */
public interface ZookeeperLock {
    /**
     *获得锁
     * */
    public void getLock();
    /**
     * 释放锁
     * */
    public void unLock();
}
