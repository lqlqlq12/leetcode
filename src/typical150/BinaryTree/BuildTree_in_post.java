package typical150.BinaryTree;

import java.util.HashMap;
import java.util.Map;

//从中序与后序遍历序列构造二叉树
/*给定两个整数数组 inorder 和 postorder ，
其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。*/
// 左根右 左右根
//又忘了,可以用HashMap优化,记录每个节点的下标
//递归 迭代
public class BuildTree_in_post {
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return recursion(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode recursion(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[r2]);
        int index = map.get(postorder[r2]);
        int leftLength = index - l1;
        TreeNode left = recursion(inorder, l1, l1 + leftLength - 1, postorder, l2, l2 + leftLength - 1);
        TreeNode right = recursion(inorder, index + 1, r1, postorder, l2 + leftLength, r2 - 1);
        root.left = left;
        root.right = right;
        return root;
    }

}
