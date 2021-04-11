package cn.object;

import cn.utils.Utils;

import java.awt.*;

/**
 * 所有游戏物体的父类
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
     * 绘制图像
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
     * 修改相应的速度
     *
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * 返回对应矩形对象的方法
     *
     * @return 返回相应的矩形对象
     */
    public Rectangle getRect() {
        return new Rectangle((int) x, (int) y, width, height);
    }
}
