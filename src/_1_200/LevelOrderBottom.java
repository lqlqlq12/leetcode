package _1_200;

import java.util.*;

//107.二叉树的层序遍历II
/*给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。

（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）*/
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> re = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return re;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            re.add(list);
        }
        Collections.reverse(re);
        return re;
    }
}
