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
        //1. ׼��һ��serverSocket���󣬰�8888�˿ڣ����ڽ�������
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("�ȴ����ӡ�������");
        //2. ��8888�˿ڼ����ͻ��˵����ӣ��÷����Ǹ������ķ��������û�пͻ��˵����ӣ���һֱ�ȴ�
        Socket socket = ss.accept();
        System.out.println("�ͻ������ӳɹ�����");
        //3. ��ȡ�����������ڽ��ܿͻ��˷���������������
        InputStream is = socket.getInputStream();
        //��������
        byte[] flush = new byte[1024];
        int len;
        while((len=is.read(flush))!=-1){
            String str = new String(flush,0,len);
            System.out.println(str);
        }
        // 4.��ȡ����������ڷ������ݸ��ͻ���
        OutputStream os = socket.getOutputStream();
        os.write("��ӭ��¼".getBytes());
        os.flush();
        socket.shutdownOutput();
        //5.�ر�socket��������ͻ���ͨ��
        // socket�ر���ζ��inputStream��OutputStreamҲ�ر���
        socket.close();
        //ss�ر�˵�����ڽ��ܿͻ���ͨ��

    }
}
