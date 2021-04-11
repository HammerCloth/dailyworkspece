package cn.cs.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author:syx
 * @date: 2021/3/26 18:56
 * @version:v1.0
 */
public class Receive {
    public static void main(String[] args) throws IOException {
        //1.接收方也要又 socket
        // ip由系统自动获取，但是端口号必须指定
        DatagramSocket ds = new DatagramSocket(9999);
        //准备一个数据包用于接收数据
        byte[] flush = new byte[1024];
        DatagramPacket dp = new DatagramPacket(flush, flush.length);
        //接收数据
        ds.receive(dp);
        //把数据拆解出来
        byte[] mess = dp.getData();
        int lenth = dp.getLength();
        System.out.println(new String(mess,0,lenth));
        //断开
         ds.close();


    }
}
