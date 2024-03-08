package leetcode75.Array_String;

import java.util.ArrayList;
import java.util.List;

//1431.拥有最多糖果的孩子
/*给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。

对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，
此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。*/
//水题
public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int len = candies.length;
        int max = candies[0];
        for (int i = 1; i < len; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        max -= extraCandies;
        List<Boolean> re = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (candies[i] >= max) {
                re.add(Boolean.TRUE);
            } else {
                re.add(Boolean.FALSE);
            }
        }
        return re;
    }

}
