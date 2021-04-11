import org.junit.Test;

/**
 * ������д�������ܶ��̳߳���
 * �������ܳ���Ϊ30��
 * ���ӵ��ٶ���10��ÿ�룬����ÿ����10�����ߵ�ʱ��10��
 * �ڹ���ٶ���1��ÿ�룬�ڹ�ÿ����10�����ߵ�ʱ����1��
 *
 * @author:syx
 * @date:2021/4/9 16:24
 * @version:v1.0
 */
public class Exer01 {
    public static boolean flag = false;

    public static void main(String[] args) {
        System.out.println("������ʼ*****************************************");
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();
        Thread t1 = new Thread(rabbit);
        Thread t2 = new Thread(tortoise);
        t2.start();
        t1.start();
        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("��������*****************************************");

    }

    static class Rabbit implements Runnable {
        //���ӵ��ٶ���10��ÿ�룬����ÿ����10�����ߵ�ʱ��10��
        @Override
        public void run() {
            for (int i = 1; i <= 30; i++) {
                if (flag) {
                    break;
                }
                if (i == 30) {
                    System.out.println("���ӵ����յ�");
                    flag = true;
                }
                if (i % 10 == 0) {
                    System.out.println("��������" + i + "�ף���");
                    System.out.println("��������Ϣ");
                    try {
                        Thread.sleep(1000 * 10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("��������" + i + "�ף���");
                    try {
                        Thread.sleep(1000 / 10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Tortoise implements Runnable {
        //�ڹ���ٶ���1��ÿ�룬�ڹ�ÿ����10�����ߵ�ʱ����1��
        @Override
        public void run() {
            for (int i = 1; i <= 30; i++) {
                if (flag) {
                    break;
                }
                if (i == 30) {
                    System.out.println("tortoise�����յ�");
                    flag = true;
                }
                if (i % 10 == 0) {
                    System.out.println("tortoise����" + i + "�ף���");
                    System.out.println("tortoise����Ϣ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("tortoise����" + i + "�ף���");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

