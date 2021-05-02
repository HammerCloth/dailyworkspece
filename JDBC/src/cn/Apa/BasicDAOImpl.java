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
    //type代表t的实际类型
    private Class type;
    private QueryRunner qr = new QueryRunner();
    //创建子类对象时，默认调用父类无参数构造器
    public BasicDAOImpl(){
        //这个this是你正在new对象的子类的class对象
        Class<? extends BasicDAOImpl> clazz = this.getClass();
        Type t = clazz.getGenericSuperclass();
        //为了调用方法所以强传类型
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
