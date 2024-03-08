package hot100;


//路径总和|||

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。*/
//使用深度优先搜索,计算全部前缀的根节点到前缀和,然后查看有没有根节点到当前节点减去根节点到前缀节点之后等于目标值的
public class PathSum {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int pathSum(TreeNode root, int targetSum) {
        //map的key是前缀中能得到的值,value是取到这种值有几种不同的前缀
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, 0, map, 1, targetSum);
    }

    int dfs(TreeNode node, long curr, Map<Long, Integer> map, int depth, int targetSum) {
        if (node == null) {
            return 0;
        }
        int ret = 0;
        long target = curr + node.val - targetSum;
        ret+=map.getOrDefault(target,0);
        map.put(curr+node.val,map.getOrDefault(curr+node.val,0)+1);
        ret += dfs(node.left, curr + node.val, map, depth + 1, targetSum);
        ret += dfs(node.right, curr + node.val, map, depth + 1, targetSum);
        map.put(curr+node.val,map.get(curr+node.val)-1);
        return ret;
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
//        root.left = l1;
//        root.right = r1;
        System.out.println(pathSum.pathSum(root, 0));
    }

}
