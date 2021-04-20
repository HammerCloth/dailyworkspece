package Day25;

import java.util.Collections;
import java.util.HashMap;
import java.util.function.Consumer;

/**
 * 2、分别使用lambda表达式完成以下需求
 * * 打印谷天洛的分数
 * * 打印最高分
 * * 分别以60分和70分为及格线，打印及格的人的名字(组合型消费)
 *
 * @author:syx
 * @date: 2021/4/20 14:10
 * @version:v1.0
 */
public class Case4 {
    public static <T> void doJob(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }

    public static <T> void doJob(T t, Consumer<T> consumer1, Consumer<T> consumer2) {
        consumer1.andThen(consumer2).accept(t);
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // key:姓名 value:成绩
        map.put("岑小村", 59);
        map.put("谷天洛", 82);
        map.put("渣渣辉", 98);
        map.put("蓝小月", 65);
        map.put("皮几万", 70);

        doJob("谷天洛", str -> System.out.println(str + ":" + map.get(str)));
        doJob(map.values(), collection -> System.out.println(Collections.max(collection)));
        doJob(map, m -> {
            //输出大于60分的名字
            System.out.println("大于60分的名字:");
            for (String name : map.keySet()) {
                if (map.get(name) >= 60) {
                    System.out.print(name + "\t");
                }
            }
            System.out.println();
        }, m -> {
            //输出大于70分的名字
            System.out.println("大于70分的名字:");
            for (String name : map.keySet()) {
                if (map.get(name) >= 70) {
                    System.out.print(name + "\t");
                }
            }
            System.out.println();
        });
    }
}
