package WeekContest._387;

//100234.在矩阵上写出字母 Y 所需的最少操作次数
/*给你一个下标从 0 开始、大小为 n x n 的矩阵 grid ，其中 n 为奇数，且 grid[r][c] 的值为 0 、1 或 2 。

如果一个单元格属于以下三条线中的任一一条，我们就认为它是字母 Y 的一部分：

从左上角单元格开始到矩阵中心单元格结束的对角线。
从右上角单元格开始到矩阵中心单元格结束的对角线。
从中心单元格开始到矩阵底部边界结束的垂直线。
当且仅当满足以下全部条件时，可以判定矩阵上写有字母 Y ：

属于 Y 的所有单元格的值相等。
不属于 Y 的所有单元格的值相等。
属于 Y 的单元格的值与不属于Y的单元格的值不同。
每次操作你可以将任意单元格的值改变为 0 、1 或 2 。返回在矩阵上写出字母 Y 所需的 最少 操作次数。*/
//思路:最终结果Y上的值只能是 0或1或2 那我每种情况都试一下 统计线上和线外的012个有多少
public class MinimumOperationsToWriteY {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int[] inner = new int[3];
        int[] outer = new int[3];
        int in = 3 * n + 1, out = n * n - in;
        int mid = n / 2;
        int re = 0;
        for (int i = 0; i <= mid; i++) {
            inner[grid[i][i]]++;
            inner[grid[i][n - i - 1]]++;
        }
        inner[grid[mid][mid]]--;
        for (int i = mid + 1; i < n; i++) {
            inner[grid[i][mid]]++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                outer[grid[i][j]]++;
            }
        }
        for (int i = 0; i < 3; i++) {
            outer[i] -= inner[i];
        }

        int t = 0;
        t += (in - inner[0]);
        if (outer[1] > outer[2]) {
            t += (out - outer[1]);
        } else {
            t += (out - outer[2]);
        }
        re = t;

        t = 0;
        t += (in - inner[1]);
        if (outer[0] > outer[2]) {
            t += (out - outer[0]);
        } else {
            t += (out - outer[2]);
        }
        re = Math.min(re, t);

        t = 0;
        t += (in -= inner[2]);
        if (outer[0] > outer[1]) {
            t += (out - outer[0]);
        } else {
            t += (out - outer[1]);
        }
        re = Math.min(re, t);
        return re;
    }
}
