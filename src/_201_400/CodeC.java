package _201_400;

import java.time.temporal.Temporal;

//297.二叉树的序列化与反序列化
/*序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题*/
//官解:就是先序遍历 然后遇到空的用None 好吧 不配困难题
public class CodeC {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    public void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    int index;

    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        index = 0;
        return buildTree(split);
    }

    public TreeNode buildTree(String[] array) {
        if (array[index].equals("#")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(array[index]));
        index++;
        root.left = buildTree(array);
        root.right = buildTree(array);
        return root;
    }

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        node1.left = node2;
//        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;
//        new CodeC().serialize(node1);
        Integer i = 123;
        new CodeC().test(i);
        System.out.println(i);
    }

    public void test(Integer i) {
        i = 3;
    }
}
