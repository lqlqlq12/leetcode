package hot100;

//字符串解码
/*给定一个经过编码的字符串，返回它解码后的字符串。

        编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

        你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

        此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。*/
public class DecodeString {

    public static void main(String[] args) {
        String s="3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        StringBuilder sb=new StringBuilder();
        int index=0;
        for(;index<s.length();index++){
            int start = s.substring(index).indexOf('[')+index;
            if(Character.isDigit(s.charAt(index))){
                int num=Integer.parseInt(s.substring(index,start));
                int t=0;
                int i;
                for(i=start;i<s.length();i++){
                    if(s.charAt(i)=='['){
                        t++;
                    }
                    else if(s.charAt(i)==']'){
                        t--;
                    }
                    if(i!=start&&t==0){
                        break;
                    }
                }
                for(;num>0;num--){
                    sb.append(decodeString(s.substring(start+1,i)));
                }
                index=i;
            } else if (Character.isLetter(s.charAt(index))){
                sb.append(s.charAt(index));
            }
        }
        return sb.toString();
    }
}
