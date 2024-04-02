package _401_600;

//404.左叶子之和
/*给定二叉树的根节点 root ，返回所有左叶子之和。*/
//dfs
public class SumOfLeftLeaves {
    int re;

    public int sumOfLeftLeaves(TreeNode root) {
        re = 0;
        if (root == null) return re;
        dfs(root.left, -1);
        dfs(root.right, 1);
        return re;
    }

    public void dfs(TreeNode root, int flag) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (flag == -1) {
                re += root.val;
            }
            return;
        }
        dfs(root.left, -1);
        dfs(root.right, 1);
    }
}
