package cn.object;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * �ɴ���
 *
 * @author:syx
 * @date: 2021/4/6 8:56
 * @version:v1.0
 */
public class Aircraft extends Plane {
    boolean boom = false;

    public Aircraft() {
    }

    public Aircraft(String imgPath, double x, double y) {
        super(imgPath, x, y);
    }

    //�����ӵ��в���ʼ��
    Ballet ball = new Ballet("images/bullet1.png", this.x, this.y, this.img);

    //����
    public void shot(Graphics g) {
        ball.drawMyself(g);
    }

    @Override
    public void drawMyself(Graphics g) {
        super.drawMyself(g);
        if (boom) {
            shot(g);
        }

    }

    @Override
    public void addDirection(KeyEvent e) {
        super.addDirection(e);
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            boom = true;
        }
    }

    @Override
    public void minusDirection(KeyEvent e) {
        super.minusDirection(e);
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            boom = false;
        }
    }
}


