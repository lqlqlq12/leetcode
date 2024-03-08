package hot100;

import java.util.*;

//49.字母异位词分组
/*给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的所有字母得到的一个新单词。*/
public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> re=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key=new String(charArray);
            if(!map.containsKey(key)){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }
            else{
                List<String> list = map.get(key);
                list.add(str);
                map.put(key,list);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            re.add(entry.getValue());
        }
        return re;
    }

}
