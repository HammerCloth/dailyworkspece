package Day25;

import java.util.Collections;
import java.util.HashMap;
import java.util.function.Consumer;

/**
 * 2���ֱ�ʹ��lambda���ʽ�����������
 * * ��ӡ������ķ���
 * * ��ӡ��߷�
 * * �ֱ���60�ֺ�70��Ϊ�����ߣ���ӡ������˵�����(���������)
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

        // key:���� value:�ɼ�
        map.put("�С��", 59);
        map.put("������", 82);
        map.put("������", 98);
        map.put("��С��", 65);
        map.put("Ƥ����", 70);

        doJob("������", str -> System.out.println(str + ":" + map.get(str)));
        doJob(map.values(), collection -> System.out.println(Collections.max(collection)));
        doJob(map, m -> {
            //�������60�ֵ�����
            System.out.println("����60�ֵ�����:");
            for (String name : map.keySet()) {
                if (map.get(name) >= 60) {
                    System.out.print(name + "\t");
                }
            }
            System.out.println();
        }, m -> {
            //�������70�ֵ�����
            System.out.println("����70�ֵ�����:");
            for (String name : map.keySet()) {
                if (map.get(name) >= 70) {
                    System.out.print(name + "\t");
                }
            }
            System.out.println();
        });
    }
}
