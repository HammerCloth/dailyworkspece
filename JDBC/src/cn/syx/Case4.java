package cn.syx;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * jdbc ������Ĵ���
 *
 * @author:syx
 * @date: 2021/5/1 11:19
 * @version:v1.0
 */
public class Case4 {
    /**
     * ������
     * 1. �������ļ���д���ò���
     * 2. �ڴ������������ļ��������ӳض���
     * 3. ��ȡ���Ӷ���
     * 4. �����close
     * 5.��ȡ���Ӻ���ɾ�Ĳ鶼����
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
