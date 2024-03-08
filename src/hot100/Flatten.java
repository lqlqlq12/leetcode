package hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*给你二叉树的根结点 root ，请你将它展开为一个单链表：

展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。*/
/*你可以使用原地算法（O(1) 额外空间）展开这棵树吗？*/
//方法一:递归对数进行前序遍历,将按顺序访问的节点存到数组,再依次将数组的元素构建成一个链表
//方法二:和方法一一样,不过用迭代,而不是递归,需要用到栈
//方法三:前两个方法遍历和展开分布进行,将遍历和展开同时进行,不过只能用迭代,迭代入栈的时候将右节点和左节点都入栈,并记录前驱节点
//方法四:寻找前驱节点,不断将左子树移动到右子树,右子树移动到左子树的最右节点的后面
public class Flatten {


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

    public void func1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrderFunc1(root, list);
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            node.left = null;
            if (i < list.size() - 1) {
                node.right = list.get(i + 1);
            } else {
                node.right = null;
            }
        }
    }

    public void preOrderFunc1(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrderFunc1(root.left, list);
        preOrderFunc1(root.right, list);
    }

    public void func2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            TreeNode t = list.get(i);
            t.left = null;
            if (i < list.size() - 1) {
                t.right = list.get(i + 1);
            } else {
                t.right = null;
            }
        }
    }


    public void func3(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) {
            return;
        }
        TreeNode node = root;
        while (true) {
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                node.right=node.left;
                node.left=null;
            }
            else{
                if(!stack.isEmpty())
                    node.right=stack.pop();
                else
                    break;
            }
            node=node.right;
        }
    }

    //方法四:寻找前驱节点
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode curr=root;
        while(curr.left!=null||curr.right!=null){
            if(curr.left!=null){
                TreeNode prev=curr.left;
                while(prev.right!=null){
                    prev=prev.right;
                }
                prev.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }
    }

}
