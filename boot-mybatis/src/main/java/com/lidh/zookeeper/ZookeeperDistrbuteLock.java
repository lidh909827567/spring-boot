package com.lidh.zookeeper;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lidhk on 2018/8/29.
 *
 * @author lidhk
 */
public class ZookeeperDistrbuteLock extends AbstractZookeepertLock {
    @Override
    void waitLock() {
        //使用事件监听
        IZkDataListener iZkDataListener = new IZkDataListener() {

            //当节点被修改
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println(s + "111111111");
            }

            //当节点被删除
            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println(s + "111111111");
                if (latch != null) {
                    //唤醒
                    latch.countDown();
                }
            }
        };
        //注册节点信息
        zkClient.subscribeDataChanges(PATH, iZkDataListener);
        if (zkClient.exists(PATH)) {
            //创建信号量
            latch = new CountDownLatch(1);
            try {
                //等待
                latch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //删除事件通知
        zkClient.unsubscribeDataChanges(PATH, iZkDataListener);
    }

    @Override
    boolean tryLock() {
        try {
            zkClient.createEphemeral(PATH);
//            zkClient.createPersistent(PATH);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
