package Day25;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * ������
 * <p>
 * 1������һ������ʽ�ӿ�CurrentTimePrinter,���г��󷽷�void printCurrentTime()��ʹ��ע��@FunctionalInterface
 * 2���ڲ������ж���public static void showLongTime(CurrentTimePrinter timePrinter)���÷�����Ԥ����Ϊ��ʹ��timePrinter��ӡ��ǰϵͳʱ��
 * 3������showLongTime(),ͨ��lambda���ʽ�������
 * ��1��ʵ��һ����ӡ��ǰϵͳʱ�����ֵ����System. currentTimeMillis()
 * ��2��ʵ�ֶ�����ӡ��ǰϵͳʱ�䣬��Date
 * ��3��ʵ��������ӡ���ػ���ǰϵͳʱ�䣬��LocalDateTime
 *
 * @author:syx
 * @date:2021/4/20 10:03
 * @version:v1.0
 */
public class Case1 {
    /**
     * 3������showLongTime(),ͨ��lambda���ʽ�������
     * * ��1��ʵ��һ����ӡ��ǰϵͳʱ�����ֵ����System. currentTimeMillis()
     * * ��2��ʵ�ֶ�����ӡ��ǰϵͳʱ�䣬��Date
     * * ��3��ʵ��������ӡ���ػ���ǰϵͳʱ�䣬��LocalDateTime
     */
    @Test
    public void test() {
        showLongtime(() -> System.out.println(System.currentTimeMillis()));
        showLongtime(() -> System.out.println(new Date().toString()));
        showLongtime(() -> System.out.println(LocalDateTime.now()));
    }

    /**
     * �ڲ������ж���public static void showLongTime(CurrentTimePrinter timePrinter)��
     * �÷�����Ԥ����Ϊ��ʹ��timePrinter��ӡ��ǰϵͳʱ��
     */
    public static void showLongtime(CurrentTimePrinter timePrinter) {
        timePrinter.printCurrentTime();
    }

}

/**
 * 1������һ������ʽ�ӿ�CurrentTimePrinter,
 * ���г��󷽷�void printCurrentTime()��ʹ��ע��@FunctionalInterface
 */
@FunctionalInterface
interface CurrentTimePrinter {
    void printCurrentTime();
}