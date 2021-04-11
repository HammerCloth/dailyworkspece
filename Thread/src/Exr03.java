/**
 * @author:syx
 * @date: 2021/4/10 18:58
 * @version:v1.0
 */
public class Exr03 {
    public static void main(String[] args) {
        WorkSpace ws = new WorkSpace();
        Builder b = new Builder("厨师",ws);
        Waiter w = new Waiter("waiter",ws);
        b.start();
        w.start();
    }
}
class WorkSpace{
    private static final int MAX = 1;
    private int count;
    public  void put(){
        count++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"放置一项*************剩余 "+count);
    }
    public  void get(){
        count--;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"取走一项*************剩余 "+count);
    }
}
class Builder extends Thread{
    private WorkSpace ws;

    public Builder(String name, WorkSpace ws) {
        super(name);
        this.ws = ws;
    }

    @Override
    public void run() {
        while(true){
            ws.put();
        }
    }
}

class Waiter extends Thread{
    private WorkSpace ws;

    public Waiter(String name, WorkSpace ws) {
        super(name);
        this.ws = ws;
    }

    @Override
    public void run() {
        while(true){
            ws.get();
        }
    }
}
