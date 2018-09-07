package com.lidh.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lidhk on 2018/8/29.
 *
 * @author lidhk
 */
public abstract class AbstractZookeepertLock implements ZookeeperLock {


    static final String ADDRESS = "192.168.199.215:2181";
    static final int SESSION_TIMEOUT = 5000;
    static final int CON_TIMEOUT = 10000;
    protected static final ZkClient zkClient = new ZkClient(ADDRESS, SESSION_TIMEOUT, CON_TIMEOUT);
    protected static final String PATH = "/lock";
    protected CountDownLatch latch = null;

    @Override
    public void getLock() {
        if (tryLock()) {
            System.out.println("获取锁成功");
        } else {
            //等待
            waitLock();
            getLock();
        }
    }

    /**
     * 等待
     *
     * @return
     */
    abstract void waitLock();

    /**
     * 是否获取锁成功 true成功
     *
     * @return
     */
    abstract boolean tryLock();

    @Override
    public void unLock()  {
        if (zkClient != null) {
            zkClient.deleteRecursive(PATH);
//            zkClient.close();
            System.out.println("释放锁");
        }
    }
}
