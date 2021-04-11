package cn.syx.colletion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:syx
 * @date:2021/4/9 15:22
 * @version:v1.0
 */
public class test {

}
class Main {
    private static int i = 1;
    public int getNext() {return i++;}
    public static void main(String[] args) {
        Main main = new Main();
        Main main2 = new Main();
        main.getNext();
        main2.getNext();
        System.out.println(main2.getNext());
    }
}