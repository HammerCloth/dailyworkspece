package cn.cs.cs01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author:syx
 * @date:2021/3/23 15:13
 * @version:v1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1.准备socket，连接服务器，需要指定服务器的地址和端口号
        Socket socket = new Socket("127.0.0.1",8888);
        //2. 获取输出流用于发送数据给服务器
        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());
        //需要再流的末尾写入“结束标记”，对方才能读到-1，否则对方的方法就会一直阻塞
        socket.shutdownOutput();
        //3.获取输入流，用于接受服务器发送过来的数据
        InputStream is = socket.getInputStream();
        //接受数据
        byte[] flush = new byte[1024];
        int len;
        while((len=is.read(flush))!=-1){
            String str = new String(flush,0,len);
            System.out.println(str);
        }
        //4.关闭socket，同时输入和输出流也关闭掉了
        socket.close();
    }
}
