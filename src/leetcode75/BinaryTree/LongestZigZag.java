package leetcode75.BinaryTree;

import hot100.PathSum;
import sun.security.provider.DSAKeyFactory;

//1372.二叉树中的最长交错路径
/*给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：

选择二叉树中 任意 节点和一个方向（左或者右）。
如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
改变前进方向：左变右或者右变左。
重复第二步和第三步，直到你在树中无法继续移动。
交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。

请你返回给定树中最长 交错路径 的长度。*/
//做不来
//官解:方法一:用动规 记录每个节点为最后一个节点的长度
//方法二:dfs md改了好久
public class LongestZigZag {

    int re;

    public int longestZigZag(TreeNode root) {
        re = 0;
        if (root == null) return re;
        dfs(root, 1, -1);
        dfs(root, -1, -1);
        return re;
    }

    //1左-1右
    public void dfs(TreeNode root, int direction, int len) {
        if (root == null) {
            re = Math.max(re, len);
            return;
        }
        if (direction == 1) {
            dfs(root.right, -1, len + 1);
            dfs(root.left, 1, -1);
        } else {
            dfs(root.left, 1, len + 1);
            dfs(root.right, -1, -1);
        }
    }


    public void test() {

    }
}
