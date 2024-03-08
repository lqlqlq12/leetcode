package typical150.BinaryTree;

import java.util.HashMap;
import java.util.Map;

//124.二叉树中的最大路径和
/*二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

路径和 是路径中各节点值的总和。

给你一个二叉树的根节点 root ，返回其 最大路径和 。*/
//思路 记录每一个节点作为起点往下的序列中最大的总和 m() 对于一个序列中最浅的节点root最大和就有
//Math.max(root.val,root.val+Math.max(m(root.left),m(root.right)))
public class MaxPathSum {
    int re;

    public int maxPathSum(TreeNode root) {
        re = root.val;
        getMax(root);
        return re;
    }

    public int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, getMax(root.left));
        int right = Math.max(0, getMax(root.right));
        re = Math.max(re, left + right + root.val);
        return Math.max(left, right) > 0 ? root.val + Math.max(left, right) : root.val;
    }
}
