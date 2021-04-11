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
 * 绘画简单的游戏窗口
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
     * 在窗口中绘制图像
     *
     * @param g
     */
    public void paint(Graphics g) {
        bg.drawMyself(g);
        me.drawMyself(g);
    }

    /**
     * 创建对应的窗口
     */
    public void lunchFrame() {
        //在游戏窗口打印标题
        setTitle("PlaneX");
        //窗口默认设置为可见
        setVisible(true);
        //设置窗口大小
        setSize(BGWidth, BGHeight);
        //设置窗口出现位置
        setLocation(300, 300);
        //开启多线程
        PaintThread pt = new PaintThread();
        pt.start();
        //增加键盘监听
        addKeyListener(new keyMontor());
        //增加窗口监听，使得关闭窗口时，程序可以结束
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 创建绘画的多线程内部类
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
     * 双缓冲技术
     */
    private Image offScreenImage = null;
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(BGWidth, BGHeight);//这是游戏窗口的宽度和高度
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * 关于键盘的内部类
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
