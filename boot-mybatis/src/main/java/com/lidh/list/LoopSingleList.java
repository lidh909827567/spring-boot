package com.lidh.list;

import org.springframework.http.StreamingHttpOutputMessage;

/**
 * Created by lidhk on 2018/11/20.
 * <p>
 * 循环单链表
 *
 * @author lidhk
 */
public class LoopSingleList {

    //头节点
    private Element header = null;

    void initList() {
        header = new Element();
        header.value = null;
        header.next = header;
    }


    public void addList(Object o) {
        Element e = new Element();
        e.value = o;
        if (header.next == header) {
            header.next = e;
            e.next = header;
        } else {
            Element temp = header;
            while (temp.next != header) {
                temp = temp.next;
            }
            temp.next = e;
            e.next = header;
        }
    }

    public void delList(Object o) {
        Element temp = header;
        while (temp.next != header) {
            if (temp.next.value == o) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    public Object getElement(int index) {
        if (index < 0 || index > size()-1) {
            System.out.println("位置有误");
            return null;
        }
        int count = 0;
        Element temp = header;
        while (temp.next != header) {
            if (index == count++) {
                return temp.next.value;
            }
            temp = temp.next;
        }
        return temp;
    }

    public int size() {
        Element temp = header;
        int size = 0;
        while (temp.next != header) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void print() {
        Element temp = header;
        while (temp.next != header) {
            temp = temp.next;
            System.out.print(temp.value + "\t");
        }
        System.out.println();
    }

    class Element {
        private Object value = null;
        private Element next = null;
    }

    public static void main(String[] args) {
        LoopSingleList loopSingleList = new LoopSingleList();
        loopSingleList.initList();
        loopSingleList.addList("1");
        loopSingleList.addList("2");
        loopSingleList.addList("3");
        loopSingleList.addList("4");
        System.out.println(loopSingleList.getElement(4));
        System.out.println(loopSingleList.size());
        loopSingleList.print();
        loopSingleList.delList("2");
        System.out.println(loopSingleList.size());
        loopSingleList.print();
    }
}
