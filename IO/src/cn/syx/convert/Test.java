package cn.syx.convert;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**转换流：InputStreamReader OutputStreamWritter
 * 1.以字符流的形式操作字节流
 * 2. 指定字符集
 * @author:syx
 * @date:2021/3/16 17:25
 * @version:v1.0
 */
public class Test {
    public static void main(String[] args) {
        spider();
    }
    public static void eco(){
        try(BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter os = new BufferedWriter(new OutputStreamWriter(System.out));){
            String msg = "";
            while(!msg.equals("quit")){
                msg = is.readLine();
                os.write(msg);
                os.newLine();
                os.flush();
            }
        } catch(IOException e){
            e.printStackTrace();
        }


    }
    public static void spider(){
        try (BufferedReader is =
                     new BufferedReader(
                        new InputStreamReader(
                            new URL("https://www.baidu.com").openStream(), StandardCharsets.UTF_8));
             BufferedWriter os =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                new FileOutputStream("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\baidu.html"), StandardCharsets.UTF_8));
        ) {
            String str = "";
            while ((str=is.readLine())!=null){
                os.write(str);
                os.newLine();
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
