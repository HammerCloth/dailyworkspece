package cn.cs.cs02;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**�ͻ���
 * 1. �Ӽ��̶������
 * 2.���͸�������
 * 3.���ܷ��������صĽ��
 * 1��2��3��ν���֪������bye�������͸�������Ϊֹ
 * @author:syx
 * @date :2021/3/25 19:14
 * @version:v1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1.���ӷ�����
        Socket socket = new Socket("127.0.0.1",8888);
        //��ȡ��������
        Scanner input = new Scanner(System.in);
        /**
         * ͬ�����ǵ����ʹ���Լ�����֮��ָ����⣬������ѡ��print Stream��bufferedReader
         */
        PrintStream ps = new PrintStream(socket.getOutputStream());
        BufferedReader bf = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()
                )
        );
        //���ʹӼ���������Ĵ���
        String str;
        while(true){
            str = input.nextLine();
            //���͸���������
            ps.println(str);
            //����
            if (str.equals("bye")){
                break;
            }else{
                // ���������صĽ��
                System.out.println(bf.readLine());
            }

        }
        socket.close();
    }

}
