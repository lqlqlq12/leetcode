package _1_200;

//116.填充每个结点的下一个右侧结点指针
/*给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。*/
/*你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。*/
//思路:题目的要求就是把每一层的结点从左到右连起来
//原本想用bfs 但是bfs要一个队列
//思路:用next遍历第i层 然后就可以把第i+1层连起来惹
public class Connect {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null || root.left == null) return root;
        Node t = root, nextHead = t.left, pre = null;
        while (t.left != null) {
            if (pre != null) {
                pre.next = t.left;
            }
            t.left.next = t.right;
            if (t.next == null) {
                t = nextHead;
                pre = null;
                if (nextHead != null) nextHead = nextHead.left;
            } else {
                pre = t.right;
                t = t.next;
            }
        }
        return root;
    }
}
