package cn.syx.five;

/**
 * @author:syx
 * @date:2021/4/10 20:07
 * @version:v1.0
 */
public class RabinKarp {
    private static int seed = 31;
    public static void main(String[] args){
        String a = "ABABABA";
        String b = "ABA";
        match(b,a);
    }

    /**
     *
     * @param a ģʽ
     * @param b Դ��
     */
    public static void match(String a,String b){
        long target = hash(a);
        for (int i=0;i+a.length()<=b.length();i++){
            String pv = b.substring(i,i+a.length());
            if(target==hash(pv)){
                System.out.println("match"+i);
            }
        }
    }

    /**
     *
     * @param s �ַ���
     * @return �ַ�����Ӧ��hash��
     */
    private static long hash(String s) {
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = seed * hash + s.charAt(i);
        }
        return hash % Long.MAX_VALUE;
    }
}
