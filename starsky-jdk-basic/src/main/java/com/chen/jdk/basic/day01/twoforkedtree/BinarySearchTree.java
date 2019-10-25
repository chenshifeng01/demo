package com.chen.jdk.basic.day01.twoforkedtree;

/**
 * 二叉树对对象操作 （左小右大，所有右边的都大于左边的）:
 * 二叉树是一种树型结构，它的特点是每个结点至多只有两棵子树，并且，二叉树的子树有左右之分，其次序不能任意颠倒。
 * 二叉查找树的规则是:对于树中的任意一个结点，都满足，它的左孩子上的所有结点的值都比该结点小，而它的右孩子上的所有结点的值都比该结点大。
 *                  与该结点值相同的的结点可以放在左孩子上，也可以放在右孩子上，这个可以根据实际情况灵活实现。
 * 存储判断逻辑规则：
 *      如果待插入数据比根结点的数据小，就去检查根结点的左孩子。如果左孩子不为空，就继续向下检查，
 *      如果左孩子为空，就说明已经找到应该插入数据的位置了。向右的情况则与向左的情况互为镜像，只是条件判断的符号换了一下而已。
 *
 * @param <T>
 */
class BinarySearchTree<T extends Comparable<T>> {
    public Node root;

    public boolean insert(T i) {
        if (root == null) {
            root = new Node(i);
            return true;
        }

        Node current = root;
        while (true) {
            // 如果 i 比当前结点的值小
            if (i.compareTo((T) current.data) < 0) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new Node(i);
                    break;
                }
            } else {
                if (current.right != null)
                    current = current.right;
                else {
                    current.right = new Node(i);
                    break;
                }
            }
        }
        return true;
    }
}
