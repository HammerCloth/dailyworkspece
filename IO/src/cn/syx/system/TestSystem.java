package cn.syx.system;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * ��java�����ǳ������󣬵��ǿ�����c�ȵײ����Խ����޸�
 * System.in
 * System.out
 * System.err
 * @author:syx
 * @date:2021/3/22 15:16
 * @version:v1.0
 */
public class TestSystem {
    public static void main(String[] args) throws FileNotFoundException {
        test1();
    }
    public static void test1() throws FileNotFoundException {
        System.setOut(new PrintStream("C:\\Users\\sun\\eclipse-workspace\\" +
                "workspece\\IO\\src\\cn\\syx\\system\\ 1.txt"));
        System.out.println("aaaaa");
        System.out.println("aaaaa");
        System.out.println("aaaaa");
        System.out.println("aaaaa");
        System.out.println("aaaaa");

    }
}
