package hot100;

import java.util.*;

//有效的括号
//直接使用栈 用实现了Deque接口的ArrayDeque或LinkedDeque,或继承Vector的Stack
public class IsValid {

    public boolean isValid(String s) {
        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Deque<Character> stack=new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        int length=charArray.length;
        for(int i=0;i<length;i++){
            char ch=charArray[i];
            //右括号
            if(map.containsKey(ch)){
                if(stack.isEmpty()||stack.peek()!=map.get(ch)){
                    return false;
                }
                stack.pop();
            }
            //左括号
            else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
