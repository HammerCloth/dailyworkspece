package cn.syx.object;

import java.io.Serializable;

/**
 * @author:syx
 * @date: 2021/3/18 15:10
 * @version:v1.0
 */
public class User implements Serializable {
    private final static long serialVersionUID = 1l;
    private int age;
    private String name;
    private String sex;

    public User() {
    }

    public User(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "\n年龄："+getAge()+"\n名字："+getName()+"\n性别："+getSex();
    }
}
