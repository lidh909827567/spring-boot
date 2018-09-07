package com.lidh.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * Created by lidhk on 2018/8/28.
 *
 * @author lidhk
 */
public class ZookeeperConfig {

    /**
     * 创建持久型节点
     */
    public String createNodeByPer(ZkClient zkClient,String path, String node) {
        return zkClient.create(path, node, CreateMode.PERSISTENT);
    }

    /**
     * 创建临时型节点
     */
    public String createNodeByEph(ZkClient zkClient,String path, String node) {
        return zkClient.create(path, node, CreateMode.EPHEMERAL);
    }

    /**
     * 修改节点
     */
    public void writeNode(ZkClient zkClient,String path, Object o) {
        if (!zkClient.exists(path)) {
            return;
        }
        zkClient.writeData(path, o);
    }

    /**
     * 删除节点
     */
    public boolean deleteNode(ZkClient zkClient,String path) {
        if (!zkClient.exists(path)) {
            return false;
        }
        zkClient.delete(path);
        return true;
    }

    /**
     * 获取子节点列表
     */
    public List<String> getChildren(ZkClient zkClient,String path) {
        if (!zkClient.exists(path)) {
            return null;
        }
        return zkClient.getChildren(path);
    }

    /**
     * 获取子节点列表
     */
    public Object getNodeData(ZkClient zkClient,String path, Stat stat) {
        if (!zkClient.exists(path)) {
            return null;
        }
        return zkClient.readData(path, stat);
    }
}
