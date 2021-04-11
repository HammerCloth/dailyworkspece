package cn.syx.decorate;

import java.io.*;

/**
 * �ֽڻ�����
 * @author:syx
 * @date:2021/3/16 16:59
 * @version:v1.0
 */
public class Test03 {
    public static void main(String[] args) {
        File src = new File("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\�����������.md");
        File dest = new File("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\�����������2.md");
        try {
            InputStream is = new FileInputStream(src);
            OutputStream os = new FileOutputStream(dest);
            copy(is,os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void copy(InputStream is, OutputStream os){
        InputStream bis = new BufferedInputStream(is);
        OutputStream bos = new BufferedOutputStream(os);
        //����
        byte[] flush = new byte[1024];
        int len;
        try {
            while ((len=bis.read(flush))!=-1){
                bos.write(flush,0,len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
