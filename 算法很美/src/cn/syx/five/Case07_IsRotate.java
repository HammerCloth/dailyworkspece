package cn.syx.five;

import org.junit.Test;

/**
 * ÅÐ¶Ïa´®ÊÇ·ñÎªB´®µÄÐý×ª×Ö·û´®
 *
 * @author:syx
 * @date:2021/4/9 18:59
 * @version:v1.0
 */
//test
public class Case07_IsRotate {
    public static boolean isRotate(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        boolean flag = false;
        StringBuffer sb = new StringBuffer(a + b);
        flag = sb.toString().contains(a);
        return flag;
    }

    @Test
    public void test() {
        String a = "";
        String[] b = a.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = b.length - 1; i >= 0; i--) {
            sb.append(b[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
    @Test
    public void test2(){
        String tenet = "";
        StringBuffer sb = new StringBuffer(tenet);
        sb = sb.reverse();
        System.out.println(tenet.equals(sb.toString()));
    }


}
