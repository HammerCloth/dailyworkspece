package cn.syx.io;

import java.io.File;

/**
 * @author:syx
 * @date:2021/3/12 11:56
 * @version:v1.0
 */
public class PathDemo01 {
    public static void main(String[] args) {
        /*名称分隔符*/
        String path = "C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\爬虫基本方法.md";
        System.out.println(File.separatorChar);
        //建议
        //1./（一般就使用这一种）
        String path2 = "C:/Users/sun/eclipse-workspace/workspece/IO/src/demo/爬虫基本方法.md";
        //2.常量拼接
        String path3 = "C:"+File.separator+"Users"+File.separator+"sun/eclipse-workspace/workspece/IO/src/demo/爬虫基本方法.md";



    }
}
