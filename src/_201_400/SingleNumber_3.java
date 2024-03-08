package _201_400;

//260.只出现一次的数字III
/*给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。

你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。*/
//思路:按照之前的思路,用异或运算 出现两次的都会抵消 所以如果过一次 得到的是两个数的异或的结果
//用x&(-x)取得异或结果x的最后一位1 假设在l位 那么两个数a和b在l位肯定一个是0 一个是1
//于是根据l位是1还是0将nums分成两个部分 那么a和b肯定分别在两个部分 而且出现两次的元素肯定都在同一部分
//两个部分分别异或就是结果
public class SingleNumber_3 {
    public int[] singleNumber(int[] nums) {
        int[] re = new int[2];
        int num = 0, cut;
        for (int i : nums) {
            num ^= i;
        }
        cut = num & (-num);
        for (int i : nums) {
            if ((i & cut) == 0) {
                re[0] ^= i;
            }
        }
        re[1] = re[0] ^ num;
        return re;
    }

}
