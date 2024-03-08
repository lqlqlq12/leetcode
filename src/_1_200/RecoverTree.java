package _1_200;

//99.恢复二叉搜索树
/*给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。*/
/*使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？*/
//O(n)的空间复杂度应该是对二叉搜索树进行中序遍历 然后结果应该是严格递增的
//思路:首先两个结点肯定有祖孙的关系 然后两个结点 至少有一个是不符合二叉搜索树的规律的
//如果只有一个不符合规律 那就把这个值放到应该的地方 然后交换被替换的值
//如果两个都不符合规律 那么就把这两个结点的值交换
//官解是用中序遍历 如果要显式全部遍历一遍 要O(n) 如果用一个prev记录上一个遍历的值 要O(H)
//用morris算法 将左子树不断拼接到右子树 然后只需访问右子树 就可以得到中序遍历的结果
//我的想法:为什么一i的那个要中序遍历 直接dfs bfs遍历树 好像也可以找到异常点把
//因为有空间的限制 用dfs
//好吧 试了一下 发现还是要用中序遍历
//首先肯定是一大一小交换 大换到了小 会比右边大 小换到了大 肯定比左边小 用中序遍历就可以确定是那两个错误
//如果知识普通的遍历二叉树 不知道是子节点的问题还是父节点的问题
//好像直接把树的结构改变了是不行的 虽然可以得到中序遍历 也可以定位到哪里出问题 但不合题意 不可以把结构改变
//不应该直接把root.left切断 如果已经遍历完一次了 则已经建立好了连接 此时判断连接的是不是root就知道是不是遍历第二次了
public class RecoverTree {

    public void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, pred = null, predecessor = null;
        while (root != null) {
            if (root.left == null) {
                if (pred != null && pred.val > root.val) {
                    y = root;
                    if (x == null) {
                        x = pred;
                    } else {
                        break;
                    }
                }
                pred = root;
                root = root.right;
            } else {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    if (pred != null && pred.val > root.val) {
                        y = root;
                        if (x == null) {
                            x = pred;
                        } else {
                            break;
                        }
                    }
                    pred = root;
                    root = root.right;
                    predecessor.right = null;
                }
            }
        }
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

//    public void recoverTree(TreeNode root) {
//        TreeNode x = null, y = null, pred = null, predecessor = null, next = null;
//        while (root != null) {
//            if (root.left == null) {
//                System.out.println(root.val);
//                if (pred != null && pred.val > root.val) {
//                    y = root;
//                    if (x == null) {
//                        x = pred;
//                    } else {
//                        break;
//                    }
//                }
//                pred = root;
//                root = root.right;
//            } else {
//                next = predecessor = root.left;
//                while (predecessor.right != null) {
//                    predecessor = predecessor.right;
//                }
//                predecessor.right = root;
//                root.left = null;
//                root = next;
//            }
//        }
//        int temp = x.val;
//        x.val = y.val;
//        y.val = temp;
//    }

    public void test() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        c.left = a;
        c.right = d;
        d.left = b;
        recoverTree(c);
    }

    public static void main(String[] args) {
        new RecoverTree().test();
    }

}
