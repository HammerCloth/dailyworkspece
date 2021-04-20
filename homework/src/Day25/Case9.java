package Day25;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ������ĳ��֪������������ȫ�����ӰƬ���������ӰƬǰʮ�� ��
 * ȫ��
 * ����1�� ���̸���
 * ����2�� ��Ф��˵ľ��꡷
 * ����3�� �������յ�������
 * ����4�� �����񿭶���
 * ����5�� ��������������
 * ����6�� ���̸�������
 * ����7�� ������ʿ��
 * ����8�� �������ս��
 * ����9�� ���������ˡ�
 * ����10�� ����Ծ����Ժ��
 * ����
 * ��  1�� �������𼧡�
 * ����2�� �������칬��
 * ����3�� ���������ˡ�
 * ����4�� �������Ρ�
 * ����5�� �����š�
 * ����6�� ����ʳ��Ů��
 * ����7�� ���޼����
 * ����8�� ��������̷��
 * ����9�� ����߸�Ժ���
 * ����10�� ������էй��
 * 1���ֽ��������е�ӰƬ�����ֱ�����˳�����δ�������ArrayList����
 * 2��ͨ�����ķ�ʽ
 * 	1����ӡȫ��ӰƬ���а��е�ǰ����ӰƬ��
 * 	2����ӡ����ӰƬ���а��е���5����ӰƬ��
 * 	3�����������а��е�ǰ5����������ͬ�����µļ���
 * 	4�������ӰFilm�࣬��ӰƬ��Ϊname����Film���󲢱��������ϣ�Film���Ͱ���ӰƬ������
 * @author:syx
 * @date: 2021/4/20 20:23
 * @version:v1.0
 */
public class Case9 {
    public static void main(String[] args) {
        ArrayList<String> global = new ArrayList<>();
        global.add("���̸���");
        global.add("��Ф��˵ľ��꡷");
        global.add("�������յ�������");
        global.add("�����񿭶���");
        global.add("��������������");
        global.add("���̸�������");
        global.add("������ʿ��");
        global.add("�������ս��");
        global.add("���������ˡ�");
        global.add("����Ծ����Ժ��");

        ArrayList<String> china = new ArrayList<>();
        china.add("�������𼧡�");
        china.add("�������칬��");
        china.add("���������ˡ�");
        china.add("�������Ρ�");
        china.add("�����š�");
        china.add("����ʳ��Ů��");
        china.add("���޼����");
        china.add("��������̷��");
        china.add("����߸�Ժ���");
        china.add("������էй��");
        /**
         * 2��ͨ�����ķ�ʽ
         *  * 	1����ӡȫ��ӰƬ���а��е�ǰ����ӰƬ��
         *  * 	2����ӡ����ӰƬ���а��е���5����ӰƬ��
         *  * 	3�����������а��е�ǰ5����������ͬ�����µļ���
         *  * 	4�������ӰFilm�࣬��ӰƬ��Ϊname����Film���󲢱��������ϣ�Film���Ͱ���ӰƬ������
         */
        global.stream().limit(3).forEach(System.out::println);
        china.stream().skip(5).forEach(System.out::println);
        Stream.concat(global.stream().limit(5),china.stream().limit(5)).map(Film::new).collect(Collectors.toSet());

    }

}
class Film{
    String name;

    public Film(String name) {
        this.name = name;
    }
}
