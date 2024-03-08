package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//二叉搜索树中第k小的元素
/*给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。*/
/*如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？*/
//中序遍历 遍历结果升序
//计算每个节点的子树的结点个数
public class KthSmallest {

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


    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(k - 1);
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    Map<Integer,Integer> map=new HashMap<>();

    public int countChildNum(TreeNode root){
        if (root == null){
            return 0;
        }
        map.put(root.val,countChildNum(root.left)+countChildNum(root.right)+1);
        return map.get(root.val);
    }

    public int getKthSmall(TreeNode root,int k){
        int left=0,right=0;
        if(null!=root.left){
            left=map.get(root.left.val);
        }
        if(root.right!=null){
            right=map.get(root.right.val);
        }
        if(left>=k){
            return getKthSmall(root.left,k);
        }
        else{
            return getKthSmall(root.right,k-left-1);
        }
    }
}
