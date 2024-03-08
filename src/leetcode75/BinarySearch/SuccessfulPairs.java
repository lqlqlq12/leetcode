package leetcode75.BinarySearch;

import java.util.Arrays;

//2300.咒语和药水的成功对数
/*给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，

potions[j] 表示第 j 瓶药水的能量强度。

同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。

请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。*/
//思路:对potions排序 然后使用二分来查找
public class SuccessfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int len = spells.length;
        int[] re = new int[len];
        int poLen = potions.length;
        for (int i = 0; i < len; i++) {
            int left = 0, right = poLen - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if ((long) spells[i] * potions[mid] < success) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if ((long) spells[i] * potions[left] >= success) {
                re[i] = poLen - left;
            } else {
                re[i] = 0;
            }
        }
        return re;
    }
}
