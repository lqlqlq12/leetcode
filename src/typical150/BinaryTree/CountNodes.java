package typical150.BinaryTree;

//222.完全二叉树的节点个数
/*给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
若最底层为第 h 层，则该层包含 1~ 2h 个节点。*/
//遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
//题解:二分查找 左0右1 复杂度O(logn*logn) 太巧妙了
public class CountNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = 0;
        TreeNode p = root;
        while (p != null) {
            p = p.left;
            h++;
        }
        int left = 0, right = (2 << (h - 1)) - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (dfs(root, mid, h - 1)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean dfs(TreeNode root, int k, int high) {
        int bits = 1 << (high - 1);
        while (root != null && bits > 0) {
            if ((bits & k) == 0) {
                root = root.left;
            } else {
                root = root.right;
            }
            bits >>= 1;
        }
        return root != null;
    }

    public int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return recursion(root.left) + recursion(root.right) + 1;
    }


}
