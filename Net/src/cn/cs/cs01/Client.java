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
        //1.׼��socket�����ӷ���������Ҫָ���������ĵ�ַ�Ͷ˿ں�
        Socket socket = new Socket("127.0.0.1",8888);
        //2. ��ȡ��������ڷ������ݸ�������
        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());
        //��Ҫ������ĩβд�롰������ǡ����Է����ܶ���-1������Է��ķ����ͻ�һֱ����
        socket.shutdownOutput();
        //3.��ȡ�����������ڽ��ܷ��������͹���������
        InputStream is = socket.getInputStream();
        //��������
        byte[] flush = new byte[1024];
        int len;
        while((len=is.read(flush))!=-1){
            String str = new String(flush,0,len);
            System.out.println(str);
        }
        //4.�ر�socket��ͬʱ����������Ҳ�رյ���
        socket.close();
    }
}
