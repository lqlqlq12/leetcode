package _1_200;

import java.util.ArrayList;
import java.util.List;

//144.二叉树的前序遍历
/*给你二叉树的根节点 root ，返回它节点值的 前序 遍历。*/
//根左右 直接递归或者莫里斯修改树的结构 morris空间复杂度O(1)递归迭代O(n)
public class PreOrderTraversal {
    List<Integer> re;

    public List<Integer> preorderTraversal(TreeNode root) {
        re = new ArrayList<>();
        if (root == null) return re;
        recursion(root);
        return re;
    }

    public void recursion(TreeNode root) {
        if (root == null) return;
        re.add(root.val);
        recursion(root.left);
        recursion(root.right);
    }

    public List<Integer> morris(TreeNode root) {
        List<Integer> re = new ArrayList<>();
        while (root != null) {
            re.add(root.val);
            if (root.left != null) {
                TreeNode p = root.left;
                while (p.right != null) {
                    p = p.right;
                }
                p.right = root.right;
                root.right = null;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return re;
    }
}
