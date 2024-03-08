package hot100;

import javafx.scene.shape.ArcBuilder;

//将有序数组转换为二叉搜索树
/*给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。*/
//用递归,每次选则根节点
public class SortedArrayToBST {

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


    public TreeNode sortedArrayToBST(int[] nums) {
        return func(nums,0, nums.length-1);
    }

    public TreeNode func(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        int mid=(left+right)>>1;
        TreeNode root=new TreeNode(nums[mid]);
        TreeNode lChild=func(nums,left,mid-1);
        TreeNode rChild=func(nums,mid+1,right);
        root.left=lChild;
        root.right= rChild;
        return root;
    }

}
