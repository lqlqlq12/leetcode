package typical150.BackTracking;

//52.N皇后II
/*n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量*/
//应该dfs 每一次调用就放到下一行
//直接秒了 有什么好说的!!!
//超级小优化 可以不用一个boolean数组来存储是否可以放此位置 可以用一个数字来存储 然后数字的不同位就代替了前面数组的一个元素
//位运算太难了
/*x&(−x) 可以获得 x 的二进制表示中的最低位的 1 的位置；
x&(x−1)可以将 x 的二进制表示中的最低位的 1 置成 0。*/
//用位操作的还是传参把 用全局变量还得修改回去 会出错 莫名其妙
public class TotalNQueens {
    boolean[] col;
    boolean[] top_left;
    boolean[] top_right;
    int re;

    public int totalNQueens(int n) {
        col = new boolean[n];
        top_left = new boolean[2 * n - 1];
        top_right = new boolean[2 * n - 1];
        re = 0;
        dfs(0, n);
        return re;
    }

    public void dfs(int index, int target) {
        if (index == target) {
            re++;
            return;
        }
        for (int i = 0; i < target; i++) {
            int index1 = i + target - index - 1, index2 = index + i;
            if (!col[i] && !top_left[index1] && !top_right[index2]) {
                col[i] = true;
                top_left[index1] = true;
                top_right[index2] = true;
                dfs(index + 1, target);
                col[i] = false;
                top_left[index1] = false;
                top_right[index2] = false;
            }
        }
    }

    public int optimize(int n) {
        re = 0;
        dfs_2(0, n, 0, 0, 0);
        return re;
    }

    public void dfs_2(int index, int target, int col_num, int top_left_num, int top_right_num) {
        if (index == target) {
            re++;
            return;
        }
        //右移target并减1的含义是只要低的target的位数
        int possible = ((1 << target) - 1) & (~(col_num | top_left_num | top_right_num));
        while (possible > 0) {
            int i = possible & (-possible);
            possible = possible & (possible - 1);
            dfs_2(index + 1, target, col_num | i, (top_left_num | i) << 1, (top_right_num | i) >> 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new TotalNQueens().optimize(4));
    }
}


