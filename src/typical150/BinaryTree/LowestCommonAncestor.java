package typical150.BinaryTree;

//236.二叉树的最近公共祖先
/*给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”*/
//思路 用dfs的方式去找两个节点 寻找路径第一次出现分歧的地方的上一个就是最近公共祖先节点
//官解:用递归的方式 在左右子树找这两个节点的最近祖先(特殊情况父节点) 如果左右结果都不为空 则返回当前节点
//如果一个子树为空 就说明p,q都在同一个子树
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
