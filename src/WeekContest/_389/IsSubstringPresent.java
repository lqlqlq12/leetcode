package WeekContest._389;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//100248.字符串及其反转中是否存在同一子字符串
/*给你一个字符串 s ，请你判断字符串 s 是否存在一个长度为 2 的子字符串，在其反转后的字符串中也出现。

如果存在这样的子字符串，返回 true；如果不存在，返回 false 。*/
public class IsSubstringPresent {
    public boolean isSubstringPresent(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < len - 1; i++) {
            if (!map.containsKey(charArray[i + 1])) {
                map.put(charArray[i + 1], new HashSet<>());
            }
            if ((map.containsKey(charArray[i]) && map.get(charArray[i]).contains(charArray[i + 1])) || charArray[i] == charArray[i + 1]) {
                return true;
            }
            map.get(charArray[i + 1]).add(charArray[i]);
        }
        return false;
    }
}
