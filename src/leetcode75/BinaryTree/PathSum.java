package leetcode75.BinaryTree;

import java.util.HashMap;
import java.util.Map;

//437.路径总和III
/*给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。*/
//思路:记录前缀和 用map保存 dfs 注意int越界问题
public class PathSum {
    Map<Long, Integer> map;
    int re;

    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        re = 0;
        map.put(0L, 1);//根节点出发的
        if (root == null) return 0;
        dfs(root, 0, targetSum);
        return re;
    }

    public void dfs(TreeNode root, long sum, int targetSum) {
        re += map.getOrDefault(sum + root.val - targetSum, 0);
        map.put(sum + root.val, map.getOrDefault(sum + root.val, 0) + 1);
        if (root.left != null) dfs(root.left, sum + root.val, targetSum);
        if (root.right != null) dfs(root.right, sum + root.val, targetSum);
        map.put(sum + root.val, map.get(sum + root.val) - 1);
    }
}
