package typical150.Trie;

import java.util.*;

//单词搜索II 单词搜索在hot100 Exist
/*给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。

单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。*/
//单词搜索1用的是dfs 这道题评论都用前缀树 不知道为什么 但也不是没做过前缀树
//小优化:将匹配的单词删除 这样也不会有重复的情况
//再优化:将原来穿visited参数的方式换成将board[i][j]改为'#'的方式 调用完再变回去
//再再优化:不用StringBuilder 将字符串保存到树的节点里
public class FindWords_2 {

    private class Node {
        boolean isEnd;
        Node[] child;
        String word;

        public Node() {
            isEnd = false;
            child = new Node[26];
        }

        public void insert(String words) {
            Node node = this;
            char[] charArray = words.toCharArray();
            int index = 0, len = charArray.length;
            while (index < len && node.child[charArray[index] - 'a'] != null) {
                node = node.child[charArray[index] - 'a'];
                index++;
            }
            while (index < len) {
                int t = charArray[index] - 'a';
                node.child[t] = new Node();
                node = node.child[t];
                index++;
            }
            node.isEnd = true;
            node.word = words;
        }
    }

    Node trie;
    List<String> re;
    char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        re = new ArrayList<>();
        trie = new Node();
        this.board = board;
        int m = board.length, n = board[0].length;
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (trie.child[c - 'a'] != null) {
                    board[i][j] = '#';
                    dfs(trie.child[c - 'a'], i, j);
                    board[i][j] = c;
                }
            }
        }
        return re;
    }

    public boolean dfs(Node node, int x, int y) {
        if (x > 0 && board[x - 1][y] != '#' && node.child[board[x - 1][y] - 'a'] != null) {
            char c = board[x - 1][y];
            board[x - 1][y] = '#';
            if (dfs(node.child[c - 'a'], x - 1, y))
                node.child[c - 'a'] = null;
            board[x - 1][y] = c;
        }
        if (x < board.length - 1 && board[x + 1][y] != '#' && node.child[board[x + 1][y] - 'a'] != null) {
            char c = board[x + 1][y];
            board[x + 1][y] = '#';
            if (dfs(node.child[c - 'a'], x + 1, y))
                node.child[c - 'a'] = null;
            board[x + 1][y] = c;
        }
        if (y > 0 && board[x][y - 1] != '#' && node.child[board[x][y - 1] - 'a'] != null) {
            char c = board[x][y - 1];
            board[x][y - 1] = '#';
            if (dfs(node.child[c - 'a'], x, y - 1))
                node.child[c - 'a'] = null;
            board[x][y - 1] = c;
        }
        if (y < board[0].length - 1 && board[x][y + 1] != '#' && node.child[board[x][y + 1] - 'a'] != null) {
            char c = board[x][y + 1];
            board[x][y + 1] = '#';
            if (dfs(node.child[c - 'a'], x, y + 1))
                node.child[c - 'a'] = null;
            board[x][y + 1] = c;
        }
        if (node.isEnd) {
            node.isEnd = false;
            re.add(node.word);
            int i;
            for (i = 0; i < 26; i++) {
                if (node.child[i] != null) {
                    break;
                }
            }
            return i == 27;
        }
        return false;
    }

    public void test() {
        char[][] board = new char[][]{{'o', 'a', 'b', 'n'}, {'o', 't', 'a', 'e'}, {'a', 'h', 'k', 'r'}, {'a', 'f', 'l', 'v'}};
        String[] words = new String[]{"oa", "oaa"};
        List<String> words1 = findWords(board, words);
        for (String s : words1) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        new FindWords_2().test();
    }
}
