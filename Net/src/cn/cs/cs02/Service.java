package cn.cs.cs02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����ͬʱ���ܶ���ͻ��˷���
 *
 * @author:syx
 * @date :2021/3/25 19:38
 * @version:v1.0
 */
public class Service {
    public static void main(String[] args) throws IOException {
        //1,����������
        ServerSocket server = new ServerSocket(8888);
        boolean flag = true;
        while (flag) {
            //2.����һ���ͻ��˵�����
            Socket socket = server.accept();
            MessageHandler ms = new MessageHandler(socket);
            ms.start();
        }
        server.close();

    }
}

class MessageHandler extends Thread {
    private Socket socket;

    public MessageHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {//���෽��û���׳��쳣�����Բ����׳��쳣
        try (//3.�Ȼ�ȡ�����������
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
        ) {
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

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.�ر�socket
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
