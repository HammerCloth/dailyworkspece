package flect;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 创建对象后，再运行时为任意属性赋值；
 * 建议大家编写类时保留无参数构造
 * 反射创建也方便
 * 1.先获取属性对象
 *
 * @author:syx
 * @date: 2021/4/2 17:05
 * @version:v1.0
 */
public class TestFiled {
    Class clazz;

    @Test
    public void test01() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Properties pro = new Properties();
        pro.load(TestNewInstance.class.getClassLoader().getResourceAsStream("flect/config/bean.properties"));
        String className = pro.getProperty("className");
        clazz = Class.forName(className);
        Object obj = clazz.newInstance();
        Field f = clazz.getDeclaredField("id");
        f.setAccessible(true);
        f.set(obj, 14);
        int s = (int) f.get(obj);
        Method method = clazz.getDeclaredMethod("setId",int.class);
        method.invoke(obj,15);
    }
}
