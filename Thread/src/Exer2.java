/**
 * @author:syx
 * @date: 2021/4/9 17:32
 * @version:v1.0
 */
public class Exer2 {
    private static int total = 50;

    public static void main(String[] args) {
        TicketWindow s1 = new TicketWindow();

        Thread t1 = new Thread(s1,"窗口1");
        Thread t2 = new Thread(s1,"窗口2");
        Thread t3 = new Thread(s1,"窗口3");
        t1.start();
        t2.start();
        t3.start();

    }

    static class TicketWindow implements Runnable {
        public  int count = 0;

        @Override
        public void run() {
            while (total > 0) {
                saleOneTicket();
            }
        }

        public synchronized void saleOneTicket() {
            if (total > 0) {
                total--;
                count++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 售出一张票" + ",还剩下" + total + "张票");
            }
        }
    }
}

