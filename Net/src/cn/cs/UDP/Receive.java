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
        //1.���շ�ҲҪ�� socket
        // ip��ϵͳ�Զ���ȡ�����Ƕ˿ںű���ָ��
        DatagramSocket ds = new DatagramSocket(9999);
        //׼��һ�����ݰ����ڽ�������
        byte[] flush = new byte[1024];
        DatagramPacket dp = new DatagramPacket(flush, flush.length);
        //��������
        ds.receive(dp);
        //�����ݲ�����
        byte[] mess = dp.getData();
        int lenth = dp.getLength();
        System.out.println(new String(mess,0,lenth));
        //�Ͽ�
         ds.close();


    }
}
