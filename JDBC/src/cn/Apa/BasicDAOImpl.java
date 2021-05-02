package cn.Apa;

import cn.syx.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

/**
 * @author:syx
 * @date: 2021/5/2 16:42
 * @version:v1.0
 */
public abstract class BasicDAOImpl<T> {
    //type����t��ʵ������
    private Class type;
    private QueryRunner qr = new QueryRunner();
    //�����������ʱ��Ĭ�ϵ��ø����޲���������
    public BasicDAOImpl(){
        //���this��������new����������class����
        Class<? extends BasicDAOImpl> clazz = this.getClass();
        Type t = clazz.getGenericSuperclass();
        //Ϊ�˵��÷�������ǿ������
        ParameterizedType pz = (ParameterizedType)t;
        Type[] actualTypeArguments = pz.getActualTypeArguments();
        type = (Class)actualTypeArguments[0];
    };

    public void update(String sql,Object... args) throws SQLException {
        qr.update(JDBCTools.getConnection(),sql,args);
    }

    public T getBean(String sql,Object... args) throws SQLException {
        return (T)qr.query(JDBCTools.getConnection(),sql,new BeanHandler<>(type),args);
    }
    public List<T> getBeanList(String sql,Object... args) throws SQLException {
        return (List<T>)qr.query(JDBCTools.getConnection(),sql,new BeanListHandler<>(type),args);
    }
}
