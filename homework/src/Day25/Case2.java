package Day25;

import org.junit.jupiter.api.Test;

/**
 * 1������һ������ʽ�ӿ�IntCalc,���г��󷽷�int cal(int a , int b)��ʹ��ע��@FunctionalInterface
 * 2���ڲ������ж���public static void getProduct(int a , int b ,IntCalc tools), �÷�����Ԥ����Ϊ��ӡʹ��tools��cal(a,b)�ļ�����
 * 3������getProduct(),ͨ��lambda���ʽ�����������a =1,b = 2
 * ��1��ʵ��һ����a,b�ĺ�
 * ��2��ʵ�ֶ�����a,b�Ĳ�
 * ��3��ʵ��������a,b�Ļ�
 * ��4��ʵ���ģ���a,b����
 * ��5��ʵ���壺��a,b�İ�λ��
 * ��6��ʵ��������a<<b
 * @author:syx
 * @date: 2021/4/20 11:40
 * @version:v1.0
 */
public class Case2 {
    /**
     * 3������getProduct(),ͨ��lambda���ʽ�����������a =1,b = 2
     *  * ��1��ʵ��һ����a,b�ĺ�
     *  * ��2��ʵ�ֶ�����a,b�Ĳ�
     *  * ��3��ʵ��������a,b�Ļ�
     *  * ��4��ʵ���ģ���a,b����
     *  * ��5��ʵ���壺��a,b�İ�λ��
     *  * ��6��ʵ��������a<<b
     */
    @Test
    public void test(){
        getProduct(1,2,(a,b)->a+b);
        getProduct(1,2,(a,b)->a-b);
        getProduct(1,2,(a,b)->a*b);
        getProduct(1,2,(a,b)->a/b);
        getProduct(1,2,(a,b)->a&b);
        getProduct(1,2,(a,b)->a<<b);


    }
    /**
     * �ڲ������ж���public static void getProduct(int a , int b ,IntCalc tools),
     * �÷�����Ԥ����Ϊ��ӡʹ��tools��cal(a,b)�ļ�����
     */
    public static void getProduct(int a,int b,IntCalc tools){
        System.out.println(tools.cal(a,b));
    }
}
/**
 * 1������һ������ʽ�ӿ�IntCalc,
 * ���г��󷽷�int cal(int a , int b)��ʹ��ע��@FunctionalInterface
 */
@FunctionalInterface
interface IntCalc{
    int cal(int a,int b);
}