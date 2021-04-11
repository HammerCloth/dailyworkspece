package flect;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * 在运行时，能够创建任意引用类型的对象
 * 步骤
 * 1. 获取某个类型的class对象
 *
 * @author:syx
 * @date: 2021/4/2 16:29
 * @version:v1.0
 */
public class TestNewInstance {
    Class clazz;
    @Before
    /**
     * 使用class对象直接new对象
     */
    public void test01() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //获取对象
        Properties pro = new Properties();
        pro.load(TestNewInstance.class.getClassLoader().getResourceAsStream("flect/config/bean.properties"));
        String className = pro.getProperty("className");
        clazz = Class.forName(className);
        //通过class对象，来创建class所代表的类型的对象
        /**
         * obj的编译时类型时Object
         * obj的运行是类型是你所认为应该是的那个
         * 当没有无参数构造器时会报错
         */
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }
    /**
     * 使用class对象先获取有参数构造器，然后再创建对象
     * 步骤：
     * 1.获取某个类型的对象
     * 2.通过class获取Construcutor对象
     * 3.通过Construcutor获取实例
     */
    @Test
    public void test02() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor c = clazz.getConstructor(String.class,int.class,String.class,int.class);
        Object o = c.newInstance("aa",14,"sdj",15);//需要参数
    }
}
