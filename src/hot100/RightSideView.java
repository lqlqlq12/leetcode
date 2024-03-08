package hot100;

import java.util.*;

//二叉树的右视图
/*给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值*/
//BFS 先左后右,记录每一层最后出现的一个 先右后左,记录每一层第一个出现的
//DFS 先右后左,记录每一层先出现的那个 优化:不要判断map里是否有这个深度的key,可以将map的size和深度比较
//dfs再优化 既然都用size判断是否第一次出现了,那就把map还成list,顺便将list返回 巨快
public class RightSideView {


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

    List<Integer> re;

    public List<Integer> rightSideView(TreeNode root) {
        re=new ArrayList<>();
        dfs(root,1);
        return re;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth>re.size()) {
            re.add(node.val);
        }
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }

    //广优先
    public List<Integer> bfs(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        if(root!=null)
            queue.offer(root);
        while(!queue.isEmpty()){
            ans.add(queue.peek().val);
            for(int count=queue.size();count!=0;count--){
                root=queue.poll();
                if(root.right!=null){
                    queue.offer(root.right);
                }
                if(root.left!=null){
                    queue.offer(root.left);
                }

            }
        }
        return ans;
    }


}
