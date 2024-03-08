package hot100;

import java.util.ArrayList;
import java.util.List;


//51.N皇后
/*给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位*/
public class SolveNQueen {
    static List<List<String>> re;
    boolean[] col;
    boolean[] left_top;
    boolean[] right_top;

    public List<List<String>> solveNQueens(int n) {
        re = new ArrayList<>();
        col = new boolean[n];
        left_top = new boolean[2 * n - 1];
        right_top = new boolean[2 * n - 1];
        solve(0, n, new ArrayList<Integer>());
        return re;
    }

    public void solve(int i, int n, List<Integer> store) {
        if (store.size() == n) {
            List<String> strings = generateString(store, n);
            re.add(strings);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!col[j] && !left_top[i + n - 1 - j] && !right_top[i + j]) {
                col[j] = true;
                left_top[i + n - 1 - j] = true;
                right_top[i + j] = true;
                store.add(j);
                solve(i + 1, n, store);
                col[j] = false;
                left_top[i + n - 1 - j] = false;
                right_top[i + j] = false;
                store.remove(store.size() - 1);
            }
        }

    }

    public List<String> generateString(List<Integer> list, int n) {
        List<String> re = new ArrayList<>();
        for (Integer number : list) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(".");
            }
            sb.replace(number, number + 1, "Q");
            re.add(sb.toString());
        }
        return re;
    }

    public static void main(String[] args) {
        SolveNQueen solveNQueen = new SolveNQueen();
        solveNQueen.solveNQueens(4);
    }
}
