package typical150.HashMap;

import java.util.HashMap;
import java.util.Map;

//383.赎金信
/*给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

如果可以，返回 true ；否则返回 false 。

magazine 中的每个字符只能在 ransomNote 中使用一次。*/
//都由小写英文字母组成
//思路:直接用magazine构建hashmap 然后针对ransomNote对hashmap减value
//优化:只有小写字母 用一个char数组代替HashMap
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            int remain = map.getOrDefault(c, 0);
            if (remain == 0) {
                return false;
            }
            map.put(c, remain - 1);
        }
        return true;
    }

    public boolean optimize(String ransomNote, String magazine) {
        char[] arr = new char[26];
        for (char c : magazine.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (arr[c - 'a'] == 0) {
                return false;
            }
            arr[c - 'a']--;
        }
        return true;
    }

}
