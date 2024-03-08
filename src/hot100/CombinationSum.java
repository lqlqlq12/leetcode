package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
对于给定的输入，保证和为 target 的不同组合数少于 150 个*/
//回溯
public class CombinationSum {
    List<List<Integer>> re;
    List<Integer> t;
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        re = new ArrayList<>();
        t = new ArrayList<>();
        this.candidates = candidates;
        backTrac(0, target);
        return re;
    }

    public void backTrac(int index, int target) {
        if (target == 0) {
            re.add(new ArrayList<>(t));
            return;
        }
        int len = candidates.length;
        for (int i = index; i < len; i++) {
            if (candidates[i] > target) {
                break;
            }
            t.add(candidates[i]);
            backTrac(i, target - candidates[i]);
            t.remove(t.size() - 1);
        }
    }
}
