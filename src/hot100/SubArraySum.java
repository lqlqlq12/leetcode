package hot100;

//和为k的子数组
/*给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

子数组是数组中元素的连续非空序列*/
//一眼动规 dp[i][j] 以nums[i]结尾的和为j的子数组的个数
// dp[i][j]= dp[i-1][j-nums[i]]

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//方法一：枚举 用dp[i][j] 表示nums[i:j]的子数组的和 O(n^2)
//方法二：前缀和+hashMap prefix[i]=sum(nums[0:i]) total(map.get(k-prefix[j]))
// map<key,value> key是前缀和 value是能求和为key的前面的子数组的个数 O(n)
public class SubArraySum {

    //二维数组超内存限制
    public int meiJu(int[] nums, int k) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
            if (nums[i] == k)
                count++;
        }
        //遍历子数组长度
        for (int subLen = 2; subLen <= len; subLen++) {
            //遍历起点
            for (int i = 0; i + subLen <= len; i++) {
                int j = i + subLen - 1;
                dp[i][j] = dp[i][j - 1] + nums[j];
                if (dp[i][j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //一维数组 dp[i]以i为起点 击败5%，太烂
    public int meiJu_1(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = nums[i];
            if (nums[i] == k)
                count++;
        }
        //遍历子数组长度
        for (int subLen = 2; subLen <= len; subLen++) {
            //遍历起点
            for (int i = 0; i + subLen <= len; i++) {
                int j = i + subLen - 1;
                dp[i] = dp[i] + nums[j];
                if (dp[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public int prefixSum(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0,1);
        for (int i = 0, sum = 0; i < len; i++) {
            sum += nums[i];
            if(map.containsKey(k-sum)){
                count+=map.get(k-sum);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }

}
