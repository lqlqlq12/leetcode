package hot100;

//划分字母区间
/*给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。

注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。

返回一个表示每个字符串片段的长度的列表。*/
//贪心

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> re=new ArrayList<>();
        int length=s.length();
        int[] lastIndex=new int[26];
        char[] charArray = s.toCharArray();
        //获取每个字母最后的出现位置
        for(int i=0;i<length;i++){
            lastIndex[charArray[i]-'a']=i;
        }
        for(int i=0,start=0,end=-1;i<length;i++){
            char c=charArray[i];
            end=Math.max(end,lastIndex[c-'a']);
            if(i==end){
                re.add(end-start+1);
                end=-1;
                start=i+1;
            }
        }
        return re;
    }
}
