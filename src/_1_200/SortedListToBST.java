package _1_200;

//108.有序链表转换二叉搜索树
/*给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。*/

//思路:应该用递归吧
//首先用快慢指针找到中间的结点作为根节点 然后左边的构成左子树 右边的构成右子树
//或者先记录每个结点及其对应的位置 这样就不用每次都快慢指针找中心
//官解每次都用快慢指针寻找中间结点好像还更快 可能每次从map找结点比较慢? 复杂度O(nlogn)
//官解方法二:链表其实就是中序遍历的结果 可以先构建左子树 就是按照中序遍历的顺序来构建结点
public class SortedListToBST {

//    public TreeNode sortedListToBST(ListNode head) {
////        return recursion(head);
//    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head, fast = head, pre = null;
        while (fast.next != null && fast.next.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if (pre != null) {
            pre.next = null;
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(slow.next);
        return root;
    }

    ListNode hair;

    public TreeNode optimize(ListNode head) {
        ListNode t = head;
        hair = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return recursion(0, len - 1);
    }

    public TreeNode recursion(int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode();
        int mid = (left + right) >> 1;
        root.left = recursion(left, mid - 1);
        root.val = hair.val;
        hair = hair.next;
        root.right = recursion(mid + 1, right);
        return root;
    }
}
