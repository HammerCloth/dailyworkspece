/**
 * @author:syx
 * @date:2021/4/8 15:48
 * @version:v1.0
 */
public class TestRunable {
    public static void main(String[] args) {
        myRunnable mr = new myRunnable();
        Thread t = new Thread(mr);
        t.start();
        for (int i=0;i<100;i++){
            System.out.println(i);
        }
    }
}
class myRunnable implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("Ïß³Ì"+i);
        }
    }
}