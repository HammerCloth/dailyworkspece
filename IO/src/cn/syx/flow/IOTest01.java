package cn.syx.flow;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 第一个程序：理解步骤
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author:syx
 * @date:2021/3/13 10:49
 * @version:v1.0
 */
public class IOTest01 {
    public static void main(String[] args) {
        outModel2("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\flow\\abc.txt","i am syx,你只的");
    }
    /*使用一字节一字节搬运的模式
    * 输入*/
    public static void inModel(String path){
        File src = new File(path);
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            int temp;
            while((temp=is.read())!=-1){
                System.out.print((char)temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*使用带有缓存的读取模式
    * 输入*/
    public static void inModel2(String path){
        //创建源
        File src = new File(path);
        //选择流
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            //操作
            byte[] flush = new byte[1024];
            int len;
            while((len=is.read(flush))!=-1){
                //解码
                String str = new String(flush,0,len);
                System.out.print(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    * 字节文件输出流*/
    public static void outModel(String path,String msg){
        //创建源
        File src = new File(path);
        //选择流
        OutputStream os = null;
        try {
            os = new FileOutputStream(src,true);
            //操作
            byte[] flush = msg.getBytes();
            os.write(flush,0, flush.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*字符流
    * 字符输出流*/
    public static void inModel3(String path){
        File src = new File(path);
        Reader reader = null;
        try {
            reader = new FileReader(src);
            char[] flush = new char[1024];
            int len;
            while((len=reader.read(flush))!=-1){
                System.out.print(flush);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*文件字符输出流*/
    public static void outModel2(String path,String msg){
        File dest = new File(path);
        Writer writer = null;
        try {
            writer = new FileWriter(dest,true);
            writer.write(msg,0,msg.length());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer!=null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
