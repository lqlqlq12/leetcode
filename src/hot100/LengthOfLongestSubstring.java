package hot100;

//无重复字符的最长字串
/*给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。*/
//滑动窗口


import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int len=charArray.length;
        int left=0,right=0;
        int re=0;
        Set<Character> set=new HashSet<>();
        for(int i=0;i<len;){
            if(!set.contains(charArray[i])){
                right++;
                set.add(charArray[i]);
                i++;
            }
            else{
                re=Math.max(re,right-left);
                set.remove(charArray[left]);
                left++;
            }
        }
        if(!set.isEmpty()){
            re=Math.max(re,set.size());
        }
        return re;
    }
}
