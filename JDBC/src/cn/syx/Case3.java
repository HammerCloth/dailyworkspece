package cn.syx;

import javafx.scene.control.SplitPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ������
 * Ҫִ��ĳ��sql���ܶ��
 * ���磺
 * ������Ӳ�������
 * ���û������˶���֮��һ�������кܶ����Ʒ����ô�ͻ���Ƶ�
 * �ٶ�����ϸ�����Ӷ�����¼
 * ��user����
 * username��usernamei 1-100
 * password��passwordi 1-100
 *���ʵ��������
 * 1.��ִ��ʱ����ֱ�ӵ���update������
 * 2.
 *
 * ������Ĭ�Ϲر�������
 * ��url�������?rewriteBatchStatements=true
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
//            System.out.println(flag>0?"����ɹ�":"����ʧ��");
            ps.addBatch();//��һ�����������Ȼ���Ҫִ�е�sql
        }
        ps.executeBatch();
        ps.close();
        con.close();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
