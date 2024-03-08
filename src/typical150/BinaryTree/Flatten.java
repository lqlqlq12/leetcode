package typical150.BinaryTree;

//114.二叉树展开为链表
/*给你二叉树的根结点 root ，请你将它展开为一个单链表：

展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。*/
//思路: 将左子树接到右子树的位置,右子树接到左子树线序遍历的最右边的一个节点后
public class Flatten {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode q = next;
                while (q.right != null) {
                    q = q.right;
                }
                q.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
