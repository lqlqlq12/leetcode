package _1_200;

//110.平衡二叉树
/*给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。*/
//思路:dfs和bfs
//dfs记录最大深度
//bfs如果上一层不满 下一层还有结点就不平衡
public class IsBalanced {

    boolean balanced;

    public boolean isBalanced(TreeNode root) {
        balanced = true;
        dfs(root);
        return balanced;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            balanced = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }


    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode node = new TreeNode(9);
        TreeNode node1 = new TreeNode(20);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(7);
        root.left = node;
        root.right = node1;
        node1.left = node2;
        node1.right = node3;
        System.out.println(isBalanced(root));
    }

    public static void main(String[] args) {
        new IsBalanced().test();
    }
}

