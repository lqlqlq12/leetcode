package leetcode75.BinaryTree;

import typical150.Array_String.LengthOfLastWord;

//450.删除二叉搜索树中的节点
/*给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。*/
//要求算法时间复杂度为 O(h)，h 为树的高度。
//思路:删除节点后 将左子树中最大的结点或者右子树中最小的节点挪上来
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode hair = new TreeNode(root.val), t = hair, p = hair;
        t.left = root;
        t.right = root;
        while ((t.left == null || t.left.val != key) && (t.right == null || t.right.val != key)) {
            if (t.val < key) {
                if (t.right != null) {
                    t = t.right;
                } else {
                    break;
                }
            } else {
                if (t.left != null) {
                    t = t.left;
                } else {
                    break;
                }
            }
        }
        if (t.left != null && t.left.val == key) {
            p = t.left;
        } else if (t.right != null && t.right.val == key) {
            p = t.right;
        } else {
            return root;
        }
        //找左子树最大的点
        if (p.left != null) {
            TreeNode lastNode = p, next = p.left;
            while (next.right != null) {
                lastNode = next;
                next = next.right;
            }
            if (p != lastNode) {
                lastNode.right = next.left;
                p.val = next.val;
            } else {
                p.val = p.left.val;
                p.left = p.left.left;
            }
            return root;
        }
        //找右子树最小的点
        if (p.right != null) {
            TreeNode lastNode = p, next = p.right;
            while (next.left != null) {
                lastNode = next;
                next = next.left;
            }
            if (p != lastNode) {
                lastNode.left = next.right;
                p.val = next.val;
            } else {
                p.val = p.right.val;
                p.right = p.right.right;
            }
            return root;
        }
        //没有左右孩子 直接删除本节点
        if (t.left != null && t.left.val == key) {
            t.left = null;
        } else {
            t.right = null;
        }
        return hair.left;
    }
}
