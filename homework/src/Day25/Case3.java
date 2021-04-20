package Day25;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.function.Supplier;

/**
 * 分别使用lambda表达式获得以下对象：
 * * 长度为5的String数组
 * * 包含5个1-20(含1和20)之间随机数的HashSet<Integer>集合
 * * 一个代表2018年4月1日的Calendar对象
 * @author:syx
 * @date: 2021/4/20 14:01
 * @version:v1.0
 */
public class Case3 {
    public static <T> T getObj(Supplier<T> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
		String[] strs = getObj(()-> new String[5]);
        HashSet<Integer> set = getObj(()->{
            HashSet<Integer> newSet = new HashSet<>();
            for (int i=0;i<5;i++){
                newSet.add((int) (Math.random()*10));
            }
            return newSet;
        });
        Calendar c = getObj(()-> new GregorianCalendar(2018,3,1));
    }
}
