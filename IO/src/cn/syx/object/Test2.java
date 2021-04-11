package cn.syx.object;

import java.io.*;

/**不是所有对象都需要序列化
 *
 * 如果某个属性不需要序列化，可以加关键字transient
 * 如果某属性是static，也不会序列化。因为静态的变量不属于某个对象，而是属于整个类的
 * @author:syx
 * @date: 2021/3/18 15:45
 * @version:v1.0
 */
public class Test2 {
    public static void main(String[] args) {
        //现在要序列化产品信息，但是销量不序列化
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

