package typical150.HashMap;

import java.util.HashMap;
import java.util.Map;

//同构字符串
/*给定两个字符串 s 和 t ，判断它们是否是同构的。

如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。

每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。*/
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        if (sLen != tLen) {
            return false;
        }
        Map<Character, Character> ts = new HashMap<>();
        Map<Character, Character> st = new HashMap<>();
        for (int i = 0; i < sLen; i++) {
            if(ts.containsKey(tArr[i])&&!ts.get(tArr[i]).equals(sArr[i])){
                return false;
            }
            if(st.containsKey(sArr[i])&&!st.get(sArr[i]).equals(tArr[i])){
                return false;
            }
            st.put(sArr[i],tArr[i]);
            ts.put(tArr[i],sArr[i]);
        }
        return true;
    }
}
