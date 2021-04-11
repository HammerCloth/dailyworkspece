package cn.syx.flow;

import java.io.*;

/**
 * ������
 * 1.��װcopy
 * 2.��װ�ͷ���Դ
 * @author:syx
 * @date: 2021/3/14 15:38
 * @version:v1.0
 */
public class FileUtils {
    public static void main(String[] args) {
        //�ļ����ļ�
        try {
            InputStream is = new FileInputStream("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\�����������.md");
            OutputStream os = new FileOutputStream("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\flow\\copyfile3.md");
            copy(is,os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //�ļ����ֽ�����
        try {
            InputStream is = new FileInputStream("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\�����������.md");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            copy(is,os);
            byte[] dest = os.toByteArray();
            System.out.print(dest.length);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    /*�Խ����������*/
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
     * �ͷ���Դ
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
