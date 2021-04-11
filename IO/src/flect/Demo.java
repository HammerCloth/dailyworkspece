package flect;

import java.io.Serializable;

/**
 * @author:syx
 * @date: 2021/4/1 15:17
 * @version:v1.0
 */
public class Demo implements Serializable,Comparable<Demo> {
    private String info;
    private int id;
    private String name;
    private int num;

    @Override
    public int compareTo(Demo o) {
        return 0;
    }

    public Demo() {
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Demo(String info, int id, String name, int num) {
        this.info = info;
        this.id = id;
        this.name = name;
        this.num = num;
    }
}
