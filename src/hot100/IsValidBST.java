package hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

//验证二叉搜索树
/*给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树*/
//递归 O(n)
//中序遍历 中序遍历的结果是 小中大 所以序列严格升序
public class IsValidBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean recursion(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        return recursion(root.left, min, (long) root.val - 1) && recursion(root.right, (long) root.val + 1, max);
    }

    public boolean inOrderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        long lastVal=Long.MIN_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val<=lastVal){
                return false;
            }
            lastVal=root.val;
            root=root.right;
        }
        return true;
    }
}
