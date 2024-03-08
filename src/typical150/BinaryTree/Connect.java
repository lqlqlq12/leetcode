package typical150.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//填充每个节点的下一个右侧节点指针II
/*给定一个二叉树：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。

初始状态下，所有 next 指针都被设置为 NULL 。*/
//bfs,每一层连起来 空间复杂度O(n)
//方法二:如果第i层已建立好next连接,那么可使用next遍历这一层,并将i+1层建立好next连接 空间复杂度O(1)
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

    public Node connect(Node root){
        if(root==null){
            return root;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=1;i<=size;i++){
                Node node = queue.poll();
                if(i==size){
                    node.next=null;
                }
                else{
                    node.next=queue.peek();
                }
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return root;
    }

    //用next遍历一层并构建好下一层
    public Node layer(Node root){
        if(root==null) return root;
        root.next=null;
        Node start=root;
        Node nextStart=null;
        while(start!=null){
            Node p=start;
            Node q=null;
            while(p!=null){
                if(nextStart==null&&p.left!=null){
                    nextStart=p.left;
                    q=nextStart;
                    if(p.right!=null){
                        q.next=p.right;
                        q=q.next;
                        p=p.next;
                    }
                    continue;
                }
                if(nextStart==null&&p.right!=null){
                    nextStart=p.right;
                    q=nextStart;
                    p=p.next;
                    continue;
                }
                if(nextStart!=null){
                    if(p.left!=null){
                        q.next=p.left;
                        q=q.next;
                    }
                    if(p.right!=null){
                        q.next=p.right;
                        q=q.next;
                    }
                    p=p.next;
                }
                else{
                    p=p.next;
                }
            }
            start=nextStart;
            nextStart=null;
        }
        return root;
    }
}
