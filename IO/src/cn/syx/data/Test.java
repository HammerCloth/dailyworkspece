package cn.syx.data;

import java.io.*;

/**
 * �������й����У���Ҫ��ʱ�˳����´�ϣ�������״̬�����ظ�����
 * ϣ��java�ܹ���������������͵����ݣ���ȡʱ���ܻ�ԭ�������͵�����
 *
 * @author:syx
 * @date:2021/3/18 14:44
 * @version:v1.0
 */
public class Test {
    public static void main(String[] args){
        int a = 13;
        double d = 188.44;
        String c = "shangguigu";
        boolean b = true;

        try(OutputStream os = new FileOutputStream("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\dir\\test\\program.dat");
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is = new FileInputStream("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\dir\\test\\program.dat");
            DataInputStream dis = new DataInputStream(is);
            ) {
            dos.writeBoolean(b);
            dos.writeDouble(d);
            dos.writeInt(a);
            dos.writeUTF(c);
            dos.flush();
            boolean b2 = dis.readBoolean();
            double d2 = dis.readDouble();
            int a2 = dis.readInt();
            String str = dis.readUTF();
            System.out.println(b2);
            System.out.println(d2);
            System.out.println(a2);
            System.out.println(str);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
