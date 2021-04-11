package cn.syx.colletion;

import java.util.*;

/**
 * @author:syx
 * @date:2021/3/10 14:57
 * @version:v1.0
 */
public class TestIterator {
    public static void main(String[] args) {
        testIteratorMap();
    }
    public static void testIteratorList(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        for(Iterator<String> iter = list.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }
    public static void testIteratorSet(){
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");

        for(Iterator<String> iter = set.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }
    public static void testIteratorMap(){
        Map<Integer,String> m1 = new HashMap<>();
        m1.put(11,"aa");
        m1.put(22,"bb");
        m1.put(33,"cc");

        Set<Map.Entry<Integer,String>> s1 = m1.entrySet();
        for (Iterator<Map.Entry<Integer,String>> iter = s1.iterator();iter.hasNext();){
            Map.Entry temp = iter.next();
            System.out.println(temp.getKey()+":"+temp.getValue());
        }

        Set<Integer> s2 = m1.keySet();
        for (Iterator<Integer> iter = s2.iterator();iter.hasNext();){
            int temp = iter.next();
            System.out.println(temp+":"+m1.get(temp));
        }
    }
}
