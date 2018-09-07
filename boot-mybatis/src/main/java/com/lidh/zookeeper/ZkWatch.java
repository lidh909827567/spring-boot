package com.lidh.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lidhk on 2018/8/30.
 *
 * @author lidhk
 */
public class ZkWatch implements Watcher {

    protected static ZooKeeper zk;

    private static CountDownLatch latch = new CountDownLatch(1);


    public static void main(String[] args) {
        new ZkWatch().connectZK();
        String path = "/super";
            try {
                zk.exists(path, true);
                String s = zk.create(path, "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                zk.getData(path, true, new Stat());
                zk.setData(s,"www".getBytes(),-1);
                zk.exists(s, true);
                latch.await();
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (KeeperException e) {
                e.printStackTrace();
            }
    }

    public  void connectZK() {
        try {
            zk = new ZooKeeper("192.168.8.129:2181", 5000, new ZkWatch());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
                latch.countDown();
                System.out.println("Zookeeper session established");
            } else if (Event.EventType.NodeCreated == watchedEvent.getType()) {
                System.out.println("success create znode");

            } else if (Event.EventType.NodeDataChanged == watchedEvent.getType()) {
                System.out.println("success change znode: " + watchedEvent.getPath());

            } else if (Event.EventType.NodeDeleted == watchedEvent.getType()) {
                System.out.println("success delete znode");

            } else if (Event.EventType.NodeChildrenChanged == watchedEvent.getType()) {
                System.out.println("NodeChildrenChanged");

            }

        }
    }
}
