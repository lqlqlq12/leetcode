package _201_400;

//331.验证二叉树的前序序列化
/*序列化二叉树的一种方法是使用 前序遍历 。当我们遇到一个非空节点时，我们可以记录下这个节点的值。

如果它是一个空节点，我们可以使用一个标记值记录，例如 #。*/
/*给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。

保证 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。

你可以认为输入格式总是有效的

例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
注意：不允许重建树。*/
//思路:使用递归
public class IsValidSerialization {
    int index;
    boolean re;

    public boolean isValidSerialization(String preorder) {
        String[] array = preorder.split(",");
        index = 0;
        re = true;
        recursion(array);
        return re && index == array.length;
    }

    public void recursion(String[] array) {
        if (array[index].equals("#")) {
            index++;
            return;
        }
        index++;
        if (index == array.length) {
            re = false;
            return;
        }
        recursion(array);
        if (index == array.length) {
            re = false;
            return;
        }
        recursion(array);
    }
}
