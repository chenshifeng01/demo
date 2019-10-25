package com.chen.jdk.basic.day01.twoforkedtree;


/**
 * 下面给出二叉树的代码实现。由于在二叉树中进行节点的删除非常繁琐，
 * 因此，下面的代码使用的是利用节点的isDelete字段对节点的状态进行标识
 * 二叉树的定义
 */
//可以存储对象，这样的话，我们需要进行对象之间的比较，compareTo可以比较对象，我们需要一些这种，泛型继承Comparable可以使用此方法
//class BinarySearchTree<T extends Comparable<T>> {
public class BinaryTree {

    // 根节点
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    /**
     * 插入操作
     *
     * @param value
     */
    public void insert(int value) {
        TreeNode newNode = new TreeNode(value);
        //如果初始化root是null，那就是第一个节点，也是根节点，故此没有左（右）子节点
        if (root == null) {
            root = newNode;
            root.setLefTreeNode(null);
            root.setRightNode(null);
        } else {
            TreeNode currentNode = root;
            TreeNode parentNode;
            while (true) {
                parentNode = currentNode;
                // 往右放
                if (newNode.getValue() > currentNode.getValue()) {
                    //将当前节点的右节点赋给当前节点（此赋值右节点就是当前节点）
                    currentNode = currentNode.getRightNode();
                    //在进行判断这个节点是否为null
                    if (currentNode == null) {
                        //如果为null了就想当于此当前节点没有值，可以进行赋值返回
                        parentNode.setRightNode(newNode);
                        return;
                    }
                } else {
                    // 往左放
                    currentNode = currentNode.getLefTreeNode();
                    if (currentNode == null) {
                        parentNode.setLefTreeNode(newNode);
                        return;
                    }
                }
            }
        }
    }


    /**
     * 查找
     *
     * @param key
     * @return
     */
    public TreeNode find(int key) {
        //将根节点赋给当前的节点
        TreeNode currentNode = root;
        //进行判断当前节点是否为null（是否有值）
        if (currentNode != null) {
            //进行循环（当前节点的值等于value的时候，就进行不循环，否则循环）
            while (currentNode.getValue() != key) {
                //进行判断当前节点的值是否大于key，如果大于key，相当于对应于key的在左节点
                if (currentNode.getValue() > key) {
                    //进行将左节点赋予给当前节点
                    currentNode = currentNode.getLefTreeNode();
                } else {
                    //否则赋予给右节点（只有两种可能，就是（小于和等于））
                    currentNode = currentNode.getRightNode();
                }
                //进行判断当前节点是否为null，如果为null，就没有这个节点，直接进行返回null
                if (currentNode == null) {
                    return null;
                }
            }
            //当while循环完找到当前值了在可能进行此处，进行判断当前节点是否被删除，如果删除返回null
            if (currentNode.isDelete()) {
                return null;
            } else {
                //否则返回当前节点
                return currentNode;
            }
        } else {
            //如果根节点没有值，直接返回null
            return null;
        }
    }

    /**
     * 中序遍历
     *
     * @param treeNode
     */
    public void inOrder(TreeNode treeNode) {
        if (treeNode != null && treeNode.isDelete() == false) {
            inOrder(treeNode.getLefTreeNode());
            System.out.println("--" + treeNode.getValue());
            inOrder(treeNode.getRightNode());
        }

//        if (treeNode.getLefTreeNode() != null) {
//            inOrder(treeNode.getLefTreeNode());
//            System.out.println("--" + treeNode.getValue());
//        }
//        if (treeNode.getRightNode() != null) {
//            inOrder(treeNode.getRightNode());
//            System.out.println("--" + treeNode.getValue());
//        }
    }

    /**
     * 求二叉树的最大深度
     * 二叉树的题目普遍可以用递归和迭代的方式来解
     * @param node
     * @return
     */
    int maxDeath(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = maxDeath(node.getLefTreeNode());
        int right = maxDeath(node.getRightNode());
        return Math.max(left,right) + 1;
    }

    /**
     * 求二叉树的最小深度
     * @param root
     * @return
     */
    int getMinDepth (TreeNode root) {
        //如果等于null，就想到与此树一个都没有，故此返回0
        if (root == null) {
            return 0;
        }
        //这里进行调用计算节点的最小深度的方法
        return getMin(root);
    }

    private int getMin(TreeNode root) {
        //进行判断此节点是否等于null，如果等于null，赋予最大值，在后续进行进行切最小值的时候只有可能取最小值了
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        //在进行判断左右节点是否为null，如果都为null了，那就返回自身节点1，就不需要进行计算
        if (root.getLefTreeNode() == null && root.getRightNode() == null) {
            return 1;
        }
        //进行取比较左右节点数的最小值
        return Math.min(getMin(root.getLefTreeNode()), getMin(root.getRightNode())) + 1;
    }


    /**
     满二叉树：2^k - 1  == 深度为 k 的二叉树，最多有 2^k - 1 个结点
     完全二叉树： 如果一个二叉树，只有当第 k 层已经达到了 2^{k -1} 的最大值以后，
                  才能往第 k + 1 层自左向右地添加结点，这棵树就被称为完全二叉树。



     */
}
