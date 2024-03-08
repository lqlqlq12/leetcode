package typical150.Divide_Conquer;

import typical150.BinaryTree.TreeNode;

//108.将有序数组转换为二叉搜索树
/*给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。*/
//思路:每次都选数组中间的元素作为根节点 左边作为左子树 右边作为右子树
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        return buildTree(nums, 0, len - 1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }
}
