package Day25;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.function.Supplier;

/**
 * �ֱ�ʹ��lambda���ʽ������¶���
 * * ����Ϊ5��String����
 * * ����5��1-20(��1��20)֮���������HashSet<Integer>����
 * * һ������2018��4��1�յ�Calendar����
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
