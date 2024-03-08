package leetcode75.BinaryTree;

import leetcode75.BinaryTree.TreeNode;

//700.二叉搜索树中的搜索
/*给定二叉搜索树（BST）的根节点 root 和一个整数值 val。

你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。*/
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        while (root != null && root.val != val) {
            if (root.val < val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }
}
