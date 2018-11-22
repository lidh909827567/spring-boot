package com.lidh.list;

/**
 * 单链表操作
 * Created by lidhk on 2018/11/20.
 *
 * @author lidhk
 */
public class SingleList {
    /**
     * 头节点
     */
    private Node head;

    /**
     * 链表大小
     */
    private int size;

    /**
     * 添加方法
     */
    public void addNode(Object o) {
        Node node = new Node(o);
        Node temp = head;
        if (head == null) {
            head = node;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    public void addNodeByIndex(Object o, int index) {
        check(index);
        Node node = new Node(o);
        int length = 1;
        Node temp = head;
        while (temp != null) {
            if (index == length++) {
                node.next = temp.next;
                temp.next = node;
                size++;
                return;
            }
            temp = temp.next;
        }
    }

    public Object getObject(int index) {
        Node temp = head;
        int length = 1;
        while (temp != null) {
            if (index == length++) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    public void delNodeByIndex(int index) {
        check(index);
        int length = 1;
        Node temp = head;
        while (temp.next != null) {
            if (index == length++) {
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }
    }

    public void check(int index) {
        if (index < 0 || index > size) {
            System.out.println("位置不合法");
            return;
        }
    }

    /**
     * 打印方法
     */
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SingleList list = new SingleList();
        list.addNode("1");
        list.addNode("2");
        list.addNode("3");
        list.addNode("4");
        list.print();
        list.addNodeByIndex("xin", 2);
        list.print();
        list.delNodeByIndex(2);
        list.print();
        System.out.println(list.getObject(2));
        System.out.println(list.getSize());
    }
}
