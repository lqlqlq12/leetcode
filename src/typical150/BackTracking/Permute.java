package typical150.BackTracking;

import java.util.ArrayList;
import java.util.List;

//46.全排列
/*给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。*/
//回溯呗
public class Permute {
    int[] nums;
    List<List<Integer>> re;
    List<Integer> t;

    public List<List<Integer>> permute(int[] nums) {
        re = new ArrayList<>();
        t = new ArrayList<>();
        this.nums = nums;
        backTrack(new boolean[nums.length], 0);
        return re;
    }

    public void backTrack(boolean[] visited, int count) {
        if (count == nums.length) {
            re.add(new ArrayList<>(t));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                t.add(nums[i]);
                backTrack(visited, count + 1);
                visited[i] = false;
                t.remove(t.size() - 1);
            }
        }
    }
}
