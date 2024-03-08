package leetcode75.BinaryTree;

import java.time.OffsetDateTime;
import java.util.LinkedList;
import java.util.Queue;

//1161.最大层内元素和
/*给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。

请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。*/
//思路:水题一个 直接bfs
public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        int maxLevel = 1, maxSum = root.val;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (sum > maxSum) {
                maxLevel = level;
                maxSum = sum;
            }
        }
        return maxLevel;
    }
}
