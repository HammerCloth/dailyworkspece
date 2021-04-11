package cn.cs.cs01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author:syx
 * @date: 2021/3/23 14:59
 * @version:v1.0
 */
public class Servers {
    public static void main(String[] args) throws IOException {
        //1. 准备一个serverSocket对象，绑定8888端口，用于接收连接
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("等待连接。。。。");
        //2. 再8888端口监听客户端的连接，该方法是个阻塞的方法，如果没有客户端的连接，将一直等待
        Socket socket = ss.accept();
        System.out.println("客户端连接成功。。");
        //3. 获取输入流，用于接受客户端发给服务器的数据
        InputStream is = socket.getInputStream();
        //接受数据
        byte[] flush = new byte[1024];
        int len;
        while((len=is.read(flush))!=-1){
            String str = new String(flush,0,len);
            System.out.println(str);
        }
        // 4.获取输出流，用于发送数据给客户端
        OutputStream os = socket.getOutputStream();
        os.write("欢迎登录".getBytes());
        os.flush();
        socket.shutdownOutput();
        //5.关闭socket，不再与客户端通信
        // socket关闭意味着inputStream与OutputStream也关闭了
        socket.close();
        //ss关闭说明不在接受客户端通信

    }
}
