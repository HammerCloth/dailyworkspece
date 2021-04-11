package flect;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.DatabaseMetaData;
import java.util.Arrays;
import java.util.Properties;

/**
 * 在运行时获取详细信息
 * 后期的时候，在框架中，spring框架，会帮我们管理很多类
 * 这些类不是spring写的，而是我们写的，在运行期间spring加载获取的
 * 步骤
 * 1. 获取这个类的class对象
 * 2.
 *
 * @author:syx
 * @date :2021/4/1 15:16
 * @version:v1.0
 */
public class TestClassInfo {
    private Class clazz;

    @Before
    public void Test() throws IOException, ClassNotFoundException {
        //如果这个类名在配置文件中，先获取类名
        Properties pro = new Properties();
        pro.load(TestClassInfo.class.getClassLoader().getResourceAsStream("flect/config/bean.properties"));
        String className = pro.getProperty("className");
        //获取class对象
        clazz = Class.forName(className);
        System.out.println(clazz);
    }

    @Test
    public void test2() {
        //获取类的详细信息
        //clazz代表整个类
        //获取包名
        Package pkg = clazz.getPackage();
        System.out.println(pkg.getName());
        //获取类名
        System.out.println(clazz.getName());
        //类的修饰符
        int mod = clazz.getModifiers();
        System.out.println("修饰符的值:" + mod);
        System.out.println("修饰符:" + Modifier.toString(mod));
        //类的父类
        Class fu = clazz.getSuperclass();
        System.out.println("父类的名称：" + fu.getName());
        //实现的接口
        System.out.println("实现的接口：");
        Class[] intes = clazz.getInterfaces();
        for (Class inter : intes) {
            System.out.println(inter.getName());
        }
        //public属性
        System.out.println("public属性：");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //声明的属性
        System.out.println("声明属性：");
        Field[] dfields = clazz.getDeclaredFields();
        for (Field field : dfields) {
            System.out.println(field);
        }
        //声明的构造器
        System.out.println("声明的构造器：");
        Constructor[] cs = clazz.getDeclaredConstructors();
        for (Constructor c : cs) {
            System.out.println(Arrays.toString(c.getParameterTypes()));
        }
        //方法们
        System.out.println("方法:");
        Method[] ms = clazz.getDeclaredMethods();
        for (Method m : ms) {
            System.out.println(m.getName());
        }

    }
}
