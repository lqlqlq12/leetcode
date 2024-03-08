package hot100;

//二叉树的直径
/*给你一棵二叉树的根节点，返回该树的 直径 。

二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。

两节点之间路径的 长度 由它们之间边数表示*/
//递归+深度优先搜索
public class DiameterOfBinaryTree {

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

    int re;

    public int diameterOfBinaryTree(TreeNode root) {
        re=0;
        dfs(root);
        return re;
    }

    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left_length = dfs(node.left)+1;
        int right_length = dfs(node.right)+1;
        if(node.left!=null)System.out.println(node.left.val+" "+left_length);
        if(node.right!=null)System.out.println(node.right.val+" "+right_length);
        re=Math.max(re,left_length+right_length);
        return Math.max(left_length,right_length);
    }
}
