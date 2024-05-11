package _401_600;

import java.util.Comparator;
import java.util.PriorityQueue;

//407.接雨水II
/*给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。*/
public class TrapRainWater {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, 0, heightMap[i][0]});
            queue.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = visited[i][n - 1] = true;
        }
        for (int i = 1; i < n - 1; i++) {
            queue.offer(new int[]{0, i, heightMap[0][i]});
            queue.offer(new int[]{m - 1, i, heightMap[m - 1][i]});
            visited[0][i] = visited[m - 1][i] = true;
        }
        int ans = 0;
        int[] dx = new int[]{-1, 0, 0, 1}, dy = new int[]{0, 1, -1, 0};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i], ny = cur[1] + dy[i];
                if (nx > 0 && nx < m - 1 && ny > 0 && ny < n - 1 && !visited[nx][ny]) {
                    if (heightMap[nx][ny] < cur[2]) {
                        ans += cur[2] - heightMap[nx][ny];
                    }
                    queue.offer(new int[]{nx, ny, Math.max(cur[2], heightMap[nx][ny])});
                    visited[nx][ny] = true;
                }
            }
        }
        return ans;
    }
}
