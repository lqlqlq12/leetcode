package leetcode75.BinaryTree;

import java.util.ArrayList;
import java.util.List;

//872.叶子相似的树
/*请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
* 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。

如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。

如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。*/
//思路:dfs 尽量先往左边找
public class LeafSimilar {


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);
        if (l1.size() != l2.size()) {
            return false;
        }
        for (int i = 0; i < l1.size(); i++) {
            if (!l1.get(i).equals(l2.get(i)))
                return false;
        }
        return true;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        if (root.left != null) {
            dfs(root.left, list);
        }
        if (root.right != null) {
            dfs(root.right, list);
        }
    }

    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode c1 = new TreeNode(2);
        TreeNode c2 = new TreeNode(200);
        root.left = c1;
        root.right = c2;
        System.out.println(leafSimilar(root, root));
    }

    public static void main(String[] args) {
        new LeafSimilar().test();
    }
}
