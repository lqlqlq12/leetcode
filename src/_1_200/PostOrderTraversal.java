package _1_200;

import java.util.ArrayList;
import java.util.List;

//145.二叉树的后序遍历
/*给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 */
//左右根
public class PostOrderTraversal {
    List<Integer> re;

    public List<Integer> postorderTraversal(TreeNode root) {
        re = new ArrayList<>();
        recursion(root);
        return re;
    }

    public void recursion(TreeNode root) {
        if (root == null) return;
        recursion(root.left);
        recursion(root.right);
        re.add(root.val);
    }

}
