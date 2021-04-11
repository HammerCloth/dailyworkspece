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
        //����Ϸ���ڴ�ӡ����
        setTitle("��ѧ��ѧԱ_����Գ��Ʒ");
        //����Ĭ�ϲ��ɼ�����Ϊ�ɼ�
        setVisible(true);
        //���ڴ�С�����500���߶�500
        setSize(500, 500);
        //�������ϽǶ��������λ��
        setLocation(300, 300);

        //���ӹرմ��ڼ����������û�������Ͻǹر�ͼ�꣬���Թر���Ϸ����
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new Test());
    }
}
