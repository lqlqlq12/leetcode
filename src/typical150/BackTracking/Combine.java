package typical150.BackTracking;

import java.util.ArrayList;
import java.util.List;

//组合
/*给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。*/
//一眼回溯递归dfs剪枝
public class Combine {
    List<List<Integer>> re;
    List<Integer> t;

    public List<List<Integer>> combine(int n, int k) {
        re = new ArrayList<>();
        t = new ArrayList<>();
        recursion(1, n, k);
        return re;
    }

    public void recursion(int index, int n, int k) {
        if (t.size() == k) {
            re.add(new ArrayList<>(t));
            return;
        }
        for (int i = index; i <= n; i++) {
            if (n - i + t.size() + 1 < k) {
                break;
            }
            t.add(i);
            recursion(i + 1, n, k);
            t.remove(t.size() - 1);
        }
    }
}
