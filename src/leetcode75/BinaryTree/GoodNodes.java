package leetcode75.BinaryTree;

//1448.统计二叉树中好节点的数目
/*给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。

「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。*/
//思路:dfs 遍历过程中记录遍历到此节点的最大值 水题
public class GoodNodes {
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode root, int max) {
        int re = 0;
        if (root.val >= max) {
            max = root.val;
            re = 1;
        }
        if (root.left != null) re += dfs(root.left, max);
        if (root.right != null) re += dfs(root.right, max);
        return re;
    }

}
