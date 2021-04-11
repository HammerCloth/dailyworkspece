package Nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * IO������IO
 * nio:������IO JDK1.7
 *
 * @author:syx
 * @date: 2021/3/22 15:38
 * @version:v1.0
 */
public class TestNio {
    public static void main(String[] args) throws IOException {
        test02();
    }
    public static void test02(){
        Path file = Paths.get("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\baidu.html");
        try {
            Files.delete(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Path:����File
     * Paths:�����࣬���ڴ���path����
     * Files:������
     * delete()��file�е�delete������ͬ�����ǵ��ļ������ڵ�ʱ��ᱨ�쳣
     * deleteIfExists ����file��delete������ͬ��
     */
    public static void test01() throws IOException {
        Path file = Paths.get("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\baidu.html");
        Path dest = Paths.get("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\Nio\\1.txt");
        file.getNameCount();
        System.out.println(file.getName(0));
        Files.copy(file,dest, StandardCopyOption.REPLACE_EXISTING);

    }
}
