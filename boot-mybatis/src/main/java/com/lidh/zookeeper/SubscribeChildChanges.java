package com.lidh.zookeeper;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import static com.lidh.zookeeper.AbstractZookeepertLock.zkClient;
import static com.lidh.zookeeper.ZkWatch.zk;

/**
 * 订阅节点的信息改变（创建节点，删除节点，添加子节点）
 * Created by lidhk on 2018/8/29.
 *
 * @author lidhk
 */
public class SubscribeChildChanges {


    public static void main(String[] args) throws InterruptedException {
        new ZkWatch().connectZK();
        try {
            zk.getData("/super", true, new Stat());
            zk.setData("/super", "123".getBytes(), -1);
            byte[] data = zk.getData("/super", true, null);
            System.out.println("修改" + new String(data));
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public void dataChange() {
        zkClient.subscribeDataChanges("/super", new
                IZkDataListener() {
                    @Override
                    public void handleDataChange(String s, Object o) throws Exception {
                        System.out.println("改变节点元素前:" + s);
                        System.out.println("改变后节点元素:" + o);
                    }

                    @Override
                    public void handleDataDeleted(String s) throws Exception {
                        System.out.println("删除节点元素:" + s);
                    }
                });
    }
}
