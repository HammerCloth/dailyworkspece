package flect;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * ������ʱ���ܹ����������������͵Ķ���
 * ����
 * 1. ��ȡĳ�����͵�class����
 *
 * @author:syx
 * @date: 2021/4/2 16:29
 * @version:v1.0
 */
public class TestNewInstance {
    Class clazz;
    @Before
    /**
     * ʹ��class����ֱ��new����
     */
    public void test01() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //��ȡ����
        Properties pro = new Properties();
        pro.load(TestNewInstance.class.getClassLoader().getResourceAsStream("flect/config/bean.properties"));
        String className = pro.getProperty("className");
        clazz = Class.forName(className);
        //ͨ��class����������class����������͵Ķ���
        /**
         * obj�ı���ʱ����ʱObject
         * obj��������������������ΪӦ���ǵ��Ǹ�
         * ��û���޲���������ʱ�ᱨ��
         */
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }
    /**
     * ʹ��class�����Ȼ�ȡ�в�����������Ȼ���ٴ�������
     * ���裺
     * 1.��ȡĳ�����͵Ķ���
     * 2.ͨ��class��ȡConstrucutor����
     * 3.ͨ��Construcutor��ȡʵ��
     */
    @Test
    public void test02() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor c = clazz.getConstructor(String.class,int.class,String.class,int.class);
        Object o = c.newInstance("aa",14,"sdj",15);//��Ҫ����
    }
}
