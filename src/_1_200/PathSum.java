package _1_200;

import java.util.ArrayList;
import java.util.List;

//113.路径总和II
/*给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

叶子节点 是指没有子节点的节点*/
//dfs呗
public class PathSum {
    List<List<Integer>> re;
    List<Integer> t;
    int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        re = new ArrayList<>();
        t = new ArrayList<>();
        this.targetSum = targetSum;
        if (root == null) {
            return re;
        }
        dfs(root, 0);
        return re;
    }

    public void dfs(TreeNode root, int sum) {
        t.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum + root.val == targetSum) {
                re.add(new ArrayList<>(t));
            }
        } else if (root.right == null) {
            dfs(root.left, sum + root.val);
        } else if (root.left == null) {
            dfs(root.right, sum + root.val);
        } else {
            dfs(root.left, sum + root.val);
            dfs(root.right, sum + root.val);
        }
        t.remove(t.size() - 1);
    }
}
