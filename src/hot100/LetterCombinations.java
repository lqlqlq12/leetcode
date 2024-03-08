package hot100;

import java.util.*;

/*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母*/
//电话号码的字母组合
public class LetterCombinations {
    Map<Character, String> map;
    List<String> re;
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.isEmpty()){
            return new ArrayList<>();
        }
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        Queue<String> queue=new ArrayDeque<>();
        int index=0;
        queue.offer(null);
        while(!queue.isEmpty()&&index<digits.length()){
            char[] chars = map.get(digits.charAt(index++)).toCharArray();
            for(int count=queue.size();count>0;count--){
                String before=queue.poll();
                for (char c : chars) {
                    queue.offer(before+c);
                }
            }
        }
        return new ArrayList<>(queue);
    }

    public List<String>letterCombinations_1(String digits){
        if(digits==null||digits.isEmpty()){
            return new ArrayList<>();
        }
        map = new HashMap<>();
        re=new ArrayList<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backTracking(0,digits,new StringBuilder());
        return re;
    }

    public void backTracking(int index,String digits,StringBuilder stringBuilder){
        if(index==digits.length()){
            re.add(stringBuilder.toString());
            return;
        }
        char[] chars = map.get(digits.charAt(index)).toCharArray();
        for(int i=0;i<chars.length;i++){
            stringBuilder.append(chars[i]);
            backTracking(index+1,digits,stringBuilder);
            stringBuilder.deleteCharAt(index);
        }
    }

}
