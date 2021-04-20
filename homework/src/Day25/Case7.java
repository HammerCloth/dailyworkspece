package Day25;

import jdk.nashorn.internal.ir.FunctionCall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author:syx
 * @date: 2021/4/20 19:41
 * @version:v1.0
 */
public class Case7 {
    public static void main(String[] args) {
        /**
         * 1、已知学生成绩如下
         * | 姓名   | 成绩 |
         * | ------ | ---- |
         * | 岑小村 | 59   |
         * | 谷天洛 | 82   |
         * | 渣渣辉 | 98   |
         * | 蓝小月 | 65   |
         * | 皮几万 | 70   |
         *
         * 以学生姓名为key成绩为value创建集合并存储数据
         */
        Map<String, Integer> clazz = new HashMap<>();
        clazz.put("岑小村", 59);
        clazz.put("谷天洛", 82);
        clazz.put("渣渣辉", 98);
        clazz.put("蓝小月", 65);
        clazz.put("皮几万", 70);
        /**
         * 2、使用lambda表达式分别将以下功能封装到Function对象中
         * （1）将Map<String,Integer>中value存到ArrayList<Integer>中
         * （2）求Integer类型ArrayList中所有元素的平均数
         */
        Function<Map<String, Integer>, ArrayList<Integer>> f1 = (m) -> {
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(m.values());
            return list;
        };
        Function<ArrayList<Integer>, Integer> f2 = (list) -> {
            int count = 0;
            for (int i : list) {
                count += i;
            }
            return count / list.size();
        };
        /**
         * 3、使用Function对象求学生的平均值
         */
        System.out.println(f2.apply(f1.apply(clazz)));
    }
}
