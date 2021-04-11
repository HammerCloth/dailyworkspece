/**
 * @author:syx
 * @date: 2021/4/10 18:40
 * @version:v1.0
 */
public class TestDeadLock {

    public static void main(String[] args) {
        Object girl = new Object();
        Object money = new Object();
        Bang bang = new Bang(girl,money);
        Boy boy = new Boy(girl,money);
        bang.start();
        boy.start();
    }
}

class Bang extends Thread{
    private Object girl;
    private Object money;

    public Bang(Object girl, Object money) {
        this.girl = girl;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (girl){
            System.out.println("你给我钱我放了你女朋友");
            synchronized(money){
                System.out.println("放掉了对方的女朋友");
            }
        }
    }
}
class Boy extends Thread{
    private Object girl;
    private Object money;

    public Boy(Object girl, Object money) {
        this.girl = girl;
        this.money = money;
    }

    public Boy(ThreadGroup group, String name, Object girl, Object money) {
        super(group, name);
        this.girl = girl;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (money){
            System.out.println("放了了我女朋友，给你钱");
            synchronized(girl){
                System.out.println("给了钱");
            }
        }
    }
}
