package Day25;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author:syx
 * @date: 2021/4/20 20:43
 * @version:v1.0
 */
public class Case10 {
    public static void main(String[] args) {
        String[] provinces = { "�ӱ�ʡ", "ɽ��ʡ", "����ʡ", "����ʡ", "������ʡ", "����ʡ", "����ʡ", "�ຣʡ", "ɽ��ʡ", "����ʡ", "�㽭ʡ", "̨��ʡ",
                "����ʡ", "����ʡ", "����ʡ", "����ʡ", "����ʡ", "����ʡ", "�㶫ʡ", "����ʡ", "�Ĵ�ʡ", "����ʡ", "����ʡ", "������", "�����", "�Ϻ���", "������",
                "���ɹ�������", "�½�ά���������", "���Ļ���������", "����׳��������", "����������", "����ر�������", "�����ر�������" };

        // 1��ͳ�������ֵ�ʡ�ݵĸ���
        long threeCount = Stream.of(provinces).filter(s -> s.length() == 3).count();
        System.out.println("�����ֵ�ʡ�ݵĸ�����" + threeCount);

        // 2��ͳ�������а�����λ���ʵ�ʡ�ݣ������ϱ����ĸ���
        long count = Stream.of(provinces)
                .filter(s -> s.contains("��") || s.contains("��") || s.contains("��") || s.contains("��")).count();
        System.out.println("������λ���ʵ�ʡ�ݣ������ϱ����ĸ���:" + count);

        // 3����ӡ�����а�����λ���ʵ���ͨʡ�ݣ���������ֱϽ���ر���������������
        System.out.println("������λ���ʵ���ͨʡ���У�");
        Stream.of(provinces).filter(s -> s.contains("��") || s.contains("��") || s.contains("��") || s.contains("��"))
                .filter(s -> s.contains("ʡ")).forEach(System.out::println);

        // 4�������е�����ʡ�ݣ�������ֱϽ���ر�����������ȡ�������ŵ���������
        String[] pros = Stream.of(provinces).filter(s -> !s.contains("ʡ")).toArray(String[]::new);
        System.out.println("������:" + Arrays.toString(pros));
    }
}
