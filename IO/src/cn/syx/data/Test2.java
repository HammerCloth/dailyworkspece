package cn.syx.data;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author:syx
 * @date:2021/3/19 10:28
 * @version:v1.0
 */
public class Test2 {
    public static void main(String[] args) {
        homeWork2_5();
    }

/**
 * ?	1��ʹ�þ���·������D���´���һ��testIO�ļ��У�Ȼ����testIO�ļ����д���һ��1.txt�ļ�
 * ?	2��ʹ�����·�����ڵ�ǰ��Ŀ�´���һ��testIO�ļ��У�Ȼ����testIO�ļ����д���һ��1.txt�ļ�
 */
    public static void homeWork1_1(){
        File src = new File("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\data\\1.txt");
        try {
            src.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void homeWork1_2(){
        File src = new File("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\data\\testIO");
        if(!src.exists()){
            boolean x = src.mkdir();
            System.out.println(x);
        }
        File srcc = new File("IO\\src\\cn\\syx\\data\\testIO\\1.txt");
        if (!srcc.exists()){
            try {
                boolean z = srcc.createNewFile();
                System.out.println(z);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 1�����D�̵�testIO�ļ������Ƿ�����ļ�a.txt������������򴴽����ļ���
     */
    public static void homeWork2_1(){
        File src = new File("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\data\\a.txt");
        if (src.exists()){
            System.out.println("����");
        } else {
            try {
                boolean x = src.createNewFile();
                System.out.println(x);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 2����ȡD�̵�testIO�ļ����µ�a.txt�ļ����ļ������ļ���С���ļ��ľ���·���͸�·������Ϣ��������Ϣ����ڿ���̨
     */
    public static void homeWork2_2(){
        File src = new File("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\data\\a.txt");
        if (src.exists()){
            System.out.println("�ļ�����"+src.getName());
            System.out.println("�ļ���С��"+src.length());
            System.out.println("����·����"+src.getAbsolutePath());
            System.out.println("��·����"+src.getParent());
        }
    }
    /**
     * 3. �ж�File file = new File("d:\testIO");
     * �Ƿ��ļ�,���ļ��������xxx��һ���ļ����Ƿ��ļ���,���ļ����������xxx��һ���ļ���
     */
    public static void homeWork2_3(){
        File src = new File("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\data\\a.txt");
        if (!src.exists()) {
            System.out.println("����·��");
        } else if (src.isDirectory()) {
            System.out.println("��һ���ļ���");
        } else{
            System.out.println("��һ���ļ�");
        }
    }
    /**
     * 4. ɾ��D�̵�testIO�ļ����µ�a.txt�ļ�
     */
    public static void homeWork2_4(){
        File src = new File("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\data\\a.txt");
        boolean s = src.delete();
        if (!s) {
            System.out.println("false");
        }
    }
    /**
     * 5. ɾ����ǰ��Ŀ�µ�testIO�ļ����µ�1.txt�ļ���Ȼ��ɾ��testIO�ļ���
     */
    public static void homeWork2_5(){
        File src = new File("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\data\\testIO");
        File[] files = src.listFiles();
        if (files!=null){
            for (File file:files){
                file.delete();
            }
        }
        src.delete();
    }
}

