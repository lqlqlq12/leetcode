package typical150.Array_String;

//加油站
/*在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。*/
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len=gas.length;
        int index=0;
        int remain=gas[len-1]-cost[len-1],min=remain;
        for(int i=1;i<len;i++){
            int t=remain+gas[i-1]-cost[i-1];
            if(t<min){
                index=i;
                min=t;
            }
            remain=t;
        }
        if(remain<0){
            return -1;
        }
        for(int i=index,sum=0;;i++){
            sum+=(gas[i]-cost[i]);
            if(sum<0){
                return -1;
            }
            if(i==len-1){
                i=-1;
            }
            if(i==index-1){
                break;
            }
        }
        return index;
    }

    public void test(){
        int[] gas=new int[]{3,1,1};
        int[] cost=new int[]{1,2,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    public static void main(String[] args) {
        new CanCompleteCircuit().test();
    }
}
