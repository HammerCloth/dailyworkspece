package cn.cs.CS3;

import java.io.*;
import java.net.Socket;

/**
 * @author:syx
 * @date:2021/3/25 20:58
 * @version:v1.0
 */
public class Mess extends Thread{
    private Socket socket;

    public Mess(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        FileOutputStream fos=null;
        try{
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            //接收文件名并处理
            String fileName = dis.readUTF();
            StringBuilder sb = new StringBuilder(fileName);
            long timeStamp = System.currentTimeMillis();
            int index = sb.indexOf(".");
            String ext = sb.substring(index);
            String name = sb.substring(0, index);
            String newName = "C:\\Users\\sun\\eclipse-workspace\\workspece\\Net\\src\\cn\\cs\\CS3\\upload\\" + name + "-" + timeStamp + "-" + ext;
            fos = new FileOutputStream(newName);
            int len;
            byte[] flush = new byte[1024 * 8];
            while ((len = dis.read(flush)) != -1) {
                fos.write(flush, 0, len);
                fos.flush();
            }
            //给客户端反馈：文件接受完毕
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println("文件接收完毕");
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
