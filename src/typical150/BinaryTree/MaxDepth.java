package typical150.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//104.二叉树的最大深度
/*给定一个二叉树 root ，返回其最大深度。

二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。*/
//直接dfs bfs
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int le = dfs(root.left);
        int re = dfs(root.right);
        return Math.max(le, re) + 1;
    }

    public int bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int re = 0;
        if (root == null) {
            return re;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            re++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return re;
    }


}
