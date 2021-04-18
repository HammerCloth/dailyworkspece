package cn.syx.eight;

import org.junit.Test;

/**
 * 求两个数的最大公约数和最小公倍数
 * @author:syx
 * @date: 2021/4/17 15:50
 * @version:v1.0
 */
public class Case2 {
    @Test
    public void test01(){
        System.out.println(gcd(319,377));
    }

    /**
     * gcd
     * @param a
     * @param b
     * @return the biggest gcd
     */
    public static int gcd(int a,int b){
        int c=a%b;
        if(c==0){
            return b;
        }else{
            return gcd(b,c);
        }
    }

}

