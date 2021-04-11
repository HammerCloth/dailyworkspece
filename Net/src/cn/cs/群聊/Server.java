package cn.cs.群聊;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author:syx
 * @date :2021/3/26 15:17
 * @version:v1.0
 */
public class Server {
    private static  List<Socket> online = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //创建服务器
        ServerSocket server = new ServerSocket(9999);
        while (true) {
            Socket socket = server.accept();
            online.add(socket);
            //为每一个服务器创建一个线程
            MessageHeader mh = new MessageHeader(socket);
            mh.start();
        }
    }
    private static class MessageHeader extends Thread{
        private Socket socket;
        private String IP;

        public MessageHeader(Socket socket) {
            this.socket = socket;
            this.IP = socket.getInetAddress().getHostAddress();
        }

        public void run(){
            /**
             * 接收当前的客户端的消息
             * 给所有在线的客户端进行转发
             */
            try {
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String str;
                while ((str = br.readLine()) != null) {
                    if ("bye".equals(str)) {
                        break;
                    }
                    //收到一句转发一句
                    sendToOthers(IP + "说： "+str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        public void sendToOthers(String str){
            //遍历所有客户端
            Iterator iter = online.iterator();
            while(iter.hasNext()) {
                Socket on = (Socket) iter.next();
                OutputStream os = null;
                if(!on.equals(socket)) {
                    try {
                        os = on.getOutputStream();
                        PrintStream ps = new PrintStream(os);
                        ps.println(str);
                    } catch (IOException e) {
                        iter.remove();
                    }
                }
            }
        }

    }
}


