package hot100;

//爬楼梯
/*假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？*/

//直接递归 a(n)=a(n-1)+a(n-2); 递归超时，用迭代
/*递归的通项公式,f(n)=f(n-1)+f(n-2)
* 特征方程为x^2+x=1,解的x1,x2
* 通解为f(n)=c1x1^n+c2x2^n 带入f(1),f(2)，解得c1,c2
* 得到通解*/
public class ClimbStairs {
    public int climbStairs(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int re=0,p=1,q=2;
        for(int i=3;i<=n;i++){
            re=p+q;
            p=q;
            q=re;
        }
        return re;
    }

}
