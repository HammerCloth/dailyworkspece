package cn.cs.cs02;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**客户端
 * 1. 从键盘读入词语
 * 2.发送给服务器
 * 3.接受服务器返回的结果
 * 1，2，3多次进行知道输入bye，并发送给服务器为止
 * @author:syx
 * @date :2021/3/25 19:14
 * @version:v1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1.连接服务器
        Socket socket = new Socket("127.0.0.1",8888);
        //获取键盘输入
        Scanner input = new Scanner(System.in);
        /**
         * 同样考虑到发送词语，以及词语之间分割问题，那我们选择print Stream和bufferedReader
         */
        PrintStream ps = new PrintStream(socket.getOutputStream());
        BufferedReader bf = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()
                )
        );
        //发送从键盘中输入的词语
        String str;
        while(true){
            str = input.nextLine();
            //发送给服务器端
            ps.println(str);
            //接收
            if (str.equals("bye")){
                break;
            }else{
                // 服务器返回的结果
                System.out.println(bf.readLine());
            }

        }
        socket.close();
    }

}
