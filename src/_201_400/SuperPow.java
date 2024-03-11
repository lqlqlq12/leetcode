package _201_400;

//327.超级次方
/*你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。*/
//借鉴50.快速幂
//(a*b)%c=((a%c)*(b%c))%c
public class SuperPow {

    public int superPow(int a, int[] b) {
        int len = b.length;
        int ans = 1;
        a %= 1337;
        for (int i = len - 1; i >= 0; i--) {
            ans = ans * pow(a, b[i]) % 1337;
            a = pow(a, 10);
        }
        return ans;
    }

    public int pow(int x, int n) {
        int re = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                re = re * x % 1337;
            }
            x = x * x % 1337;
            n /= 2;
        }
        return re;
    }
}
