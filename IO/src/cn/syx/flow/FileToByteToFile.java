package cn.syx.flow;

import java.io.*;

/**
 * �ļ���ȡ���ֽ�������
 * ���ֽ����黹ԭ���ļ�
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
     * �ļ����ֽ�����
     * 1.ͼƬ������
     * 2.�����ֽ�����*/
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
                //�ֽ����Ѿ�׼�����������
                baos.write(flush,0,len);
                //�ֽ���׼�����������ڴ�
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
    //���ֽ�����������ļ�
    //1.���ֽ��������������
    //2.�ӳ���������ļ�
    public static void byteArrayToFile(byte[] src,String filePath){
        File dest = new File(filePath);
        InputStream is = new ByteArrayInputStream(src);
        OutputStream os = null;
        byte[] flush = new byte[1024];
        int len;
        try {
            os = new FileOutputStream(dest);
            while ((len=is.read(flush))!=-1) {
                //��׼�����ֽ����������
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
