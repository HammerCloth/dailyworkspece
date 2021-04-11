package cn.cs.群聊;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 群聊
 *
 * @author:syx
 * @date:2021/3/26 14:17
 * @version:v1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //开启客户端
        Socket socket = new Socket("127.0.0.1", 9999);
        //开启两个线程，一个用于收消息，一个用于接收消息
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
            //从键盘输入
            Scanner input = new Scanner(System.in);
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            while (true) {
                System.out.println("请输入：");// 发送到服务器
                String msg = input.nextLine();
                //使用回车作为一句话的结束
                ps.println(msg);
                // 发送bye结束输出
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
