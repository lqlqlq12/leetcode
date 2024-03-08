package typical150.BinaryTree;

//二叉树的锯齿形层次遍历
/*给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。*/
//一眼bfs

import java.util.*;

public class ZigZagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> re = new ArrayList<>();
        if (root == null) {
            return re;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int direction = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> t = new ArrayList<>();
            //从左到右
            if (direction > 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    t.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                re.add(t);
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.pollLast();
                    t.add(node.val);
                    if (node.right != null) queue.offerFirst(node.right);
                    if (node.left != null) queue.offerFirst(node.left);
                }
                re.add(t);
            }
            direction *= -1;
        }
        return re;
    }
}
