package _1_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//40.组合总和II
/*给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用 一次 。

注意：解集不能包含重复的组合。 */
//思路:回溯
public class CombinationSum2 {

    List<List<Integer>> re;
    List<Integer> t;
    int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        Arrays.sort(candidates);
        re = new ArrayList<>();
        t = new ArrayList<>();
        backTrack(0, target);
        return re;
    }

    public void backTrack(int index, int remain) {
        if (remain == 0) {
            re.add(new ArrayList<>(t));
        }
        for (int i = index; i < candidates.length && remain >= candidates[i]; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            t.add(candidates[i]);
            backTrack(i + 1, remain - candidates[i]);
            t.remove(t.size() - 1);
        }
    }

    //1 1 2 5 6 7 10
    public void test() {
        combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    public static void main(String[] args) {
        new CombinationSum2().test();
    }
}
