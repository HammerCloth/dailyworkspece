package cn.clazz;

import jdk.jfr.StackTrace;

import java.io.Serializable;

/**
 * 如何获取class对象
 * 1.类型名。class 要求编译期这个类型就要存在
 * 2.对象.getclass 返回对象的运行时类型
 * 3.class.forname(类型的全名称) 可以在编译期间未知，类名称可以在代码中出现，或者键盘输入等方式
 * 4. 使用类加载器对象去loadclass,一般使用自定义对象去加载指定路径下的类
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
