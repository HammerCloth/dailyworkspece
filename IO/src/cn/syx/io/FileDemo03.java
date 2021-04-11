package cn.syx.io;

import java.io.File;
import java.io.IOException;

/**
 * @author:syx
 * @date:2021/3/12 15:15
 * @version:v1.0
 */
public class FileDemo03 {
    public static void main(String[] args) {
        File src = new File("IO\\src\\demo\\爬虫基本方法10.md");
        boolean flag = false;
        try {
            flag = src.createNewFile();// 不存在才创建
        } catch (IOException e) {
            e.printStackTrace();
        }

        src.delete();

        System.out.println(src.getName());
        System.out.println(src.getPath());
        System.out.println(src.getAbsolutePath());
        System.out.println(src.getParent());

        System.out.println(src.exists());
        System.out.println(src.isFile());
        System.out.println(src.isDirectory());




    }
}
