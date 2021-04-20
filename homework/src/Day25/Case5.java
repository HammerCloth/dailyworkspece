package Day25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 案例：
 *
 * 	1、定义学生类:
 * 1）成员变量 姓名：String name;
 * 2）成员变量 成绩：int score；
 * 3）无参及全参构造
 * 4）重写toString()
 *
 * 	2、在测试类中完成如下要求
 * 	1）将五名学生添加到ArrayList集合
 * 	2）使用Collections.sort(List<T> list, Comparator<? super T> c)方法将学生成绩从小到大进行排序，分别使用以下三种形式实现：
 * 	a、使用匿名内部类
 * 	b、使用Lambda表达式
 * 	c、使用方法引用	//tips:借助Comparator接口中静态方法comparingInt()方法
 *
 * 	3、学生信息与成绩如下：
 *
 * | 姓名   | 数学 |
 * | ------ | ---- |
 * | 谢霆锋 | 85   |
 * | 章子怡 | 63   |
 * | 刘亦菲 | 77   |
 * | 黄晓明 | 33   |
 * | 岑小村 | 92   |
 * @author:syx
 * @date: 2021/4/20 14:25
 * @version:v1.0
 */
public class Case5 {
    /**
     * 2、在测试类中完成如下要求
     *  * 	1）将五名学生添加到ArrayList集合
     *  * 	2）使用Collections.sort(List<T> list, Comparator<? super T> c)方法将学生成绩从小到大进行排序，分别使用以下三种形式实现：
     *  * 	a、使用匿名内部类
     *  * 	b、使用Lambda表达式
     *  * 	c、使用方法引用	//tips:借助Comparator接口中静态方法comparingInt()方法
     */
    public void test(){
        List<Student> stus = new ArrayList<>();
        stus.add(new Student("谢霆锋",85));
        stus.add(new Student("章子怡",63));
        stus.add(new Student("刘亦菲",77));
        stus.add(new Student("黄晓明",33));
        stus.add(new Student("岑小村",92));
        Collections.sort(stus,Comparator.comparingInt(Student::getScore));
    }

}
/**
 *  * 	1、定义学生类:
 *  * 1）成员变量 姓名：String name;
 *  * 2）成员变量 成绩：int score；
 *  * 3）无参及全参构造
 *  * 4）重写toString()
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
        return "学生姓名："+name+"\n"+"学生分数"+score;
    }
}