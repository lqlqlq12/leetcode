package _201_400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//368.最大整除子集
/*给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子
集中每一元素对 (answer[i], answer[j]) 都应当满足：
answer[i] % answer[j] == 0 ，或
answer[j] % answer[i] == 0
如果存在多个有效解子集，返回其中任何一个均可。*/
// i j k i%j==0||j%i==0
//先排序 从小大大 保留一个集合的最大的值val就可以 如果nums[i]%val==0 则将nums[i]加入 并且val=nums[i]
//直接回溯超时 试一下动规和记忆化
//dp[i]以i结尾的序列的最大子集size
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length, max = 1, maxIndex = 0;
        List<Integer> re = new ArrayList<>();
        int[] dp = new int[len], pre = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(pre, -1);
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] % nums[i] == 0) {
                    if (dp[i] + 1 > dp[j]) {
                        dp[j] = dp[i] + 1;
                        pre[j] = i;
                    }
                    if (dp[j] > max) {
                        max = dp[j];
                        maxIndex = j;
                    }
                }
            }
        }
        while (maxIndex != -1) {
            re.add(nums[maxIndex]);
            maxIndex = pre[maxIndex];
        }
        return re;
    }

    @Test
    public void test() {
        largestDivisibleSubset(new int[]{3, 4, 16, 8});
    }

}
