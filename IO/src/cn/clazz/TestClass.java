package cn.clazz;

import jdk.jfr.StackTrace;

import java.io.Serializable;

/**
 * ��λ�ȡclass����
 * 1.��������class Ҫ�������������;�Ҫ����
 * 2.����.getclass ���ض��������ʱ����
 * 3.class.forname(���͵�ȫ����) �����ڱ����ڼ�δ֪�������ƿ����ڴ����г��֣����߼�������ȷ�ʽ
 * 4. ʹ�������������ȥloadclass,һ��ʹ���Զ������ȥ����ָ��·���µ���
 * @author:syx
 * @date: 2021/3/29 15:36
 * @version:v1.0
 */
public class TestClass {
    public static void main(String[] args) {
        Class c1 = "".getClass();


        Class c2 = int.class;
        Class c3 = void.class;
        Class c5 = String.class;
        Class c6 = TestClass.class;

        ClassLoader loader  = c6.getClassLoader();

        Class c7 = Serializable.class;
        Class c8 = Override.class;

        System.out.println(c1==c5);

    }
}
