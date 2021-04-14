package cn.syx.seven;

import java.util.HashSet;
import java.util.Set;

/**
 * ÁĞ³öÀ¨ºÅ
 *
 * @author:syx
 * @date: 2021/4/12 21:08
 * @version:v1.0
 */
public class Case3 {
    public static void main(String[] args) {
        Set<String> result = f(2);
        for (String a:result){
            System.out.println(a);
        }
    }

    public static Set<String> f(int n) {
        Set<String> result = new HashSet<>();
        if (n == 1) {
            result.add("()");
            return result;
        }
        Set<String> up = f(n-1);
        for (String a:up){
            result.add("()"+a);
            result.add(a+"()");
            result.add("("+a+")");
        }
        return result;
    }
}
