package cn.syx;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * jdbc 对事务的处理
 *
 * @author:syx
 * @date: 2021/5/1 11:19
 * @version:v1.0
 */
public class Case4 {
    /**
     * 方法二
     * 1. 在配置文件中写配置参数
     * 2. 在代码中用配置文件创建连接池对象
     * 3. 获取连接对象
     * 4. 用完后close
     * 5.获取连接后增删改查都不变
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Properties ppt = new Properties();
        ppt.load(Case4.class.getClassLoader().getResourceAsStream("cn/syx/config/druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(ppt);
        for (int i = 1; i <= 30; i++) {
            new Thread(i + "") {
                public void run() {
                    Connection con = null;
                    try {
                        con = ds.getConnection();
                        System.out.println(getName() + con);
                        Thread.sleep(500);
                        con.close();
                    } catch (SQLException | InterruptedException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
