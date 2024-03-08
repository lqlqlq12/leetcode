package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//杨辉三角
/*给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。*/
public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> re=new ArrayList<>();
        re.add(Arrays.asList(1));
        for(int i=0;i<numRows-1;i++){
            List<Integer> t=new ArrayList<>();
            t.add(1);
            List<Integer> upLine = re.get(re.size() - 1);
            for(int j=1;j<i+1;j++){
                t.add(upLine.get(j-1)+upLine.get(j));
            }
            t.add(1);
            re.add(t);
        }
        return re;
    }

    public static void main(String[] args) {
        Generate generate = new Generate();
        List<List<Integer>> generate1 = generate.generate(6);
        for (List<Integer> list : generate1) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

}
