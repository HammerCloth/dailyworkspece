package Day25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ������
 *
 * 	1������ѧ����:
 * 1����Ա���� ������String name;
 * 2����Ա���� �ɼ���int score��
 * 3���޲μ�ȫ�ι���
 * 4����дtoString()
 *
 * 	2���ڲ��������������Ҫ��
 * 	1��������ѧ����ӵ�ArrayList����
 * 	2��ʹ��Collections.sort(List<T> list, Comparator<? super T> c)������ѧ���ɼ���С����������򣬷ֱ�ʹ������������ʽʵ�֣�
 * 	a��ʹ�������ڲ���
 * 	b��ʹ��Lambda���ʽ
 * 	c��ʹ�÷�������	//tips:����Comparator�ӿ��о�̬����comparingInt()����
 *
 * 	3��ѧ����Ϣ��ɼ����£�
 *
 * | ����   | ��ѧ |
 * | ------ | ---- |
 * | л���� | 85   |
 * | ������ | 63   |
 * | ����� | 77   |
 * | ������ | 33   |
 * | �С�� | 92   |
 * @author:syx
 * @date: 2021/4/20 14:25
 * @version:v1.0
 */
public class Case5 {
    /**
     * 2���ڲ��������������Ҫ��
     *  * 	1��������ѧ����ӵ�ArrayList����
     *  * 	2��ʹ��Collections.sort(List<T> list, Comparator<? super T> c)������ѧ���ɼ���С����������򣬷ֱ�ʹ������������ʽʵ�֣�
     *  * 	a��ʹ�������ڲ���
     *  * 	b��ʹ��Lambda���ʽ
     *  * 	c��ʹ�÷�������	//tips:����Comparator�ӿ��о�̬����comparingInt()����
     */
    public void test(){
        List<Student> stus = new ArrayList<>();
        stus.add(new Student("л����",85));
        stus.add(new Student("������",63));
        stus.add(new Student("�����",77));
        stus.add(new Student("������",33));
        stus.add(new Student("�С��",92));
        Collections.sort(stus,Comparator.comparingInt(Student::getScore));
    }

}
/**
 *  * 	1������ѧ����:
 *  * 1����Ա���� ������String name;
 *  * 2����Ա���� �ɼ���int score��
 *  * 3���޲μ�ȫ�ι���
 *  * 4����дtoString()
 */
class Student{
    static String name;
    static int score;

    public Student() {
    }

    public int getScore() {
        return score;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "ѧ��������"+name+"\n"+"ѧ������"+score;
    }
}