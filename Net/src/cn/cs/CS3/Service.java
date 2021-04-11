package cn.cs.CS3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.接受客户端的连接
 * 2.接受文件名
 * 如何解决文件名重名（文件名加入时间戳），在项目中找个位置存储
 * 后缀名需要保留
 * 3，接受文件内容
 * 这里既要接受文件名又要接受文件内容
 * 这里既有文本信息，又其他类型的数据，只能选择字节流
 * 如何去别文件名与文件内容
 * 哪一种字节输入流可以处理字符串和字节的数据
 *
 * @author:syx
 * @date: 2021/3/25 20:17
 * @version:v1.0
 */
public class Service {
    public static void main(String[] args) throws IOException {
        //1.开启服务器
        ServerSocket server = new ServerSocket(9999);
        boolean flag = true;
        while(flag){
            //2.接受客户端的连接
            Socket socket = server.accept();
            //3.获取输入流
            Mess mess = new Mess(socket);
            mess.start();
        }
        server.close();

    }
}

