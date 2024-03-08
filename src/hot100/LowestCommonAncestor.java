package hot100;

import java.util.ArrayList;
import java.util.List;

//二叉树的最近公共祖先
/*给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”*/
//从上往下递归,找到公共的父节点,且pq分别在左右子树,或者是p或q本身,另一个在字数
//还是递归,但记录父节点
public class LowestCommonAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }

    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        dfs(root, p, pList);
        dfs(root, q, qList);
        TreeNode re = null;
        for (int i = 1; i <= pList.size() && i <= qList.size(); i++) {
            if (pList.get(pList.size() - i) == qList.get(qList.size() - i)) {
                re = pList.get(pList.size() - i);
            }
        }
        return re;
    }

    public boolean dfs(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root == null) {
            return false;
        }
        if (root == target) {
            list.add(root);
            return true;
        }
        if (dfs(root.left, target, list) || dfs(root.right, target, list)) {
            list.add(root);
            return true;
        }
        return false;
    }

}
