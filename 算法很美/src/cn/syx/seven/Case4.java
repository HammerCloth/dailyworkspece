package cn.syx.seven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 子集问题
 * @author:syx
 * @date: 2021/4/14 15:13
 * @version:v1.0
 */
public class Case4 {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list.toString());
        Set<Set<String>> n = f(list,2);
        Set<Set<String>> n1 = new HashSet<>();
        for (Set<String> s:n){
            if(!s.isEmpty()){
                n1.add(s);
            }
        }
        System.out.println(n1.toString());
    }
    private static Set<Set<String>> f(List<String> list,int n){
        if(n==0){
            Set<Set<String>> newSet1 = new HashSet<>();
            Set<String> a = new HashSet<>();
            a.add(list.get(n));
            Set<String> b = new HashSet<>();
            //b.add("");
            newSet1.add(a);
            newSet1.add(b);
            return newSet1;
        }
        /**
         * 这里使用的递归，是从最后一步的前一步假设出来作为条件，进行程序的调用
         * 这里需要多加思考
         */
        Set<Set<String>> oldSet = f(list,n-1);
        Set<Set<String>> newSet = new HashSet<>();
        for (Set<String> set : oldSet){
            newSet.add(set);
            Set<String> clone = (Set<String>)((HashSet)set).clone();
            //这里是hashset才有clone对象的方法，但是克隆出来的对象又是Object所以必须强行转型
            //而且对于hashset对象，你使用增强for循环，所使用的是引用变量，所以在你对这个变量进行修改后、
            //这个变量也会随之修改，所以必须使用clone
            clone.add(list.get(n));
            newSet.add(clone);
        }
        return newSet;
    }
}
