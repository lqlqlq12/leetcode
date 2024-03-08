package _201_400;

import java.util.HashMap;
import java.util.Map;

//337.打家劫舍III
/*小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。

除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。

如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。

给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。*/
//前几次都是动规 这次应该也是
//先来一个带记忆化搜索的递归 这个代码简单
//然后再来递归
//用不了数字 就用Map Map<TreeNode node> 表示从根节点到node节点最多能偷多少
//Map<node>=Math.max(node.val+Map<node.parent.parent>,Map<node.parent>) 这是自顶向下 要用bfs
//应该还可以自底向上 自顶向上有点麻烦
//换一个动规的定义 Map<node>表示node子树的最大和
//所以Map<node>=Math.max(Map<node.left>+Map<node.right>,root.val+)
public class Rob_3 {

    /*Map<TreeNode, Integer> map;

    public int rob(TreeNode root) {
        map = new HashMap<>();
        return Math.max(robRoot(root), notRobRoot(root));
    }

    public int robRoot(TreeNode root) {
        if (map.containsKey(root)) return map.get(root);
        if (root == null) return 0;
        int val = Math.max(root.val + notRobRoot(root.left) + notRobRoot(root.right),
                robRoot(root.left) + robRoot(root.right));
        map.put(root, val);
        return val;
    }


    public int notRobRoot(TreeNode root) {
        if (root == null) return 0;
        return robRoot(root.left) + robRoot(root.right);
    }*/

    Map<TreeNode, Integer> map;

    public int rob(TreeNode root) {
        map = new HashMap<>();
        dfs(root);
        return map.get(root);
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        int val1 = map.getOrDefault(root.left, 0) + map.getOrDefault(root.right, 0);
        int val2 = root.val;
        if (root.left != null) {
            val2 += map.getOrDefault(root.left.left, 0) + map.getOrDefault(root.left.right, 0);
        }
        if (root.right != null) {
            val2 += map.getOrDefault(root.right.left, 0) + map.getOrDefault(root.right.right, 0);
        }
        map.put(root, Math.max(val1, val2));
    }

    public int optimize(TreeNode root) {
        int[] re = recursion(root);
        return Math.max(re[0], re[1]);
    }

    //re[0]表示不偷 re[1]表示偷
    public int[] recursion(TreeNode root) {
        int[] re = new int[2];
        if (root == null) return re;
        int[] lefts = recursion(root.left);
        int[] rights = recursion(root.right);
        re[0] = Math.max(lefts[0], lefts[1]) + Math.max(rights[0], rights[1]);
        re[1] = root.val + lefts[0] + rights[0];
        return re;
    }
}
