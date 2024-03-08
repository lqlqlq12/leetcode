package _1_200;

import java.util.ArrayList;
import java.util.List;

//95.不同的二叉搜索树II
/*给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。

可以按 任意顺序 返回答案。*/
//思路:一般碰到树都是递归
public class GenerateTrees_2 {
    public List<TreeNode> generateTrees(int n) {
        return recursion(1, n);
    }

    //返回好几棵二叉搜索树 值结点范围为[start,end]
    public List<TreeNode> recursion(int start, int end) {
        List<TreeNode> re = new ArrayList<>();
        if (start > end) {
            re.add(null);
            return re;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = recursion(start, i - 1);
            List<TreeNode> rightNodes = recursion(i + 1, end);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode head = new TreeNode(i);
                    head.left = left;
                    head.right = right;
                    re.add(head);
                }
            }
        }
        return re;
    }

}
