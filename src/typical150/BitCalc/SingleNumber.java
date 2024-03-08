package typical150.BitCalc;

//136.只出现一次的数字
/*给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。*/
//二刷了 位运算 两次的会抵消的 异或运算 相等为0 不等为1
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int re = 0;
        for (int i = 0; i < len; i++) {
            re = re ^ nums[i];
        }
        return re;
    }
}
