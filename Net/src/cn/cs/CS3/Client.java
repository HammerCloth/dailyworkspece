package cn.cs.CS3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 1.�Ӽ��������ļ���·��������Ϊѡ��Ҫ���͵��ļ�
 * 2.�������������ļ���
 * 3.�����ļ�����
 * 4.���շ������ķ������
 *
 * @author:syx
 * @date :2021/3/25 20:41
 * @version:v1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        Scanner input = new Scanner(System.in);
        System.out.println("��ѡ����Ҫ���͵��ļ���");
        String path = input.nextLine();
        File file = new File(path);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(file.getName());
        FileInputStream fis = new FileInputStream(file);
        byte[] flush = new byte[1024 * 8];
        int len;
        while ((len = fis.read(flush)) != -1) {
            dos.write(flush, 0, len);
            dos.flush();
        }
        fis.close();
        socket.shutdownOutput();//��ʾ���������
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        System.out.println(br.readLine());
        socket.close();


    }

}
