package cn.syx.object;

import java.io.*;

/**�������ж�����Ҫ���л�
 *
 * ���ĳ�����Բ���Ҫ���л������Լӹؼ���transient
 * ���ĳ������static��Ҳ�������л�����Ϊ��̬�ı���������ĳ�����󣬶��������������
 * @author:syx
 * @date: 2021/3/18 15:45
 * @version:v1.0
 */
public class Test2 {
    public static void main(String[] args) {
        //����Ҫ���л���Ʒ��Ϣ���������������л�
        Goods g = new Goods(15,"syx",4500);
        try (OutputStream os = new FileOutputStream("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\dir\\test\\obj.dat");
             ObjectOutputStream oos = new ObjectOutputStream(os);
             InputStream is = new FileInputStream("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\dir\\test\\obj.dat");
             ObjectInputStream ois = new ObjectInputStream(is);
        ) {
            oos.writeObject(g);
            oos.flush();
            Goods u1 = (Goods) ois.readObject();
            String str = u1.toString();
            System.out.println(str);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

