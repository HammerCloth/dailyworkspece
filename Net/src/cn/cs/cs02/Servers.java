package cn.cs.cs02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * (1)接受客户端的访问
 * 2. 接受客户段发送的一个单词
 * 3，将其反转
 * 4.返回这个单词
 * 5，重复2-4，接受到bye为止
 * @author:syx
 * @date:2021/3/25 18:38
 * @version:v1.0
 */
public class Servers {
    public static void main(String[] args) throws IOException {
        //1,创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2.接受一个客户端的连接
        Socket socket = server.accept();
        //3.先获取输出和输入流
        InputStream is = socket.getInputStream();
        /**
         * 因为是接受一个词语，反转一个，返回一个
         * 那么如果仅仅使用字节流，不好区分词语
         * 需要用到字符流
         * 那么就意味着需要把字节流转化为字符流
         */
        InputStreamReader isr = new InputStreamReader(is);
        /**
         * 字符流中几个字符是一个词语
         * 那么我们意味着选择“换行符”来作为词语的分割符
         * 我们可以使按行读取Scanner或者BufferedReader
         */
        BufferedReader br = new BufferedReader(isr);
        OutputStream os = socket.getOutputStream();
        /**
         * 客户端收到字节同样不方便处理几个字节是一个词语，同样也需要换行符
         * 所以任然要把字节输出流转换为字符流
         * 可以按行写的Bufferedwritter，printStream
         */
        PrintStream ps = new PrintStream(os);
        String msg;
        while ((msg = br.readLine()) != null) {
            if (msg.equals("bye")) {
                break;
            }
            StringBuilder sb = new StringBuilder(msg);
            msg = sb.reverse().toString();
            //返回给客户端
            ps.println(msg);
        }
        //4.关闭socket
        socket.close();
        //5.关闭服务器
        server.close();

    }
}
