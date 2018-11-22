package com.lidh.list;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

/**
 * Created by lidhk on 2018/11/22.
 * <p>
 * 双向链表
 *
 * @author lidhk
 */
public class TwoWayList<T> {
    /**
     * 头节点
     */
    private Node<T> header;
    /**
     * 尾节点
     */
    private Node<T> tail;
    /**
     * 链表长度
     */
    private int size;

    /**
     * 尾插法
     */
    public void addPreNode(T t) {
        Node node = new Node(t);
        if (header == null) {
            header = node;
        } else {
            tail.next = node;
            node.pre = tail;
        }
        tail = node;
        size++;
    }

    /**
     * 头插法
     */
    public void addHeaderNode(T t) {
        Node node = new Node(t);
        if (header == null) {
            tail = node;
        } else {
            header.pre = node;
            node.next = header;
        }
        header = node;
        size++;
    }

    /**
     * 根据数据删除
     */
    public void delNode(T t) {
        Node node = new Node(t);
        Node temp = header;
        size--;
        if (header.data.equals(node.data)) {
            header = header.next;
            return;
        }
        if (tail.data.equals(node.data)) {
            tail = tail.pre;
            tail.next = null;
            return;
        }
        while (temp != null) {
            if (temp.data.equals(node.data)) {
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
            }
            temp = temp.next;
        }
    }

    /**
     * 根据下标查询
     */
    public void getT(int index) {
        Node temp = header;
        int i = 0;
        while (temp != null) {
            if (index == i++) {
                System.out.print(temp.data + "\t");
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 根据数据查询
     */
    public void getData(T t) {
        Node node = new Node(t);
        Node temp = header;
        while (temp != null) {
            if (node.data == temp.data) {
                System.out.print(temp.data + "\t");
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 打印链表
     */

    public void print() {
        Node temp = header;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    class Node<T> {
        public Node<T> pre;
        public Node<T> next;
        public T data;

        public Node(T data) {
            this.data = data;

        }
    }

    public static void main(String[] args) {
        TwoWayList<String> list = new TwoWayList<>();
        list.addPreNode("1");
        list.addPreNode("2");
        list.addPreNode("3");
        list.addHeaderNode("0");
        list.getT(0);
        System.out.println();
        list.getData("2");
        System.out.println();
        list.print();
    }
}
