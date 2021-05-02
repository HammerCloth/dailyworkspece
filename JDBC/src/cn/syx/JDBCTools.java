package cn.syx;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author:syx
 * @date: 2021/5/2 9:21
 * @version: v3.0
 */
public class JDBCTools {
    private static DataSource ds;
    private static ThreadLocal<Connection> th;
    static {
        Properties pro = new Properties();
        try {
            pro.load(JDBCTools.class.getClassLoader().getResourceAsStream("cn/syx/config/druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        th = new ThreadLocal<Connection>();
    }
    //直接抛出编译时异常
    public static Connection getConnection() throws SQLException {
        Connection con = th.get();//获取线程中共享的连接对象
        if(con==null){//第一次获取连接
            con = ds.getConnection();//从连接池中拿一个新的
            th.set(con);
        }
        return con;
    }
    //把编译时异常转化为运行时异常
    public static void free(Connection con){
        try {
            if (con!=null){
            con.close();}
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
    public static int update(String sql,Object... args) throws SQLException {
        //获取连接
        Connection con = getConnection();
        //创建ps
        PreparedStatement ps = con.prepareStatement(sql);
        //设置？
        if(args!=null&&args.length>0){
            for(int i=1;i<=args.length;i++){
                ps.setObject(i,args[i-1]);
            }
        }
        int len = ps.executeUpdate();
        ps.close();
        return len;
    }
}
