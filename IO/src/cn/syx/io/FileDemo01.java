package cn.syx.io;

import java.io.File;

/**
 * @author:syx
 * @date:2021/3/12 12:04
 * @version:v1.0
 */
public class FileDemo01 {
    public static void main(String[] args) {
        String path = "C:/Users/sun/eclipse-workspace/workspece/IO/src/demo/爬虫基本方法.md";
        /*构建File对象*/
        File src = new File(path);
        System.out.println(src.length());
        //
        src = new File("C:/Users/sun/eclipse-workspace/workspece/IO/src/demo","爬虫基本方法.md");
        System.out.println(src.length());
        //
        src = new File(new File("C:/Users/sun/eclipse-workspace/workspece/IO/src/demo"),"爬虫基本方法.md");
        System.out.println(src.length());


    }
}
