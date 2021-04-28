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
        //1.加载外部驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/day04_test01_bookstore";
        Connection con = DriverManager.getConnection(url,"root","syxsyx");
        //3. 操作数据库,使用JDBC实现往用户表中添加几个用户，注意密码存储使用mysql的password()函数进行加密
        String sql = "insert into users values(null,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,"sxh");
        ps.setString(2,"123456");
        ps.setString(3,"123sdf6@qq.com");
        int a = ps.executeUpdate();
        if (a>0){
            System.out.println("上传成功");
        }
    }
}
