package cn.cs.CS3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.���ܿͻ��˵�����
 * 2.�����ļ���
 * ��ν���ļ����������ļ�������ʱ�����������Ŀ���Ҹ�λ�ô洢
 * ��׺����Ҫ����
 * 3�������ļ�����
 * �����Ҫ�����ļ�����Ҫ�����ļ�����
 * ��������ı���Ϣ�����������͵����ݣ�ֻ��ѡ���ֽ���
 * ���ȥ���ļ������ļ�����
 * ��һ���ֽ����������Դ����ַ������ֽڵ�����
 *
 * @author:syx
 * @date: 2021/3/25 20:17
 * @version:v1.0
 */
public class Service {
    public static void main(String[] args) throws IOException {
        //1.����������
        ServerSocket server = new ServerSocket(9999);
        boolean flag = true;
        while(flag){
            //2.���ܿͻ��˵�����
            Socket socket = server.accept();
            //3.��ȡ������
            Mess mess = new Mess(socket);
            mess.start();
        }
        server.close();

    }
}

