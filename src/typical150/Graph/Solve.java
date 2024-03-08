package typical150.Graph;

import java.util.ArrayList;
import java.util.List;

//被围绕的区域
/*给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，
并将这些区域里所有的 'O' 用 'X' 填充。*/
/*被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。*/
//思路 遇到'O'就开始dfs 将遍历的结果存到list 如果遍历的时候没有遍历到边界,则全部改为X 有点慢
//改进: 从边缘开始找'O'来遍历 最后被visited的都是不要改的 确实块多了 我真笨
public class Solve {
    char[][] board;
    boolean[][] visited;
    List<int[]> list;

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        this.board = board;
        list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    list.add(new int[]{i, j});
                    visited[i][j] = true;
                    if (!dfs(i, j)) {
                        for (int[] pos : list) {
                            board[pos[0]][pos[1]] = 'X';
                        }
                    }
                    list.clear();
                }
            }
        }
    }

    public void optimize(char[][] board) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        this.board = board;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                visited[i][0] = true;
                dfs_2(i, 0);
            }
            if (board[i][n - 1] == 'O' && !visited[i][n - 1]) {
                visited[i][n - 1] = true;
                dfs_2(i, n - 1);
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                visited[0][j] = true;
                dfs_2(0, j);
            }
            if (board[m - 1][j] == 'O' && !visited[m - 1][j]) {
                visited[m - 1][j] = true;
                dfs_2(m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs_2(int x, int y) {
        if (x > 0 && board[x - 1][y] == 'O' && !visited[x - 1][y]) {
            visited[x - 1][y] = true;
            dfs_2(x - 1, y);
        }
        if (y > 0 && board[x][y - 1] == 'O' && !visited[x][y - 1]) {
            visited[x][y - 1] = true;
            dfs_2(x, y - 1);
        }
        if (x < board.length - 1 && board[x + 1][y] == 'O' && !visited[x + 1][y]) {
            visited[x + 1][y] = true;
            dfs_2(x + 1, y);
        }
        if (y < board[0].length - 1 && board[x][y + 1] == 'O' && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            dfs_2(x, y + 1);
        }
    }

    public boolean dfs(int x, int y) {
        boolean re = false;
        if (x > 0 && board[x - 1][y] == 'O' && !visited[x - 1][y]) {
            visited[x - 1][y] = true;
            list.add(new int[]{x - 1, y});
            if (dfs(x - 1, y)) re = true;
        }
        if (y > 0 && board[x][y - 1] == 'O' && !visited[x][y - 1]) {
            visited[x][y - 1] = true;
            list.add(new int[]{x, y - 1});
            if (dfs(x, y - 1)) re = true;
        }
        if (x < board.length - 1 && board[x + 1][y] == 'O' && !visited[x + 1][y]) {
            visited[x + 1][y] = true;
            list.add(new int[]{x + 1, y});
            if (dfs(x + 1, y)) re = true;
        }
        if (y < board[0].length - 1 && board[x][y + 1] == 'O' && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            list.add(new int[]{x, y + 1});
            if (dfs(x, y + 1)) re = true;
        }
        if (x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1) {
            return true;
        }
        return re;
    }
}
