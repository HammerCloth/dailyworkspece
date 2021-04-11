package cn.syx.hashmap;

import java.util.HashMap;

/**
 * @author:syx
 * @date:2021/3/9 15:48
 * @version:v1.0
 */
public class SyxHashSet {

    HashMap map;
    private static final Object PRESENT = new Object();

    public SyxHashSet(){
        map = new HashMap();
    }
    public int size(){
        return map.size();
    }
    public void add(Object obj){
        map.put(obj,PRESENT);
    }
}
