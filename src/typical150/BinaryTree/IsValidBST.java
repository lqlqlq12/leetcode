package typical150.BinaryTree;

import java.util.ArrayList;
import java.util.List;

//98.验证二叉搜索树
/*给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。*/
//思路:中序遍历的结果应该是严格递增的
//思路二:定义一个上界ceil和下界floor 对于根节点root[Long.MIN_VALUE,Long.MAX_VALUE]
//对于root的左孩子的 root.left[Long.MIN_VALUE,root.val]
//root.right就是[root.val,Long.MAX_VALUE] 就这样递归下去
//方法二快多了
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = inOrder(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> inOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> re = new ArrayList<>();
        re.addAll(inOrder(root.left));
        re.add(root.val);
        re.addAll(inOrder(root.right));
        return re;
    }


    public boolean optimize(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long floor, long ceil) {
        if (root == null) {
            return true;
        }
        if (root.val <= floor || root.val >= ceil) {
            return false;
        }

        return isValid(root.left, floor, root.val) && isValid(root.right, root.val, ceil);
    }
}
