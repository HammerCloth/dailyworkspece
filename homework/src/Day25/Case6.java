package Day25;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author:syx
 * @date: 2021/4/20 16:03
 * @version:v1.0
 */
public class Case6 {
    /**
     * 3、在测试类
     * （1）添加5个员工对象到管理的集合中
     * （2）筛选出
     * ①编号是偶数的员工
     * ②薪资低于10000的员工
     * ③年龄大于30岁的女员工
     * ④姓张的员工
     * ⑤所有员工
     * （3）删除
     * ①年龄大于30岁的女员工
     * ②删除“张三”这个员工
     * （4）给每个员工涨薪10%
     */
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "a", 100, 20, true);
        Employee e2 = new Employee(2, "a", 1000, 20, false);
        Employee e3 = new Employee(3, "a", 1000, 35, false);
        Employee e4 = new Employee(4, "a", 1070, 20, true);
        Employee e5 = new Employee(5, "a", 1090, 20, true);
        StaffManagement sm = new StaffManagement();
        sm.add(e1);
        sm.add(e2);
        sm.add(e3);
        sm.add(e4);
        sm.add(e5);
        ArrayList<Employee> list = sm.get(employee -> employee.id % 2 == 0);
        ArrayList<Employee> list2 = sm.get(employee -> employee.salary >1000);
        System.out.println(Arrays.toString(list2.toArray()));
        sm.remove(employee -> employee.age>30);
    }

}

/**
 * 1、声明一个员工类型Employee，包含编号、姓名、薪资、年龄、性别
 */
class Employee {
    int id;
    String name;
    int salary;
    int age;
    boolean sex;//men==true;

    public Employee(int id, String name, int salary, int age, boolean sex) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
    }

    public Employee() {
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}

/**
 * 2、声明一个员工管理类，
 * （1）管理类中使用ArrayList，来存储所有员工对象
 * （2）声明public void add(Employee emp)方法，添加员工
 * （3）声明public ArrayList get(Predicate<Employee> p)方法，可以根据条件筛选出符合要求的员工
 * （4）声明public void remove(Predicate<Employee> p)方法，可以根据条件删除
 * （5）声明public void update(Consumer<Employee> c)方法，对集合中的元素执行c指定的操作
 */
class StaffManagement {
    private static List<Employee> staffs = new ArrayList<>();

    public void add(Employee emp) {
        staffs.add(emp);
    }

    public ArrayList get(Predicate<Employee> p) {
        ArrayList<Employee> newStaffs = new ArrayList<>();
        for (Employee e : staffs) {
            if (p.test(e)) {
                newStaffs.add(e);
            }
        }
        return newStaffs;
    }

    public void remove(Predicate<Employee> p) {
        Iterator<Employee> iter = staffs.iterator();
        while(iter.hasNext()){
            if (p.test(iter.next())) {
                staffs.remove(iter.next());
            }
        }
//        for (Employee e : staffs) {
//            if (p.test(e)) {
//                staffs.remove(e);
//            }
//        }
        System.out.println(Arrays.toString(staffs.toArray()));
    }

    public void update(Consumer<Employee> c) {
        for (Employee e : staffs) {
            c.accept(e);
        }
    }


}