package typical150.Divide_Conquer;

import hot100.PathSum;

//建立四叉树
/*给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。

你需要返回能表示矩阵 grid 的 四叉树 的根结点。

四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：

val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False。注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;
}
我们可以按以下步骤为二维区域构建四叉树：

如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，将 val 设为网格相应的值，并将四个子节点都设为 Null 然后停止。
如果当前网格的值不同，将 isLeaf 设为 False， 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。
使用适当的子网格递归每个子节点。*/
//思路 不断将一个图分成四等分,然后再合并 n是偶数
//一遍过 但可以优化 使用二维前缀和优化 pre[i][j]表示 grid[0:i][0:j]区域的和
public class Construct {
    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    int[][] grid;
    int size;

    public Node construct(int[][] grid) {
        this.size = grid.length;
        this.grid = grid;
        return divideConquer(0, size - 1, 0, size - 1);
    }

    //[x1,x2] [y1,y2]
    public Node divideConquer(int x1, int x2, int y1, int y2) {
        if (x1 == x2) {
            return new Node(grid[x1][y1] == 1, true);
        }
        Node topLeft = divideConquer(x1, (x1 + x2) / 2, y1, (y1 + y2) / 2);
        Node bottomLeft = divideConquer((x1 + x2) / 2 + 1, x2, y1, (y1 + y2) / 2);
        Node topRight = divideConquer(x1, (x1 + x2) / 2, (y1 + y2) / 2 + 1, y2);
        Node bottomRight = divideConquer((x1 + x2) / 2 + 1, x2, (y1 + y2) / 2 + 1, y2);
        if (!topLeft.isLeaf || !bottomLeft.isLeaf || !topRight.isLeaf || !bottomRight.isLeaf) {
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
        int zero = 0, one = 0;
        if (topLeft.val) one++;
        if (bottomLeft.val) one++;
        if (topRight.val) one++;
        if (bottomRight.val) one++;
        if (one != 0 && one != 4) {
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
        if (one == 0) {
            return new Node(false, true);
        } else {
            return new Node(true, true);
        }
    }

    public Node optimize(int[][] grid) {
        this.size = grid.length;
        this.grid = grid;
        int[][] pre = new int[size + 1][size + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        return dfs(pre, 0, size - 1, 0, size - 1);
    }

    public Node dfs(int[][] pre, int x1, int x2, int y1, int y2) {
        int sum = pre[x2 + 1][y2 + 1] - pre[x1][y2+1] - pre[x2 + 1][y1] + pre[x1][y1];
        if (sum == 0) {
            return new Node(false, true);
        }
        if (sum == (x2 - x1 + 1) * (y2 - y1 + 1)) {
            return new Node(true, true);
        }
        Node ret = new Node(
                true,
                false,
                dfs(pre, x1, (x1 + x2) / 2, y1, (y1 + y2) / 2),
                dfs(pre, x1, (x1 + x2) / 2, (y1 + y2) / 2 + 1, y2),
                dfs(pre, (x1 + x2) / 2 + 1, x2, y1, (y1 + y2) / 2),
                dfs(pre, (x1 + x2) / 2 + 1, x2, (y1 + y2) / 2 + 1, y2)
        );
        return ret;
    }

    public void test(){
        int[][] grid=new int[][]{{0,1},{1,0}};
        optimize(grid);
    }

    public static void main(String[] args) {
        new Construct().test();
    }
}
