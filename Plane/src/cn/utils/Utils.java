package cn.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ������
 * @author:syx
 * @date: 2021/3/30 19:37
 * @version:v1.0
 */
public class Utils {
    public static void main(String[] args) {
    }

    private Utils() {
        //�����ཫ������˽�л�
    }
    /**
     * ͨ��·��������Ƭ��Ĺ���
     */
    public static Image getImage(String path){
        BufferedImage bi = null;
        try {
            URL u = Utils.class.getClassLoader().getResource(path);
            bi = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }

}
