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
         * 1����֪ѧ���ɼ�����
         * | ����   | �ɼ� |
         * | ------ | ---- |
         * | �С�� | 59   |
         * | ������ | 82   |
         * | ������ | 98   |
         * | ��С�� | 65   |
         * | Ƥ���� | 70   |
         *
         * ��ѧ������Ϊkey�ɼ�Ϊvalue�������ϲ��洢����
         */
        Map<String, Integer> clazz = new HashMap<>();
        clazz.put("�С��", 59);
        clazz.put("������", 82);
        clazz.put("������", 98);
        clazz.put("��С��", 65);
        clazz.put("Ƥ����", 70);
        /**
         * 2��ʹ��lambda���ʽ�ֱ����¹��ܷ�װ��Function������
         * ��1����Map<String,Integer>��value�浽ArrayList<Integer>��
         * ��2����Integer����ArrayList������Ԫ�ص�ƽ����
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
         * 3��ʹ��Function������ѧ����ƽ��ֵ
         */
        System.out.println(f2.apply(f1.apply(clazz)));
    }
}
