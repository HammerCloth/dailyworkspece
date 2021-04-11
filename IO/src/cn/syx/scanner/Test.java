package cn.syx.scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author:syx
 * @date:2021/3/19 17:06
 * @version:v1.0
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        test1();
    }
    public static void test1() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\data\\1.txt"));
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            System.out.println(line);
        }
        sc.close();


    }


}
