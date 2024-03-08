package hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//二叉树的中序遍历
/*给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。*/
//递归
//迭代
//莫里斯
public class InOrderTraversal {

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

    List<Integer> re;

    public List<Integer> inorderTraversal(TreeNode root) {
        re=new ArrayList<>();
        inOrder(root);
        return re;
    }

    //递归
    public void inOrder(TreeNode node){
        if(node==null)
            return;
        inOrder(node.left);
        re.add(node.val);
        inOrder(node.right);
    }

    //迭代
    public List<Integer> dieDai(TreeNode root){
        List<Integer> re=new ArrayList<>();
        Deque<TreeNode> stack=new ArrayDeque<>();
        TreeNode p=root;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();
            re.add(p.val);
            p=p.right;
        }
        return re;
    }
}
