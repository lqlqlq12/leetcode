package leetcode75.Graph;

import java.util.LinkedList;
import java.util.Queue;

//994.腐烂的橘子
/*在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：

值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。

返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。*/
//思路:bfs
public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, re = -1, sum = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    sum++;
                }
            }
        }
        while (!queue.isEmpty()) {
            re++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0], y = poll[1];
                if (x > 0 && grid[x - 1][y] == 1) {
                    sum--;
                    grid[x - 1][y] = 0;
                    queue.offer(new int[]{x - 1, y});
                }
                if (y > 0 && grid[x][y - 1] == 1) {
                    sum--;
                    grid[x][y - 1] = 0;
                    queue.offer(new int[]{x, y - 1});
                }
                if (x < m - 1 && grid[x + 1][y] == 1) {
                    sum--;
                    grid[x + 1][y] = 0;
                    queue.offer(new int[]{x + 1, y});
                }
                if (y < n - 1 && grid[x][y + 1] == 1) {
                    sum--;
                    grid[x][y + 1] = 0;
                    queue.offer(new int[]{x, y + 1});
                }
            }

        }
        if (sum != 0) {
            return -1;
        }
        return re == -1 ? 0 : re;
    }
}
