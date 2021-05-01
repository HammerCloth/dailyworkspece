package cn.syx;

import java.sql.*;

/**
 * ʹ��preparedstatement�������ʱ����ȡ�������ļ�ֵ
 * ���繺��ʱ������ʱ��������µĶ��������Է����µĵ㵥�ı��
 * ��δ����������ļ�ֵ
 * ����������ps����ʱ�����϶�Ӧ�Ĳ���
 * ����ר�õķ������õ������
 * ���ڽ����Ҫ�ȵ���next��������ʹ��get����������ͻ�����쳣��Ӧ����ָ������
 * @author:syx
 * @date: 2021/5/1 9:06
 * @version:v1.0
 */
public class Cases {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.ע������
        Class.forName("com.mysql.jdbc.Driver");
        //2.��ȡ����
        String url = "jdbc:mysql://localhost:3306/day04_test01_bookstore";
        Connection con = DriverManager.getConnection(url,"root","syxsyx");
        //3����дsql
        String sql = "insert into users values(null,?,?,?)";
        //��statement�������˼�������
        PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//�����������ļ�ֵ
        preparedStatement.setObject(1,"chailinyan2");
        preparedStatement.setObject(2,123456789);
        preparedStatement.setObject(3,"42419313@qq.com");
        int a = preparedStatement.executeUpdate();
        System.out.println(a>0?"��ӳɹ�":"���ʧ��");
        ResultSet rs = preparedStatement.getGeneratedKeys();//mysal���ݿ�ͨ������������������ļ�ֵ,��Ҫ����ר�õķ���������ᷢ������
        if (rs.next()) {
            System.out.println("�µ�idΪ" + rs.getObject(1));
        }
        preparedStatement.close();
        con.close();
    }
}
