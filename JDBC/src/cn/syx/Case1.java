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
        //1.加载外部驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2. 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/day04_test01_bookstore";
        Connection con = login(url);
        try {
            addUser(con, "kkk", "1234", "42419936@qq.com");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 连接数据库
     *
     * @param url
     * @return
     */
    private static Connection login(String url) {
        //3.用户输入用户名或密码
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String userName = sc.nextLine();
        System.out.print("请输入密码：");
        String password = sc.nextLine();
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, userName, password);
            System.out.println(con);
            System.out.println("连接成功！");
        } catch (SQLException e) {
            System.out.println("用户或密码错误！");
        }
        return con;
    }

    /**
     * 在user表中添加记录
     *
     * @param con      connection对象
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
            System.out.println("上传成功");
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
            System.out.println("更新完成！");
        }
        ps.close();
        con.close();
    }

    private void showTable(Connection con, String tableName) throws SQLException {
        String sql = "select * from ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tableName);
        ResultSet rs = ps.executeQuery();

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