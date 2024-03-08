package typical150.BinarySearch;

//二叉搜索数的最小绝对差
/*给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

差值是一个正数，其数值等于两值之差的绝对值。*/
//思路:中序遍历的整体结果是递增的
//优化:可以不要将遍历结果放到一个list里,再遍历list,可以记录每次的上一个节点,然后和当前节点求差

import typical150.BinaryTree.TreeNode;

public class GetMinimumDifference {
    int lastNumber;
    int re;
    public int getMinimumDifference(TreeNode root) {
        lastNumber=Integer.MAX_VALUE;
        re=Integer.MAX_VALUE;
        inOrder(root);
        return re;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if(lastNumber==Integer.MAX_VALUE){
            lastNumber=root.val;
        }
        else{
            re=Math.min(re,root.val-lastNumber);
            lastNumber=root.val;
        }
        inOrder(root.right);
    }
}
