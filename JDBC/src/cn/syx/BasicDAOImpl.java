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
    //type����t��ʵ������
    private Class type;
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
    public int update(String sql, Object... args) throws SQLException {
        Connection con = JDBCTools.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
        }
        int len = ps.executeUpdate();
        ps.close();//con���ⲻ�أ����ǵ��߳��ڶ��λ�ù������Ӷ���
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
         * �������Ԫ���ݶ����������ݵ����ݣ�
         */
        ResultSetMetaData metaData = rs.getMetaData();
        int counts = metaData.getColumnCount();//����
        if(rs.next()){
            //Ϊt��������Ը�ֵ
            //��ȡ���Զ���
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
         * �������Ԫ���ݶ����������ݵ����ݣ�
         */
        ResultSetMetaData metaData = rs.getMetaData();
        int counts = metaData.getColumnCount();//����
        while(rs.next()){
            //Ϊt��������Ը�ֵ
            //��ȡ���Զ���
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
