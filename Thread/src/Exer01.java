import org.junit.Test;

/**
 * 案例编写龟兔赛跑多线程程序，
 * 设置赛跑长度为30米
 * 兔子的速度是10米每秒，兔子每跑完10米休眠的时间10秒
 * 乌龟的速度是1米每秒，乌龟每跑完10米休眠的时候是1秒
 *
 * @author:syx
 * @date:2021/4/9 16:24
 * @version:v1.0
 */
public class Exer01 {
    public static boolean flag = false;

    public static void main(String[] args) {
        System.out.println("比赛开始*****************************************");
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
        System.out.println("比赛结束*****************************************");

    }

    static class Rabbit implements Runnable {
        //兔子的速度是10米每秒，兔子每跑完10米休眠的时间10秒
        @Override
        public void run() {
            for (int i = 1; i <= 30; i++) {
                if (flag) {
                    break;
                }
                if (i == 30) {
                    System.out.println("兔子到达终点");
                    flag = true;
                }
                if (i % 10 == 0) {
                    System.out.println("兔子跑了" + i + "米！！");
                    System.out.println("兔子在休息");
                    try {
                        Thread.sleep(1000 * 10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("兔子跑了" + i + "米！！");
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
        //乌龟的速度是1米每秒，乌龟每跑完10米休眠的时候是1秒
        @Override
        public void run() {
            for (int i = 1; i <= 30; i++) {
                if (flag) {
                    break;
                }
                if (i == 30) {
                    System.out.println("tortoise到达终点");
                    flag = true;
                }
                if (i % 10 == 0) {
                    System.out.println("tortoise跑了" + i + "米！！");
                    System.out.println("tortoise在休息");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("tortoise跑了" + i + "米！！");
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

