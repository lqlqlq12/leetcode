package hot100;

import java.util.ArrayDeque;
import java.util.Queue;

//腐烂的橘子
/*在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：

值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。

返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。*/
//一眼bfs
public class OrangeRotting {
    public int orangeRotting(int[][] grid) {
        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        int minute = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            minute++;
            for (int i = 0; i < size; i++) {
                int[] ints = queue.poll();
                int x = ints[0], y = ints[1];
                if (x > 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    fresh--;
                    queue.offer(new int[]{x - 1, y});
                }
                if (x < m - 1 && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    fresh--;
                    queue.offer(new int[]{x + 1, y});
                }
                if (y > 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    fresh--;
                    queue.offer(new int[]{x, y - 1});
                }
                if (y < n - 1 && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    fresh--;
                    queue.offer(new int[]{x, y + 1});
                }
            }
        }
        if (fresh != 0) {
            return -1;
        }
        return minute;
    }
}
