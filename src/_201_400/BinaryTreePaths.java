package _201_400;

import java.util.ArrayList;
import java.util.List;

//257.二叉树的所有路径
/*给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

叶子节点 是指没有子节点的节点。*/
//什么水题 直接dfs
//或者递归 但是递归太慢了
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> re = new ArrayList<>();
        if (root == null) return re;
        List<String> lefts = binaryTreePaths(root.left);
        List<String> rights = binaryTreePaths(root.right);
        for (int i = 0; i < lefts.size(); i++) {
            re.add(root.val + "->" + lefts.get(i));
        }
        for (int i = 0; i < rights.size(); i++) {
            re.add(root.val + "->" + rights.get(i));
        }
        if (re.isEmpty()) re.add(String.valueOf(root.val));
        return re;
    }

    List<String> re;

    public List<String> optimize(TreeNode root) {
        re = new ArrayList<>();
        dfs(root, new StringBuilder());
        return re;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            re.add(new StringBuilder(sb).append(root.val).toString());
            return;
        }
        int len = sb.length();
        if (root.left != null) {
            dfs(root.left, sb.append(root.val).append("->"));
            sb.delete(len, sb.length());
        }
        if (root.right != null) {
            dfs(root.right, sb.append(root.val).append("->"));
            sb.delete(len, sb.length());
        }
    }
}
