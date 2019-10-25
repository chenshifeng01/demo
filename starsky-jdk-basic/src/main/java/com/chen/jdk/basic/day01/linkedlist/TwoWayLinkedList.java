package com.chen.jdk.basic.day01.linkedlist;

/**
 * 双向链表
 *
 *　我们知道单向链表只能从一个方向遍历，那么双向链表它可以从两个方向遍历。
 */
public class TwoWayLinkedList {

    private Node head;//表示链表头
    private Node tail;//表示链表尾
    private int size;//表示链表的节点个数

    private class Node {
        private Object data;
        private Node next;
        private Node prev;

        public Node(Object data) {
            this.data = data;
        }
    }

    public TwoWayLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    //在链表头增加节点
    public void addHead(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

}
