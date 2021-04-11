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
 * ?	1、使用绝对路径，在D盘下创建一个testIO文件夹，然后在testIO文件夹中创建一个1.txt文件
 * ?	2、使用相对路径，在当前项目下创建一个testIO文件夹，然后在testIO文件夹中创建一个1.txt文件
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
     * 1、检查D盘的testIO文件夹下是否存在文件a.txt，如果不存在则创建该文件。
     */
    public static void homeWork2_1(){
        File src = new File("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\data\\a.txt");
        if (src.exists()){
            System.out.println("存在");
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
     * 2、获取D盘的testIO文件夹下的a.txt文件的文件名，文件大小，文件的绝对路径和父路径等信息，并将信息输出在控制台
     */
    public static void homeWork2_2(){
        File src = new File("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\data\\a.txt");
        if (src.exists()){
            System.out.println("文件名："+src.getName());
            System.out.println("文件大小："+src.length());
            System.out.println("绝对路径："+src.getAbsolutePath());
            System.out.println("父路径："+src.getParent());
        }
    }
    /**
     * 3. 判断File file = new File("d:\testIO");
     * 是否文件,是文件则输出：xxx是一个文件，是否文件夹,是文件夹则输出：xxx是一个文件夹
     */
    public static void homeWork2_3(){
        File src = new File("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\data\\a.txt");
        if (!src.exists()) {
            System.out.println("错误路径");
        } else if (src.isDirectory()) {
            System.out.println("是一个文件夹");
        } else{
            System.out.println("是一个文件");
        }
    }
    /**
     * 4. 删除D盘的testIO文件夹下的a.txt文件
     */
    public static void homeWork2_4(){
        File src = new File("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\data\\a.txt");
        boolean s = src.delete();
        if (!s) {
            System.out.println("false");
        }
    }
    /**
     * 5. 删除当前项目下的testIO文件夹下的1.txt文件，然后删除testIO文件夹
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

