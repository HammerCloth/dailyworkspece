package cn.syx.colletion;

import java.util.HashMap;
import java.util.Map;

/**
 * ≤‚ ‘map
 * @author:syx
 * @date:2021/3/7 16:32
 * @version:v1.0
 */
public class TestMap {
    public static void main(String[] args){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");

        System.out.println(map.get(1));
        System.out.println(map.size());
        System.out.println(map.containsKey(4));
        System.out.println(map.containsValue("one"));

        Map<Integer,String> map2 = new HashMap<>();
        map2.put(3,"si");
        map.putAll(map2);

        System.out.println(map);

        map.put(1,"sys");
        System.out.println(map);





    }
}
