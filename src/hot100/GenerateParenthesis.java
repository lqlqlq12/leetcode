package hot100;

import javafx.beans.binding.StringBinding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//括号生成
/*数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合*/
//有效:第一个是( 往后任意位置都有(的数量>=)的数量 就有效可以继续下去 最后二者相等
//一眼递归! 太暴力 不太好
//递归改进 回溯
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> re = new ArrayList<>();
        if (n == 0) {
            return re;
        }
        if (n == 1) {
            re.add("()");
            return re;
        }
        //括号内有几对
        for (int i = 0; i < n; i++) {

            //括号内的
            List<String> inner = generateParenthesis(i);

            //括号外的情况
            List<String> outer = generateParenthesis(n - i - 1);

            List<StringBuilder> t = new ArrayList<>();
            for (String s : inner) {
                StringBuilder sb = new StringBuilder("(");
                sb.append(s).append(")");
                t.add(sb);
            }
            if (inner.isEmpty()) {
                t.add(new StringBuilder("()"));
            }
            for (String string : outer) {
                for (StringBuilder builder : t) {
                    re.add(builder + string);
                }
            }
            if (outer.isEmpty()) {
                for (StringBuilder builder : t) {
                    re.add(String.valueOf(builder));
                }
            }
        }
        return re;
    }

    List<String> re;
    public List<String> func(int n){
        re=new ArrayList<>();
        recursion("",n,n);
        return re;
    }
    public void recursion(String str,int left,int right){
        if(left==0&&right==0){
            re.add(str);
            return;
        }
        if(left==right){
            recursion(str+"(",left-1,right);
        }
        else if(left<right){
            if(left>0){
                recursion(str+"(",left-1,right);
            }
            recursion(str+")",left,right-1);
        }
    }
}
