package leetcode75.BackTrack;

import java.util.ArrayList;
import java.util.List;

//216.组合总和III
/*找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：

只使用数字1到9
每个数字 最多使用一次
返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。*/
//回溯
public class CombinationSum3 {
    int k, n;
    List<List<Integer>> re;
    int[] arr;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        re = new ArrayList<>();
        arr = new int[k];
        backTrack(0, 0, 0);
        return re;
    }

    public void backTrack(int sum, int times, int number) {
        if (times == k) {
            if (sum == n) {
                List<Integer> t = new ArrayList<>();
                for (int i = 0; i < k; i++) {
                    t.add(arr[i]);
                }
                re.add(t);
            }
            return;
        }
        for (int i = number + 1; i <= 9 && sum + i <= n; i++) {
            arr[times] = i;
            backTrack(sum + i, times + 1, i);
        }
    }

    public void test() {
        combinationSum3(3, 7);
    }

    public static void main(String[] args) {
        new CombinationSum3().test();
    }
}

