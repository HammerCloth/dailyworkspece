package cn.syx;

import javafx.scene.control.SplitPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 批处理：
 * 要执行某条sql语句很多次
 * 例如：
 * 批量添加测试数据
 * 当用户购买了东西之后，一个订单有很多的商品，那么就会设计到
 * 再订单明细中增加多条记录
 * 再user表中
 * username：usernamei 1-100
 * password：passwordi 1-100
 *如何实现批处理
 * 1.在执行时不能直接调用update方法；
 * 2.
 *
 * 服务器默认关闭批处理
 * 在url后面加入?rewriteBatchStatements=true
 * @author:syx
 * @date: 2021/5/1 9:32
 * @version:v1.0
 */
public class Case3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        long start = System.currentTimeMillis();
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/day04_test01_bookstore?rewriteBatchedStatements=true";
        Connection con = DriverManager.getConnection(url, "root", "syxsyx");
        String sql = "insert into users values(null,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        for (int i=3;i<=3000;i++){
            ps.setString(1,"us"+i);
            ps.setInt(2,i);
            ps.setString(3,"syxsyxsyx@q.com");
//            int flag = ps.executeUpdate();
//            System.out.println(flag>0?"插入成功":"插入失败");
            ps.addBatch();//有一个缓冲区，先缓冲要执行的sql
        }
        ps.executeBatch();
        ps.close();
        con.close();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
