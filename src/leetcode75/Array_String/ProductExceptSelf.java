package leetcode75.Array_String;

import java.net.PortUnreachableException;

//283.除自身以外数组的乘积
/*给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。

题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

请 不要使用除法，且在 O(n) 时间复杂度内完成此题。*/
/*进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）*/
//思路:两次遍历 第一次只算左前缀 倒序遍历左右相乘,第一次遍历得到的做前缀暂时存到到结果数组里
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        for (int i = 0, product = 1; i < len; i++) {
            answer[i] = product;
            product *= nums[i];
        }
        for (int i = len - 1, product = 1; i >= 0; i--) {
            answer[i] *= product;
            product *= nums[i];
        }
        return answer;
    }
}
