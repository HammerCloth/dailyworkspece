package cn.syx.flow;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * ��һ��������ⲽ��
 * 1.����Դ
 * 2.ѡ����
 * 3.����
 * 4.�ͷ���Դ
 * @author:syx
 * @date:2021/3/13 10:49
 * @version:v1.0
 */
public class IOTest01 {
    public static void main(String[] args) {
        outModel2("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\flow\\abc.txt","i am syx,��ֻ��");
    }
    /*ʹ��һ�ֽ�һ�ֽڰ��˵�ģʽ
    * ����*/
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
    /*ʹ�ô��л���Ķ�ȡģʽ
    * ����*/
    public static void inModel2(String path){
        //����Դ
        File src = new File(path);
        //ѡ����
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            //����
            byte[] flush = new byte[1024];
            int len;
            while((len=is.read(flush))!=-1){
                //����
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
    * �ֽ��ļ������*/
    public static void outModel(String path,String msg){
        //����Դ
        File src = new File(path);
        //ѡ����
        OutputStream os = null;
        try {
            os = new FileOutputStream(src,true);
            //����
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
    /*�ַ���
    * �ַ������*/
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
    /*�ļ��ַ������*/
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
