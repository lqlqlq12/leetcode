package _1_200;

//38.外观数列
/*给定一个正整数 n ，输出外观数列的第 n 项。

「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。

你可以将其视作是由递归公式定义的数字字符串序列：

countAndSay(1) = "1"
countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。*/
//思路:看着是递归
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = countAndSay(n - 1);
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ) {
            char number = charArray[i];
            int j;
            for (j = i + 1; j < len && charArray[j] == charArray[j - 1]; j++) ;
            sb.append(j - i).append(number);
            i = j;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(3));
    }
}
