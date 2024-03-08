package leetcode75.Graph;

import javax.xml.ws.EndpointReference;
import java.util.LinkedList;
import java.util.Queue;

//1926.迷宫中离入口最近的出口
/*给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。
同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。

每一步操作，你可以往 上，下，左 或者 右 移动一个格子。
你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。
出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。

请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。*/
//思路:广优先 且不重复访问 不要用boolean[][] 直接把访问过的变成'+'
public class NearestExit {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int num = 0;
        while (!queue.isEmpty()) {
            num++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0], y = pos[1];
                //上
                if (x > 0 && maze[x - 1][y] == '.') {
                    if (x == 1 || y == 0 || y == n - 1) return num;
                    queue.offer(new int[]{x - 1, y});
                    maze[x - 1][y] = '+';
                }
                //下
                if (x < m - 1 && maze[x + 1][y] == '.') {
                    if (x == m - 2 || y == 0 || y == n - 1) return num;
                    queue.offer(new int[]{x + 1, y});
                    maze[x + 1][y] = '+';
                }
                //左
                if (y > 0 && maze[x][y - 1] == '.') {
                    if (y == 1 || x == 0 || x == m - 1) return num;
                    queue.offer(new int[]{x, y - 1});
                    maze[x][y - 1] = '+';
                }
                //右
                if (y < n - 1 && maze[x][y + 1] == '.') {
                    if (y == n - 2 || x == 0 || x == m - 1) return num;
                    queue.offer(new int[]{x, y + 1});
                    maze[x][y + 1] = '+';
                }
            }
        }
        return -1;
    }
}
