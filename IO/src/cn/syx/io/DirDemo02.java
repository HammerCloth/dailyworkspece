package cn.syx.io;

import java.io.File;

/**
 * @author:syx
 * @date: 2021/3/12 15:50
 * @version:v1.0
 */
public class DirDemo02 {
    public static void main(String[] args) {
        File src = new File("IO");
        System.out.println(count(src));
    }
    private static void printDir(File src,int n){
        if(!src.exists()){
            System.out.println("该目录不存在");
        }else{
            if(src.isDirectory()){
                //文件夹
                System.out.println(print_(n)+src.getName());
                File[] files = src.listFiles();
                for(File file:files){
                   printDir(file,n+1);
                }
            }else{
                //文件
                System.out.println(print_(n)+src.getName());
            }
        }

    }
    private static String print_(int n){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<n;i++){
            str.append("-");
        }
        return str.toString();
    }
    private static int count(File src){
        int sum = 0;
        if(src==null||!src.exists()){
            return 0;
        }else{
            if(src.isDirectory()){
                sum+=1;
                for(File file:src.listFiles()){
                    sum = sum+count(file);
                }
            }else{
                sum+=1;
            }
        }
        return sum;

    }
}
