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
        //1.���ͷ�������һ��socket
        // ���ͷ��Ķ˿ںţ���ip��ַ�Զ���ȡ
        DatagramSocket ds = new DatagramSocket();
        //2.��׼�����͵����ݴ��
        String str = "׼���ؼ�";
        byte[] flush = str.getBytes();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp = new DatagramPacket(flush,0,flush.length,ip,9999);
        //3.����
        ds.send(dp);
        System.out.println("�������");
        //4.�ر�
        ds.close();
    }
}
