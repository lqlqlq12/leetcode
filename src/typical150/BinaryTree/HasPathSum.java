package typical150.BinaryTree;

import hot100.PathSum;

//路径总和
/*给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。

叶子节点 是指没有子节点的节点。*/
//啊？直接dfs bfs 但bfs还要多一个队列保存已经累加的和
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum);
    }

    public boolean dfs(TreeNode root, int val) {
        if (root.left == null && root.right == null && root.val == val) return true;

        if (root.left != null) {
            if (dfs(root.left, val - root.val))
                return true;
        }
        if (root.right != null) {
            if (dfs(root.right, val - root.val))
                return true;
        }
        return false;
    }

}
