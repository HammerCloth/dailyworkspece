package cn.syx.flow;

import java.io.*;

/**
 * 文件读取到字节数组中
 * 将字节数组还原到文件
 * @author:syx
 * @date: 2021/3/14 11:08
 * @version:v1.0
 */
public class FileToByteToFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\flow\\copyfile.md";
        String filePath = "C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\flow\\copyfile2.md";
        byte[] src = fileToByteArray(path);
        byteArrayToFile(src,filePath);
    }
    /**
     * 文件到字节数组
     * 1.图片到程序
     * 2.程序到字节数组*/
    public static byte[] fileToByteArray(String path){
        File src = new File(path);
        byte[] dest = null;
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(src);
            byte[] flush = new byte[1024];
            int len;
            while((len=is.read(flush))!=-1){
                //字节流已经准备好流入程序
                baos.write(flush,0,len);
                //字节流准备进行流入内存
            }
            baos.flush();
            dest = baos.toByteArray();
            return dest;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is!=null) {
                try {
                    is.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
        return dest;
    }
    //从字节数组输出到文件
    //1.从字节数组输出到程序
    //2.从程序输出到文件
    public static void byteArrayToFile(byte[] src,String filePath){
        File dest = new File(filePath);
        InputStream is = new ByteArrayInputStream(src);
        OutputStream os = null;
        byte[] flush = new byte[1024];
        int len;
        try {
            os = new FileOutputStream(dest);
            while ((len=is.read(flush))!=-1) {
                //已准备好字节数组读入流
                os.write(flush,0,len);
                os.flush();
            }
        } catch (IOException w) {
            w.printStackTrace();
        } finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }

    }
}
