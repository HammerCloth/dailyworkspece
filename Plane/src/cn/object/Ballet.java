package cn.object;

import cn.utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 炮弹类
 * 作为飞机的装饰类来进行作用
 * @author:syx
 * @date :2021/3/31 19:48
 * @version:v1.0
 */
public class Ballet extends GameObject{

    public Ballet() {
    }

    public Ballet(String imgPath, double x, double y) {
        super(imgPath, x, y);
    }
    public Ballet(String imgPath,Double planeX,Double planeY,Image planeImg){
        this.img = Utils.getImage(imgPath);
        x = planeX+planeImg.getWidth(null)/2;
        y = planeY-img.getHeight(null);
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }
    @Override
    public void drawMyself(Graphics g) {
        super.drawMyself(g);
        y-=speed;
    }
}
