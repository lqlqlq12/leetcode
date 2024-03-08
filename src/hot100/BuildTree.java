package hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//从前序与中序遍历序列构造二叉树
/*给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点*/
//一眼递归
public class BuildTree {

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

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        if (preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode myBuildTree(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        if(preL>preR){
            return null;
        }
        TreeNode root=new TreeNode(pre[preL]);
        int root_index=map.get(pre[preL]);
        int left_length=root_index-inL;
        int right_length=inR-root_index;
        root.left=myBuildTree(pre,preL+1,preL+left_length,in,inL,root_index-1);
        root.right=myBuildTree(pre,preL+left_length+1,preR,in,root_index+1,inR);
        return root;
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        buildTree.buildTree(preorder, inorder);
    }
}
