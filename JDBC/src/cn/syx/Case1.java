package cn.syx;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author:syx
 * @date:2021/4/27 21:36
 * @version:v1.0
 */
public class Case1 {
    @Test
    public void test01() throws ClassNotFoundException, SQLException {
        //1.�����ⲿ����
        Class.forName("com.mysql.jdbc.Driver");
        //2. ��ȡ���ݿ�����
        String url = "jdbc:mysql://localhost:3306/day04_test01_bookstore";
        Connection con = DriverManager.getConnection(url,"root","syxsyx");
        //3. �������ݿ�,ʹ��JDBCʵ�����û�������Ӽ����û���ע������洢ʹ��mysql��password()�������м���
        String sql = "insert into users values(null,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,"sxh");
        ps.setString(2,"123456");
        ps.setString(3,"123sdf6@qq.com");
        int a = ps.executeUpdate();
        if (a>0){
            System.out.println("�ϴ��ɹ�");
        }
    }
}
