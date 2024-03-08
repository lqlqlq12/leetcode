package hot100;

//单词搜索 单词搜索II在typical150的FindWords_2
/*给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，
其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。*/
/*你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？*/
public class Exist {

    char[][] board;
    char[] words;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        this.board = board;
        this.words = word.toCharArray();
        char start = words[0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == start) {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    if (recursion(i, j, visited, 0))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean recursion(int i, int j, boolean[][] visited, int index) {
        if (index == words.length - 1) {
            return true;
        }
        if (i > 0 && !visited[i - 1][j] && board[i - 1][j] == words[index + 1]) {
            visited[i - 1][j] = true;
            if (recursion(i - 1, j, visited, index + 1)) {
                return true;
            }
            visited[i - 1][j] = false;
        }
        if (i < visited.length - 1 && !visited[i + 1][j] && board[i + 1][j] == words[index + 1]) {
            visited[i + 1][j] = true;
            if (recursion(i + 1, j, visited, index + 1)) {
                return true;
            }
            visited[i + 1][j] = false;
        }
        if (j > 0 && !visited[i][j - 1] && board[i][j - 1] == words[index + 1]) {
            visited[i][j - 1] = true;
            if (recursion(i, j - 1, visited, index + 1)) {
                return true;
            }
            visited[i][j - 1] = false;
        }
        if (j < visited[0].length - 1 && !visited[i][j + 1] && board[i][j + 1] == words[index + 1]) {
            visited[i][j + 1] = true;
            if (recursion(i, j + 1, visited, index + 1)) {
                return true;
            }
            visited[i][j + 1] = false;
        }
        return false;
    }
}
