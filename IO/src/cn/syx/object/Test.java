package cn.syx.object;

import java.io.*;

/**
 * @author:syx
 * @date:2021/3/18 15:10
 * @version:v1.0
 */
public class Test {
    public static void main(String[] args) {
        User u = new User(18,"sux","man");
        try (OutputStream os = new FileOutputStream("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\dir\\test\\obj.dat");
             ObjectOutputStream oos = new ObjectOutputStream(os);
             InputStream is = new FileInputStream("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\dir\\test\\obj.dat");
             ObjectInputStream ois = new ObjectInputStream(is);
        ) {
            oos.writeObject(u);
            oos.flush();
            User u1 = (User)ois.readObject();
            String str = u1.toString();
            System.out.println(str);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
