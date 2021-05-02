package cn.syx;

import com.alibaba.druid.sql.ast.SQLParameter;
import jdk.internal.org.objectweb.asm.TypeReference;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:syx
 * @date: 2021/5/2 15:07
 * @version:v1.0
 */
public abstract class BasicDAOImpl<T> {
    //type代表t的实际类型
    private Class type;
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
    public int update(String sql, Object... args) throws SQLException {
        Connection con = JDBCTools.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
        }
        int len = ps.executeUpdate();
        ps.close();//con故意不关，考虑到线程在多个位置共享连接对象
        return len;
    }
    public T getBean(String sql, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Connection con = JDBCTools.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
        }
        T t = (T)type.newInstance();
        ResultSet rs = ps.executeQuery();
        /**
         * 结果集的元数据对象（描述数据的数据）
         */
        ResultSetMetaData metaData = rs.getMetaData();
        int counts = metaData.getColumnCount();//列数
        if(rs.next()){
            //为t对象的属性赋值
            //获取属性对象
            for(int i=0;i<counts;i++){
                Field field = type.getDeclaredField(metaData.getColumnName(i+1));
                field.setAccessible(true);
                field.set(t,rs.getObject(i+1));
            }
        }
        rs.close();
        ps.close();
        return t;
    }
    public List<T> getBeanList(String sql, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        List<T> list  = new ArrayList<>();
        Connection con = JDBCTools.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
        }
        ResultSet rs = ps.executeQuery();
        /**
         * 结果集的元数据对象（描述数据的数据）
         */
        ResultSetMetaData metaData = rs.getMetaData();
        int counts = metaData.getColumnCount();//列数
        while(rs.next()){
            //为t对象的属性赋值
            //获取属性对象
            T t = (T)type.newInstance();
            for(int i=0;i<counts;i++){
                Field field = type.getDeclaredField(metaData.getColumnName(i+1));
                field.setAccessible(true);
                field.set(t,rs.getObject(i+1));
            }
            list.add(t);

        }
        rs.close();
        ps.close();
        return list;
    }
}
