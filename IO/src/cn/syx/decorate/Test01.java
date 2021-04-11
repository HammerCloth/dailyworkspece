package cn.syx.decorate;

/**
 * 实现放大器对声音放大的功能
 * @author:syx
 * @date:2021/3/14 16:07
 * @version:v1.0
 */
public class Test01 {
    public static void main(String[] args) {
        People p = new People();
        p.say();

        Amplifier am = new Amplifier(p);
        am.say();
    }
}
interface Say{
    void say();
}
class People implements Say{

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    private int voice = 10;
    @Override
    public void say() {
        System.out.println("人的声音为"+this.getVoice());
    }
}

class Amplifier implements Say{
    private People p;

    public Amplifier(People p) {
        this.p = p;
    }

    @Override
    public void say() {
        System.out.println("人的声音为"+p.getVoice()*1000);
        System.out.println("噪音");
    }
}
