package cn.syx.io;

import java.io.File;

/**
 * @author:syx
 * @date:2021/3/12 11:56
 * @version:v1.0
 */
public class PathDemo01 {
    public static void main(String[] args) {
        /*���Ʒָ���*/
        String path = "C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\�����������.md";
        System.out.println(File.separatorChar);
        //����
        //1./��һ���ʹ����һ�֣�
        String path2 = "C:/Users/sun/eclipse-workspace/workspece/IO/src/demo/�����������.md";
        //2.����ƴ��
        String path3 = "C:"+File.separator+"Users"+File.separator+"sun/eclipse-workspace/workspece/IO/src/demo/�����������.md";



    }
}
