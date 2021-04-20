package Day25;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 案例：
 * <p>
 * 1、定义一个函数式接口CurrentTimePrinter,其中抽象方法void printCurrentTime()，使用注解@FunctionalInterface
 * 2、在测试类中定义public static void showLongTime(CurrentTimePrinter timePrinter)，该方法的预期行为是使用timePrinter打印当前系统时间
 * 3、测试showLongTime(),通过lambda表达式完成需求
 * （1）实现一：打印当前系统时间毫秒值，用System. currentTimeMillis()
 * （2）实现二：打印当前系统时间，用Date
 * （3）实现三：打印本地化当前系统时间，用LocalDateTime
 *
 * @author:syx
 * @date:2021/4/20 10:03
 * @version:v1.0
 */
public class Case1 {
    /**
     * 3、测试showLongTime(),通过lambda表达式完成需求
     * * （1）实现一：打印当前系统时间毫秒值，用System. currentTimeMillis()
     * * （2）实现二：打印当前系统时间，用Date
     * * （3）实现三：打印本地化当前系统时间，用LocalDateTime
     */
    @Test
    public void test() {
        showLongtime(() -> System.out.println(System.currentTimeMillis()));
        showLongtime(() -> System.out.println(new Date().toString()));
        showLongtime(() -> System.out.println(LocalDateTime.now()));
    }

    /**
     * 在测试类中定义public static void showLongTime(CurrentTimePrinter timePrinter)，
     * 该方法的预期行为是使用timePrinter打印当前系统时间
     */
    public static void showLongtime(CurrentTimePrinter timePrinter) {
        timePrinter.printCurrentTime();
    }

}

/**
 * 1、定义一个函数式接口CurrentTimePrinter,
 * 其中抽象方法void printCurrentTime()，使用注解@FunctionalInterface
 */
@FunctionalInterface
interface CurrentTimePrinter {
    void printCurrentTime();
}