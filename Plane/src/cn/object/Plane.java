package cn.object;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * ��Ӧ���Լ��ķɻ�����
 *
 * @author:syx
 * @date: 2021/3/30 20:57
 * @version:v1.0
 */
public class Plane extends GameObject{
    //�����ĸ�����
    boolean right = false;
    boolean left = false;
    boolean up = false;
    boolean down = false;

    //�������򰴼���Ӧ
    public void addDirection(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
        }
    }
    public void minusDirection(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
        }
    }

    @Override
    public void drawMyself(Graphics g) {
        super.drawMyself(g);
        if(up){
            y-=speed;
        }
        if (down){
            y+=speed;
        }
        if (right){
            x+=speed;
        }
        if (left){
            x-=speed;
        }
    }

    public Plane() {
    }

    public Plane(String imgPath, double x, double y) {
        super(imgPath, x, y);
    }
}
