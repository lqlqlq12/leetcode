package _1_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//47.全排列II
/*给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。*/
public class PermuteUnique {
    int[] nums;
    List<List<Integer>> re;
    List<Integer> t;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        re = new ArrayList<>();
        t = new ArrayList<>();
        backTrack(new boolean[nums.length]);
        return re;
    }

    public void backTrack(boolean[] used) {
        if (t.size() == nums.length) {
            re.add(new ArrayList<>(t));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                t.add(nums[i]);
                backTrack(used);
                used[i] = false;
                t.remove(t.size() - 1);
            }
        }
    }

    public void test() {
        permuteUnique(new int[]{1, 1, 2});
    }

    public static void main(String[] args) {
        new PermuteUnique().test();
    }
}
