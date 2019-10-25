package com.chen.jdk.basic.day01.linkedlist;

/**
 * 链表
 * 单向链表
 * 单链表是链表中结构最简单的。一个单链表的节点(Node)分为两个部分，第一个部分(data)保存或者显示关于节点的信息，
 * 另一个部分存储下一个节点的地址。最后一个节点存储地址的部分指向空值。
 *
 *　单向链表只可向一个方向遍历，一般查找一个节点的时候需要从第一个节点开始每次访问下一个节点，
 * 一直访问到需要的位置。而插入一个节点，对于单向链表，我们只提供在链表头插入，只需要将当前插入的节点设置为头节点，
 * next指向原头节点即可。删除一个节点，我们将该节点的上一个节点的next指向该节点的下一个节点。
 */
public class SingleLinkedList {

    private int size;//链表节点的个数

    private Node head;//头节点


    //链表的每个节点类
    private class Node {

        private Object data;//每个节点的数据

        private Node next; //每个节点指向下一个节点的连接

        public Node(Object data) {
            this.data = data;
        }
    }

    //在链表头添加元素
    public Object addHead(Object obj) {
        Node newHead = new Node(obj);
        if (size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;
    }

    //在链表头删除元素
    public void deleteHeader () {
        head = head.next;
        size --;
    }

    //显示节点信息
    public void display() {
        if (size > 0) {
            Node node = head;
            int tempSize = size;
            if (tempSize == 1) {//当前链表只有一个节点
                System.out.println("[" + node.data + "]");
                return;
            }
            while (tempSize > 0) {
                if (node.equals(head)) {
                    System.out.print("[" + node.data + "->");
                } else if (node.next == null) {
                    System.out.print(node.data + "]");
                } else {
                    System.out.print(node.data + "->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        } else {//如果链表一个节点都没有，直接打印[]
            System.out.println("[]");
        }

    }




    public static void main(String[] args) {

        SingleLinkedList singleList = new SingleLinkedList();
        singleList.addHead("A");
        singleList.addHead("B");
        singleList.addHead("C");
        singleList.addHead("D");
//        singleList.deleteHeader();  //删除头部

        singleList.display();

    }

}
