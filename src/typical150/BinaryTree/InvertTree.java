package typical150.BinaryTree;

//226.翻转二叉树
/*给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。*/
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tLeft = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tLeft;
        return root;
    }
}
