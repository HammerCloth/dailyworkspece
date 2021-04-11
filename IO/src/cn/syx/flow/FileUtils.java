package cn.syx.flow;

import java.io.*;

/**
 * 工具类
 * 1.封装copy
 * 2.封装释放资源
 * @author:syx
 * @date: 2021/3/14 15:38
 * @version:v1.0
 */
public class FileUtils {
    public static void main(String[] args) {
        //文件到文件
        try {
            InputStream is = new FileInputStream("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\爬虫基本方法.md");
            OutputStream os = new FileOutputStream("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\flow\\copyfile3.md");
            copy(is,os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //文件到字节数组
        try {
            InputStream is = new FileInputStream("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\爬虫基本方法.md");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            copy(is,os);
            byte[] dest = os.toByteArray();
            System.out.print(dest.length);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    /*对接输入输出流*/
    public static void copy(InputStream is,OutputStream os) {
        try {
            byte[] flush = new byte[1024];
            int len;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(is, os);
        }
    }
    /**
     * 释放资源
     */

    private static void close(Closeable... ios){
        for(Closeable io:ios){
            try {
                io.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

    }
}
