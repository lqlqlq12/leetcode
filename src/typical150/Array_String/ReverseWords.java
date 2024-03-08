package typical150.Array_String;

import Verify.A;

import java.util.*;

//反转字符串的单词
/*给你一个字符串 s ，请你反转字符串中 单词 的顺序。

单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。

返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。

注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。

返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。*/
//用java的api
//用栈
public class ReverseWords {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    public String byStack(String s){
        char[] charArray = s.toCharArray();
        int len=charArray.length;
        Deque<String> stack=new ArrayDeque<>();
        int left,right;
        for(left=0,right=0;right<len;right++){
            if(!Character.isLetter(charArray[right])&&!Character.isDigit(charArray[right])){
                if(left==right){
                    left=right+1;
                }
                else{
                    stack.push(s.substring(left,right));
                    left=right+1;
                }
            }
        }
        if(right>left){
            stack.push(s.substring(left,right));
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            String str = stack.pop();
            sb.append(str).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
