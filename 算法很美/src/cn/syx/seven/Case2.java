package cn.syx.seven;

/**
 * 用硬币表示给定的数值
 *
 * @author:syx
 * @date: 2021/4/12 20:12
 * @version:v1.0
 */
public class Case2 {
    public static void main(String[] args) {
        for (int i = 0; i <= 50; i++) {
            if (i>=25){
                System.out.println(""+i+"--"+f(i, 3, new int[]{1, 5, 10, 25}));
            }else if(i>=10){
                System.out.println(""+i+"--"+f(i, 2, new int[]{1, 5, 10, 25}));
            }else if(i>=5){
                System.out.println(""+i+"--"+f(i, 1, new int[]{1, 5, 10, 25}));
            }else{
                System.out.println(""+i+"--"+f(i, 0, new int[]{1, 5, 10, 25}));
            }

        }
    }

    //25,10,5,1
    public static int f(int n, int max_coin, int[] a) {
        int res = 0;
        if (max_coin == 0) {
            res = 1;
            return res;
        }
        for (int i = 0; i * a[max_coin] <= n; i++) {
            res += f(n - i * a[max_coin], max_coin - 1, a);
        }
        return res;
    }
}
