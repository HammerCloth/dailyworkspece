package cn.syx.io;

import java.io.File;
import java.io.IOException;

/**
 * @author:syx
 * @date: 2021/3/12 12:10
 * @version:v1.0
 */
public class FileDemo02 {
    public static void main(String[] args) {
        String path = "IO/src/demo/爬虫基本方法.md";
        File src = new File(path);
        System.out.println(System.getProperty("user.dir"));
        try {
            System.out.println(src.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //

    }
}
