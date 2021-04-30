package cn.syx;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.Scanner;

/**
 * @author:syx
 * @date: 2021/4/27 21:36
 * @version:v1.0
 */
public class Case1 {
    public static void main(String[] args) {
        //1.�����ⲿ����
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2. ��ȡ���ݿ�����
        String url = "jdbc:mysql://localhost:3306/day04_test01_bookstore";
        Connection con = login(url);
        try {
            showTable(con,"users");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * �������ݿ�
     *
     * @param url
     * @return
     */
    private static Connection login(String url) {
        //3.�û������û���������
        Scanner sc = new Scanner(System.in);
        System.out.print("�������û�����");
        String userName = sc.nextLine();
        System.out.print("���������룺");
        String password = sc.nextLine();
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, userName, password);
            System.out.println(con);
            System.out.println("���ӳɹ���");
        } catch (SQLException e) {
            System.out.println("�û����������");
        }
        return con;
    }

    /**
     * ��user������Ӽ�¼
     *
     * @param con      connection����
     * @param name     name
     * @param password password
     * @param email    email
     * @throws SQLException
     */
    private static void addUser(Connection con, String name, String password, String email) throws SQLException {
        String sql = "insert into users values(null,?,password(?),?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, password);
        ps.setString(3, email);
        int a = ps.executeUpdate();
        if (a > 0) {
            System.out.println("�ϴ��ɹ�");
        }
        ps.close();
        con.close();
    }

    private void addBooks(Connection con, Book book) throws SQLException {
        String sql = "insert into books values(null,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setDouble(3, book.getPrice());
        ps.setInt(4, book.getSales());
        ps.setInt(5, book.getStock());
        ps.setString(6, book.getImg_path());
        int number = ps.executeUpdate();
        if (number > 0) {
            System.out.println("������ɣ�");
        }
        ps.close();
        con.close();
    }

    private static void showTable(Connection con, String tableName) throws SQLException {
        String sql = "select * from ";
        PreparedStatement ps = con.prepareStatement(sql+tableName);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("�ֶ�����"+rsmd.getColumnCount());
        for (int i=1;i<=rsmd.getColumnCount();i++){
            System.out.print(rsmd.getColumnName(i)+"\t");
            //System.out.println(rsmd.getColumnTypeName(i));
        }
        System.out.println();
        for (int i=1;i<=rsmd.getColumnCount();i++){
            //System.out.print(rsmd.getColumnName(i)+"\t");
            System.out.print(rsmd.getColumnTypeName(i)+"\t");
        }
        System.out.println();
        while(rs.next()){
            for (int i=1;i<=rsmd.getColumnCount();i++){
               print(rsmd.getColumnTypeName(i),rs,i);
            }
            System.out.println();
        }
    }
    private static void print(String model,ResultSet rs,int number) throws SQLException {
        switch(model){
            case "INT":
                System.out.print(rs.getString(number)+"\t");
                break;
            case "VARCHAR":
                System.out.print(rs.getString(number)+"\t");
                break;
            case "DOUBLE":
                System.out.print(rs.getDouble(number)+"\t");
                break;
        }
    }
}

class Book {
    private String title;
    private String author;
    private double price;
    private int sales;
    private int stock;
    private String img_path;

    public Book(String title, String author, double price, int sales, int stock, String img_path) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.img_path = img_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }
}