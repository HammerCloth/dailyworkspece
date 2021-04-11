package cn.frame;

import cn.object.Aircraft;
import cn.object.Background;
import cn.object.Ballet;
import cn.object.Plane;
import cn.utils.Utils;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * �滭�򵥵���Ϸ����
 *
 * @author:syx
 * @date: 2021/3/30 19:22
 * @version:v1.0
 */
public class MyGameFrame extends JFrame {

    private static final int BGWidth = 480;
    private static final int BGHeight = 700;

    Background bg = new Background("images/background.png");
    Aircraft me = new Aircraft("images/me1.png",200,200);

    public static void main(String[] args) {
        MyGameFrame frame = new MyGameFrame();
        frame.lunchFrame();
    }

    /**
     * �ڴ����л���ͼ��
     *
     * @param g
     */
    public void paint(Graphics g) {
        bg.drawMyself(g);
        me.drawMyself(g);
    }

    /**
     * ������Ӧ�Ĵ���
     */
    public void lunchFrame() {
        //����Ϸ���ڴ�ӡ����
        setTitle("PlaneX");
        //����Ĭ������Ϊ�ɼ�
        setVisible(true);
        //���ô��ڴ�С
        setSize(BGWidth, BGHeight);
        //���ô��ڳ���λ��
        setLocation(300, 300);
        //�������߳�
        PaintThread pt = new PaintThread();
        pt.start();
        //���Ӽ��̼���
        addKeyListener(new keyMontor());
        //���Ӵ��ڼ�����ʹ�ùرմ���ʱ��������Խ���
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * �����滭�Ķ��߳��ڲ���
     */
    class PaintThread extends Thread {
        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * ˫���弼��
     */
    private Image offScreenImage = null;
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(BGWidth, BGHeight);//������Ϸ���ڵĿ�Ⱥ͸߶�
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * ���ڼ��̵��ڲ���
     */
    class keyMontor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            me.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            me.minusDirection(e);
        }
    }
}
