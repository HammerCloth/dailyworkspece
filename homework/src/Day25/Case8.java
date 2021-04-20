package Day25;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * ���������� ArrayList ���ϴ洢���鵱�еĶ����Ա������Ҫ��ʹ��Stream��ʽ�����������ɲ������裺
 * 1. ��һ������ֻҪ����Ϊ3���ֵĳ�Ա������
 * 2. ��һ������ɸѡ֮��ֻҪǰ4���ˣ�
 * 3. �ڶ�������ֻҪ���ŵĳ�Ա������
 * 4. �ڶ�������ɸѡ֮��Ҫǰ1���ˣ�
 * 5. ����������ϲ�Ϊһ�����飻
 * 6. ������������Student����Student���Ͱ���name����
 * 7. ��ӡ���������Student������Ϣ��
 * @author:syx
 * @date: 2021/4/20 20:00
 * @version:v1.0
 */
public class Case8 {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("���");
        one.add("������");
        one.add("÷����");
        one.add("½�˷�");
        one.add("�����");
        one.add("���߷�");
        one.add("��Ĭ��");
        one.add("�����");

        List<String> two = new ArrayList<>();
        two.add("��Զ��");
        two.add("������");
        two.add("�����");
        two.add("����Ϫ");
        two.add("�Ŵ�ɽ");
        two.add("����ͤ");
        two.add("������");

        Stream<String> stream = one.stream()
                                    .filter(str->str.length()==3)
                                    .limit(4);
        Stream<String> stream2 = two.stream()
                                    .filter(str->str.substring(0,1).equals("��"))
                                    .skip(1);

        Stream.concat(stream,stream2).map(Stuudent::new).forEach(System.out::println);
    }
}
class Stuudent {
    private String name;

    public Stuudent() {
    }

    public Stuudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " Student {name='" + name + "'}";
    }
}
