package _201_400;

//235.二叉搜索树的最近公共祖先
/*给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”*/
//和二叉树的公共祖先一个思路
//可以尝试一下迭代
//水题
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (((long) p.val - root.val) * ((long) q.val - root.val) < 0) return root;
        if (root == p || root == q) return root;
        if (p.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }

    public TreeNode optimize(TreeNode root, TreeNode p, TreeNode q) {
        while ((((long) p.val - root.val) * ((long) q.val - root.val) > 0)) {
            if (p.val < root.val) root = root.left;
            else root = root.right;
        }
        return root;
    }
}
