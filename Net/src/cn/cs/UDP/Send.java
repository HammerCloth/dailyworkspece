package cn.cs.UDP;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @author:syx
 * @date:2021/3/26 17:03
 * @version:v1.0
 */
public class Send {
    public static void main(String[] args) throws IOException {
        //1.发送方，建立一个socket
        // 发送方的端口号，和ip地址自动获取
        DatagramSocket ds = new DatagramSocket();
        //2.把准备发送的数据打包
        String str = "准备回家";
        byte[] flush = str.getBytes();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp = new DatagramPacket(flush,0,flush.length,ip,9999);
        //3.发送
        ds.send(dp);
        System.out.println("发送完毕");
        //4.关闭
        ds.close();
    }
}
