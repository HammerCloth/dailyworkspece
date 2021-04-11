package Nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * IO：阻塞IO
 * nio:非阻塞IO JDK1.7
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
     * Path:类似File
     * Paths:工具类，用于创建path对象
     * Files:工具类
     * delete()与file中的delete基本相同，但是当文件不存在的时候会报异常
     * deleteIfExists 就与file中delete基本相同了
     */
    public static void test01() throws IOException {
        Path file = Paths.get("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\demo\\baidu.html");
        Path dest = Paths.get("C:\\Users\\sun\\eclipse-workspace\\workspece\\IO\\src\\Nio\\1.txt");
        file.getNameCount();
        System.out.println(file.getName(0));
        Files.copy(file,dest, StandardCopyOption.REPLACE_EXISTING);

    }
}
