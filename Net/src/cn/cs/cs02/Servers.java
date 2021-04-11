package cn.cs.cs02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * (1)���ܿͻ��˵ķ���
 * 2. ���ܿͻ��η��͵�һ������
 * 3�����䷴ת
 * 4.�����������
 * 5���ظ�2-4�����ܵ�byeΪֹ
 * @author:syx
 * @date:2021/3/25 18:38
 * @version:v1.0
 */
public class Servers {
    public static void main(String[] args) throws IOException {
        //1,����������
        ServerSocket server = new ServerSocket(8888);
        //2.����һ���ͻ��˵�����
        Socket socket = server.accept();
        //3.�Ȼ�ȡ�����������
        InputStream is = socket.getInputStream();
        /**
         * ��Ϊ�ǽ���һ�������תһ��������һ��
         * ��ô�������ʹ���ֽ������������ִ���
         * ��Ҫ�õ��ַ���
         * ��ô����ζ����Ҫ���ֽ���ת��Ϊ�ַ���
         */
        InputStreamReader isr = new InputStreamReader(is);
        /**
         * �ַ����м����ַ���һ������
         * ��ô������ζ��ѡ�񡰻��з�������Ϊ����ķָ��
         * ���ǿ���ʹ���ж�ȡScanner����BufferedReader
         */
        BufferedReader br = new BufferedReader(isr);
        OutputStream os = socket.getOutputStream();
        /**
         * �ͻ����յ��ֽ�ͬ�������㴦�����ֽ���һ�����ͬ��Ҳ��Ҫ���з�
         * ������ȻҪ���ֽ������ת��Ϊ�ַ���
         * ���԰���д��Bufferedwritter��printStream
         */
        PrintStream ps = new PrintStream(os);
        String msg;
        while ((msg = br.readLine()) != null) {
            if (msg.equals("bye")) {
                break;
            }
            StringBuilder sb = new StringBuilder(msg);
            msg = sb.reverse().toString();
            //���ظ��ͻ���
            ps.println(msg);
        }
        //4.�ر�socket
        socket.close();
        //5.�رշ�����
        server.close();

    }
}
