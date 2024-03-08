package typical150.Array_String;

//238.除自身以外数组的乘积
/*给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。

题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

请 不要使用除法，且在 O(n) 时间复杂度内完成此题。*/
//思路:之前做过 可以用left[] and right[] 来存储这个元素的左边和右边的乘积 总共遍历三次 O(3n)=O(n) 额外空间O(2n)
//而且空间可以优化 先遍历一次得到right[i] 然后第二次遍历得到left[i]的时候计算left[i]*right[i] 这样空间O(2n)空间只要O(n)
//上面的空间复杂度还可以优化 将right[i]的结果暂存到re[]里 实现空间O(1)
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] right = new int[len];
        int[] re = new int[len];
        for (int i = len - 1, multi = 1; i >= 0; i--) {
            right[i] = multi;
            multi *= nums[i];
        }
        for (int i = 0, multi = 1; i < len; i++) {
            re[i] = multi * right[i];
            multi *= nums[i];
        }
        return re;
    }

    public int[] optimize(int[] nums) {
        int len = nums.length;
        int[] re = new int[len];
        for (int i = len - 1, multi = 1; i >= 0; i--) {
            re[i] = multi;
            multi *= nums[i];
        }
        for (int i = 0, multi = 1; i < len; i++) {
            re[i] *= multi;
            multi *= nums[i];
        }
        return re;
    }
}
