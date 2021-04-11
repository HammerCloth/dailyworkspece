package cn.syx.flow;

import java.io.*;

/**
 * @author:syx
 * @date:2021/3/13 14:52
 * @version:v1.0
 */
public class Copy {
    public static void main(String[] args) {
        String soursePath = "C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\爬虫基本方法.md";
        String destPath = "C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\cn\\syx\\flow\\copyfile.md";
        copy(soursePath,destPath);
    }
    public static void copy(String soursePath,String destPath){
        //创建源
        File sourse = new File(soursePath);
        File dest = new File(destPath);
        //选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            //操作
            is = new FileInputStream(sourse);
            os = new FileOutputStream(dest,true);
            byte[] flush = new byte[1024];
            int len;
            while((len=is.read(flush))!=-1){
                os.write(flush,0,len);
                os.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
