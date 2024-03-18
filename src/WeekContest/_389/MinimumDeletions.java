package WeekContest._389;

import org.junit.Test;

import java.util.*;

//100255.成为 K 特殊字符串需要删除的最少字符数
/*给你一个字符串 word 和一个整数 k。

如果 |freq(word[i]) - freq(word[j])| <= k 对于字符串中所有下标 i 和 j  都成立，则认为 word 是 k 特殊字符串。

此处，freq(x) 表示字符 x 在 word 中的出现频率，而 |y| 表示 y 的绝对值。

返回使 word 成为 k 特殊字符串 需要删除的字符的最小数量。*/
public class MinimumDeletions {

    public int minimumDeletions(String word, int k) {
        int[] counts = new int[26];
        int sum = word.length(), number = 0, re = 0;
        List<Integer> list = new ArrayList<>();
        for (char c : word.toCharArray()) {
            if (counts[c - 'a'] == 0) number++;
            counts[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                list.add(counts[i]);
            }
        }
        Collections.sort(list);
        int left = 0, right = list.size() - 1;
        while (list.get(right) - list.get(left) > k) {
            while (list.get(right) * number - sum > sum - list.get(left) * number) {
                re++;
                list.set(right, list.get(right) - 1);
                sum--;
                if (list.get(right) == 0) {
                    number--;
                    right--;
                }
                if (list.get(right) - list.get(left) <= k) {
                    break;
                }
            }
            if (list.get(right) - list.get(left) <= k) break;
            while (list.get(right) * number - sum < sum - list.get(left) * number) {
                re++;
                list.set(left, list.get(left) - 1);
                sum--;
                if (list.get(left) == 0) {
                    number--;
                    left++;
                }
                if (list.get(right) - list.get(left) <= k) {
                    break;
                }
            }
            if (list.get(right) - list.get(left) <= k) break;
            if (list.get(right) * number - sum == sum - list.get(left) * number) {
                if (list.get(right) - list.get(left) - k > list.get(left)) {
                    re++;
                    sum--;
                    list.set(left, list.get(left) - 1);
                    if (list.get(left) == 0) {
                        number--;
                        left++;
                    }
                } else {
                    re++;
                    sum--;
                    list.set(right, list.get(right) - 1);
                    if (list.get(right) == 0) {
                        number--;
                        right--;
                    }
                }
            }

        }
        return re;
    }

    @Test
    public void test() {
        minimumDeletions("yynaayyyy", 1);
    }
}

