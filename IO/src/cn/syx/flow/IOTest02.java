package cn.syx.flow;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * �ֽ����鴫����
 * @author:syx
 * @date:2021/3/14 10:16
 * @version:v1.0
 */
public class IOTest02 {
    public static void main(String[] args) {
        byte[] bar = "cheeat is cheap show you code".getBytes();
        outModel(bar);
    }
    /*�ֽ�������*/
    public static void inModel(byte[] bar){
        //Դ��Ϊbar
        InputStream is = new ByteArrayInputStream(bar);
        try {
            byte[] flush = new byte[1024];
            int len;
            while((len=is.read(flush))!=-1){
                String str = new String(flush);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }


    }
    /*�ֽ����������*/
    public static void outModel(byte[] bar){
        byte[] dest = null;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            os.write(bar,0,bar.length);
            os.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
