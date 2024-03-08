package typical150.BinaryTree;

//求根节点到叶节点数字之和
/*给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
每条从根节点到叶节点的路径都代表一个数字：

例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
计算从根节点到叶节点生成的 所有数字之和 。

叶节点 是指没有子节点的节点。*/
//感觉dfs会比较好,bfs还要再搞一个队列
public class SumNumbers {
    int re;

    public int sumNumbers(TreeNode root) {
        re = 0;
        dfs(root,0);
        return re;
    }

    public void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, val * 10 + root.val);
        }
        if (root.right != null) {
            dfs(root.right, val * 10 + root.val);
        }
        if(root.left==null&&root.right==null){
            re+=val*10+root.val;
        }
    }
}
