package typical150.BinaryTree;

import java.util.HashMap;
import java.util.Map;

//230.二叉搜索树中第K小的元素
/*给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。*/
//思路:用一个map保存每个节点的孩子节点个数
public class KthSmallest {
    Map<Integer, Integer> map;

    public int kthSmallest(TreeNode root, int k) {
        map = new HashMap<>();
        countChild(root);
        return getKthSmallest(root, k);
    }

    public int countChild(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0, right = 0;
        left = countChild(root.left);
        right = countChild(root.right);
        map.put(root.val, left + right);
        return left + right + 1;
    }

    public int getKthSmallest(TreeNode root, int k) {
        int left = 0, right = 0;
        if (root.left != null) left = map.get(root.left.val) + 1;
        if (left >= k) {
            return getKthSmallest(root.left, k);
        }
        if (left == k - 1) {
            return root.val;
        }
        right = map.get(root.right.val) + 1;
        return getKthSmallest(root.right, k - left - 1);
    }

}
