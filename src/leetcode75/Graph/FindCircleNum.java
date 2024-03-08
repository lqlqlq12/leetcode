package leetcode75.Graph;

import java.util.LinkedList;
import java.util.Queue;

//547.省份数量
/*有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。

省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。

给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。

返回矩阵中 省份 的数量。*/
//就是找有几个连通集
//思路 用一个map key是城市 value是哪一个城市
//题解 dfs bfs
public class FindCircleNum {
    int n;
    int[][] isConnected;
    boolean[] visited;


    public int findCircleNum(int[][] isConnected) {
        this.n = isConnected.length;
        this.visited = new boolean[n];
        this.isConnected = isConnected;
        int re = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                re++;
                visited[i] = true;
                dfs(i);
            }
        }
        return re;
    }

    public void dfs(int start) {
        for (int i = 0; i < n; i++) {
            if (isConnected[start][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    public int bfs(int[][] isConnected) {
        int n = isConnected.length, num = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                num++;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int j = 0; j < size; j++) {
                        int point = queue.poll();
                        for (int k = 0; k < n; k++) {
                            if (isConnected[point][k] == 1 && !visited[k]) {
                                visited[k] = true;
                                queue.offer(k);
                            }
                        }
                    }
                }
            }
        }
        return num;
    }

}
