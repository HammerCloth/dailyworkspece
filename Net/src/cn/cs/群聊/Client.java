package cn.cs.Ⱥ��;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Ⱥ��
 *
 * @author:syx
 * @date:2021/3/26 14:17
 * @version:v1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //�����ͻ���
        Socket socket = new Socket("127.0.0.1", 9999);
        //���������̣߳�һ����������Ϣ��һ�����ڽ�����Ϣ
        SendThread st = new SendThread(socket);
        RecerveThread rt = new RecerveThread(socket);
        st.start();
        rt.start();
        try {
            st.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rt.setFlag(false);
        socket.close();
    }
}

class SendThread extends Thread {
    private Socket socket;

    public SendThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            //�Ӽ�������
            Scanner input = new Scanner(System.in);
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            while (true) {
                System.out.println("�����룺");// ���͵�������
                String msg = input.nextLine();
                //ʹ�ûس���Ϊһ�仰�Ľ���
                ps.println(msg);
                // ����bye�������
                if ("bye".equals(msg)) {
                    break;
                }
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class RecerveThread extends Thread {
    private Socket socket;
    private boolean flag=true;

    public RecerveThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            while (flag) {
                String str = br.readLine();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
