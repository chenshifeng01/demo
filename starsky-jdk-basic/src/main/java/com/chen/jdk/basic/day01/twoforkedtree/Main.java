package com.chen.jdk.basic.day01.twoforkedtree;

import com.google.gson.Gson;

import java.util.TreeMap;

/**
 * 测试二叉树
 */
public class Main {

    public static void main (String[] args) {

        BinaryTree tree = new BinaryTree();
        // 1.添加数据测试
        tree.insert(10);
        tree.insert(10);
        tree.insert(40);
        tree.insert(20);
        tree.insert(3);
        tree.insert(49);
        tree.insert(13);
        tree.insert(123);
        Gson gson = new Gson();
        System.out.println(gson.toJson(tree.getRoot()));
        System.out.println("root=" + tree.getRoot().getValue());

        //2.排序测试
        tree.inOrder(tree.getRoot());

        // 3.查找测试
        if (tree.find(10) != null) {
            System.out.println("找到了");
        } else {
            System.out.println("没找到");
        }

        //4.删除测试(使用删除的前提下是必须要有此节点)
        tree.find(40).setDelete(true);
        if (tree.find(40) != null) {
            System.out.println("找到了");
        } else {
            System.out.println("没找到");
        }
    }






}
