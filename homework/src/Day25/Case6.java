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
     * 3���ڲ�����
     * ��1�����5��Ա�����󵽹���ļ�����
     * ��2��ɸѡ��
     * �ٱ����ż����Ա��
     * ��н�ʵ���10000��Ա��
     * ���������30���ŮԱ��
     * �����ŵ�Ա��
     * ������Ա��
     * ��3��ɾ��
     * ���������30���ŮԱ��
     * ��ɾ�������������Ա��
     * ��4����ÿ��Ա����н10%
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
 * 1������һ��Ա������Employee��������š�������н�ʡ����䡢�Ա�
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
 * 2������һ��Ա�������࣬
 * ��1����������ʹ��ArrayList�����洢����Ա������
 * ��2������public void add(Employee emp)���������Ա��
 * ��3������public ArrayList get(Predicate<Employee> p)���������Ը�������ɸѡ������Ҫ���Ա��
 * ��4������public void remove(Predicate<Employee> p)���������Ը�������ɾ��
 * ��5������public void update(Consumer<Employee> c)�������Լ����е�Ԫ��ִ��cָ���Ĳ���
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