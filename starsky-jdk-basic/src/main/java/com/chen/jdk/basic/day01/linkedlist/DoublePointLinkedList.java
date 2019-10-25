package com.chen.jdk.basic.day01.linkedlist;

/**
 * 双端链表
 * 对于单项链表，我们如果想在尾部添加一个节点，那么必须从头部一直遍历到尾部，找到尾节点，
 * 然后在尾节点后面插入一个节点。这样操作很麻烦，如果我们在设计链表的时候多个对尾节点的引用，那么会简单很多。
 */
public class DoublePointLinkedList {

    private Node head;  //头

    private Node tail; //尾

    private int size; //链表节点的个数


    private class Node {

        private Object data;

        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    //链表头新增节点
    public void addHead(Object data) {

        Node newNode = new Node(data);
        if (size  == 0) { //如果链表为空，那么头节点和尾节点都是该新增节点
            head = newNode;
            tail = newNode;
        } else {
            head.next = newNode;
        }
        size ++;

    }



}
