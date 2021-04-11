package cn.syx.io;

import java.io.File;

/**
 * @author:syx
 * @date:2021/3/12 15:38
 * @version:v1.0
 */
public class DirDemo01 {
    public static void main(String[] args) {
        File dir = new File("IO");
        String[] subName = dir.list();
        for(String temp:subName){
            System.out.println(temp);
        }
        //下级对对象 listFiles（）
        File[] subFiles = dir.listFiles();
        for(File temp:subFiles){
            System.out.println(temp.getName());
        }

        File[] root = dir.listRoots();
        System.out.println(root.toString());
    }
}
