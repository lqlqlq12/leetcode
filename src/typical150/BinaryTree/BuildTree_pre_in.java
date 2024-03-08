package typical150.BinaryTree;

import java.util.HashMap;
import java.util.Map;

//105.从前序与中序遍历序列构造二叉树
/*给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点*/
//preorder 和 inorder 均 无重复 元素
public class BuildTree_pre_in {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[l1]);
        int rootIndex = map.get(preorder[l1]);
        int leftLen = rootIndex - l2;
        root.left = build(preorder, l1 + 1, l1 + leftLen, inorder, l2, rootIndex - 1);
        root.right = build(preorder, l1 + leftLen + 1, r1, inorder, rootIndex + 1, r2);
        return root;
    }
}
