package cn.syx.demo;

/**
 * @author:syx
 * @date:2021/5/25 16:08
 * @version:v1.0
 */
public class Student {
    private String name;
    private String id;
    private String age;

    public Student(String name, String id, String age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
