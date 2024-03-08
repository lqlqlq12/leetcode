package typical150.HashMap;

//242.有效的字母异位词
/*给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词*/
//进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
//思路:考的哈希表 但借于s 和 t 仅包含小写字母 可以用一个数组代替 s加 t减 最后数组全为0就true
//如果有unicode 就不能用数组了 就得用hashMap了
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        int count = 0;
        for (char c : s.toCharArray()) {
            if (arr[c - 'a'] == 0) {
                count++;
            }
            arr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            arr[c - 'a']--;
            if (arr[c - 'a'] == 0) {
                count--;
            } else if (arr[c - 'a'] == -1) {
                return false;
            }
        }
        return count == 0;
    }
}
