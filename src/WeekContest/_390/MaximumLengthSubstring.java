package WeekContest._390;

import org.junit.Test;

//100245.每个字符最多出现两次的最长子字符串
/*给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的 最大 长度。*/
public class MaximumLengthSubstring {
    public int maximumLengthSubstring(String s) {
        int re = 2;
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int[] counts = new int[26];
        int left = 0, right;
        //[left,right-1]
        for (right = 0; right < len; right++) {
            int index = charArray[right] - 'a';
            counts[index]++;
            if (counts[index] == 3) {
                break;
            }
        }
        re = Math.max(re, right - left);
        while (right < len) {
            while (charArray[left] != charArray[right]) {
                counts[charArray[left] - 'a']--;
                left++;
            }
            counts[charArray[left] - 'a']--;
            left++;
            right++;
            while (right < len) {
                int index = charArray[right] - 'a';
                counts[index]++;
                if (counts[index] == 3) {
                    break;
                }
                right++;
            }
            re = Math.max(re, right - left);
        }
        re = Math.max(re, right - left);
        return re;
    }

    @Test
    public void test() {
        maximumLengthSubstring("bcbbbcba");
    }
}
