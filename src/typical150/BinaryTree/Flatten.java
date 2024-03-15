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


    public TreeNode toList(TreeNode root) {
        if (root == null) return root;
        TreeNode ans = root;
        while (root != null) {
            if (root.left != null) {
                TreeNode t = root.left;
                while (t.right != null) t = t.right;
                t.right = root.right;
                root.right = null;
            } else {
                root.left = root.right;
                root.right = null;
            }
            root = root.left;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l2 = new TreeNode(4);
        TreeNode r2 = new TreeNode(5);
        TreeNode l3 = new TreeNode(6);
        TreeNode r3 = new TreeNode(7);
        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = r2;
        r1.left = l3;
        r1.right = r3;
        TreeNode head = new Flatten().toList(root);
        while (head != null) {
            System.out.println(head.val);
            head = head.left;
        }
    }
}
