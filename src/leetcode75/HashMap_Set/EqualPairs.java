package leetcode75.HashMap_Set;

//2352.相等行列对
/*给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。

如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。*/
//思路:没有什么好的解法吧 直接暴力 O(n^3)
//官解:将行存到map里 然后遍历列 没啥好的 空间换时间而已
public class EqualPairs {
    public int equalPairs(int[][] grid) {
        int re = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k;
                for (k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j]) break;
                }
                if (k == n) {
                    re++;
                }
            }
        }
        return re;
    }
}
