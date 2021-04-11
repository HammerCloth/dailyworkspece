package cn.syx.treemap;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author:syx
 * @date:2021/3/9 11:41
 * @version:v1.0
 */
public class TestTreeMap {
    public static void main(String[] args) {
        Map<Integer,String> m1 = new TreeMap<>();
        m1.put(20,"syx");
        m1.put(30,"syx2");
        m1.put(1,"000");

        for(Integer temp:m1.keySet()){
            System.out.println(temp+"---"+m1.get(temp));
        }

        Map<Emp,String> m2 = new TreeMap<>();
        Emp e1 = new Emp(100,"syx",100123);
        Emp e2 = new Emp(1000,"syx1",1001234);
        Emp e3 = new Emp(10000,"syx2",10012345);

        m2.put(e2,"good boy");
        m2.put(e1,"good boy2");
        m2.put(e3,"good boy3");

        for(Emp temp2:m2.keySet()){
            System.out.println(temp2+"---"+m2.get(temp2));
        }


    }
}

class Emp implements Comparable<Emp>{
    int id;
    String name;
    double salay;

    public Emp(int id, String name, double salay) {
        this.id = id;
        this.name = name;
        this.salay = salay;
    }

    @Override
    public int compareTo(Emp o) {
        if(this.salay==o.salay){
            return 0;
        }else if(this.salay>o.salay){
            return 1;
        }else{
            return -1;
        }
    }
}
