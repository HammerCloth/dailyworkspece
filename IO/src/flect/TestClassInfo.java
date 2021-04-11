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
 * ������ʱ��ȡ��ϸ��Ϣ
 * ���ڵ�ʱ���ڿ���У�spring��ܣ�������ǹ���ܶ���
 * ��Щ�಻��springд�ģ���������д�ģ��������ڼ�spring���ػ�ȡ��
 * ����
 * 1. ��ȡ������class����
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
        //�����������������ļ��У��Ȼ�ȡ����
        Properties pro = new Properties();
        pro.load(TestClassInfo.class.getClassLoader().getResourceAsStream("flect/config/bean.properties"));
        String className = pro.getProperty("className");
        //��ȡclass����
        clazz = Class.forName(className);
        System.out.println(clazz);
    }

    @Test
    public void test2() {
        //��ȡ�����ϸ��Ϣ
        //clazz����������
        //��ȡ����
        Package pkg = clazz.getPackage();
        System.out.println(pkg.getName());
        //��ȡ����
        System.out.println(clazz.getName());
        //������η�
        int mod = clazz.getModifiers();
        System.out.println("���η���ֵ:" + mod);
        System.out.println("���η�:" + Modifier.toString(mod));
        //��ĸ���
        Class fu = clazz.getSuperclass();
        System.out.println("��������ƣ�" + fu.getName());
        //ʵ�ֵĽӿ�
        System.out.println("ʵ�ֵĽӿڣ�");
        Class[] intes = clazz.getInterfaces();
        for (Class inter : intes) {
            System.out.println(inter.getName());
        }
        //public����
        System.out.println("public���ԣ�");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //����������
        System.out.println("�������ԣ�");
        Field[] dfields = clazz.getDeclaredFields();
        for (Field field : dfields) {
            System.out.println(field);
        }
        //�����Ĺ�����
        System.out.println("�����Ĺ�������");
        Constructor[] cs = clazz.getDeclaredConstructors();
        for (Constructor c : cs) {
            System.out.println(Arrays.toString(c.getParameterTypes()));
        }
        //������
        System.out.println("����:");
        Method[] ms = clazz.getDeclaredMethods();
        for (Method m : ms) {
            System.out.println(m.getName());
        }

    }
}
