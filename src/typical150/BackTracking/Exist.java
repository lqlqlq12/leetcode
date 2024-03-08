package typical150.BackTracking;

//79.单词搜索
/*给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。*/
//board 和 word 仅由大小写英文字母组成
//思路 用dfs,不用visited数组来记录哪些格子被访问了 直接将格子的值改成非字母的就可以
public class Exist {
    char[][] board;
    int m, n;
    char[] words;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.words = word.toCharArray();
        this.m = board.length;
        this.n = board[0].length;
        char start = words[0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == start) {
                    board[i][j] = '#';
                    if (dfs(i, j, 0)) return true;
                    board[i][j] = start;
                }
            }
        }
        return false;
    }

    public boolean dfs(int x, int y, int index) {
        if (index == words.length - 1)
            return true;
        char next = words[index + 1];
        if (x > 0 && board[x - 1][y] == next) {
            board[x - 1][y] = '#';
            if (dfs(x - 1, y, index + 1)) return true;
            board[x - 1][y] = next;
        }
        if (y > 0 && board[x][y - 1] == next) {
            board[x][y - 1] = '#';
            if (dfs(x, y - 1, index + 1)) return true;
            board[x][y - 1] = next;
        }
        if (x < m - 1 && board[x + 1][y] == next) {
            board[x + 1][y] = '#';
            if (dfs(x + 1, y, index + 1)) return true;
            board[x + 1][y] = next;
        }
        if (y < n - 1 && board[x][y + 1] == next) {
            board[x][y + 1] = '#';
            if (dfs(x, y + 1, index + 1)) return true;
            board[x][y + 1] = next;
        }
        return false;
    }
}
