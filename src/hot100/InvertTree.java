package hot100;

import java.util.logging.Level;

//翻转二叉树
/*给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。*/
public class InvertTree {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public TreeNode invertTree(TreeNode root) {
         if(null==root)
             return null;
         TreeNode t=root.left;
         root.left=root.right;
         root.right=t;
         invertTree(root.left);
         invertTree(root.right);
         return root;
    }


}
