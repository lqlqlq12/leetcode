package typical150.Graph;

//200.岛屿数量
/*给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围*/
//思路 使用dfs将岛屿的1置为0
public class NumIslands {
    char[][] grid;
    int m, n;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        int re = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    re++;
                    dfs(i, j);
                }
            }
        return re;
    }

    public void dfs(int x, int y) {
        grid[x][y] = '0';
        if (x > 0 && grid[x - 1][y] == '1') {
            dfs(x - 1, y);
        }
        if (x < m - 1 && grid[x + 1][y] == '1') {
            dfs(x + 1, y);
        }
        if (y > 0 && grid[x][y - 1] == '1') {
            dfs(x, y - 1);
        }
        if (y < n - 1 && grid[x][y + 1] == '1') {
            dfs(x, y + 1);
        }
    }

}
