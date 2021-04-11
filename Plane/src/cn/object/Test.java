package cn.object;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author:syx
 * @date: 2021/3/31 17:15
 * @version:v1.0
 */
public class Test extends KeyAdapter {
    public static void main(String[] args) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        System.out.println(e.getKeyCode());
    }


}

class Te extends JFrame{
    public static void main(String[] args) {
        Te t = new Te();
        t.lunchFrame();
    }
    public void lunchFrame(){
        //在游戏窗口打印标题
        setTitle("尚学堂学员_程序猿作品");
        //窗口默认不可见，设为可见
        setVisible(true);
        //窗口大小：宽度500，高度500
        setSize(500, 500);
        //窗口左上角顶点的坐标位置
        setLocation(300, 300);

        //增加关闭窗口监听，这样用户点击右上角关闭图标，可以关闭游戏程序
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new Test());
    }
}
