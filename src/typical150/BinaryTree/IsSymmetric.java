package typical150.BinaryTree;

//101.对称二叉树
/*给你一个二叉树的根节点 root ， 检查它是否轴对称。*/
//思路:验证两棵树是否对称的方式:一棵树往左走和另一棵树往右走的结果是一样的
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isValid(root, root);
    }

    public boolean isValid(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isValid(t1.left, t2.right) && isValid(t1.right, t2.left);
    }
}
