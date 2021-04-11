package cn.syx.colletion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:syx
 * @date:2021/3/7 16:42
 * @version:v1.0
 */
public class TestMap2 {
    public static void main(String[] args){
        Employee e1 = new Employee(10011,"syx1",50000);
        Employee e2 = new Employee(10012,"syx2",500001);
        Employee e3 = new Employee(10013,"syx3",5000022);

        Map<Integer,Employee> m1 = new HashMap<>();
        m1.put(10011,e1);
        m1.put(10012,e2);
        m1.put(10013,e3);

        Employee emp = m1.get(10011);
        System.out.println(emp.toString());

    }
}

class Employee{
    private int id;
    private String name;
    private double salary;

    @Override
    public String toString(){
        return "id:"+id+"\n"+"name:"+name+"\nsalary:"+salary;
    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
