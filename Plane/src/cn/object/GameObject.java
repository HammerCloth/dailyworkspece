package cn.object;

import cn.utils.Utils;

import java.awt.*;

/**
 * ������Ϸ����ĸ���
 *
 * @author:syx
 * @date :2021/3/30 20:46
 * @version:v1.0
 */
public class GameObject {
    Image img;
    double x, y;
    int speed = 10;
    int width, height;

    /**
     * ����ͼ��
     */
    public void drawMyself(Graphics g) {
        g.drawImage(img, (int) x, (int) y, null);
    }

    public GameObject(String imgPath, double x, double y) {
        this.img = Utils.getImage(imgPath);
        this.x = x;
        this.y = y;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }

    public GameObject() {
    }

    /**
     * �޸���Ӧ���ٶ�
     *
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * ���ض�Ӧ���ζ���ķ���
     *
     * @return ������Ӧ�ľ��ζ���
     */
    public Rectangle getRect() {
        return new Rectangle((int) x, (int) y, width, height);
    }
}
