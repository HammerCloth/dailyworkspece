package cn.syx;

import java.sql.*;

/**
 * 使用preparedstatement添加数据时，获取自增长的键值
 * 例如购物时，结算时，会产生新的订单，可以返回新的点单的编号
 * 如何带回自增长的键值
 * 首先再声明ps对象时，带上对应的参数
 * 再用专用的方法来得到结果集
 * 对于结果集要先调用next方法，再使用get方法，否则就会出现异常，应该是指针问题
 * @author:syx
 * @date: 2021/5/1 9:06
 * @version:v1.0
 */
public class Cases {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/day04_test01_bookstore";
        Connection con = DriverManager.getConnection(url,"root","syxsyx");
        //3、编写sql
        String sql = "insert into users values(null,?,?,?)";
        //再statement中声明了几个常量
        PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//返回自增长的键值
        preparedStatement.setObject(1,"chailinyan2");
        preparedStatement.setObject(2,123456789);
        preparedStatement.setObject(3,"42419313@qq.com");
        int a = preparedStatement.executeUpdate();
        System.out.println(a>0?"添加成功":"添加失败");
        ResultSet rs = preparedStatement.getGeneratedKeys();//mysal数据库通过结果集返回自增长的键值,需要调用专用的方法，否则会发生错误
        if (rs.next()) {
            System.out.println("新的id为" + rs.getObject(1));
        }
        preparedStatement.close();
        con.close();
    }
}
