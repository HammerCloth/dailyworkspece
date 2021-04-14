package cn.syx.seven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * �Ӽ�����
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
         * ����ʹ�õĵݹ飬�Ǵ����һ����ǰһ�����������Ϊ���������г���ĵ���
         * ������Ҫ���˼��
         */
        Set<Set<String>> oldSet = f(list,n-1);
        Set<Set<String>> newSet = new HashSet<>();
        for (Set<String> set : oldSet){
            newSet.add(set);
            Set<String> clone = (Set<String>)((HashSet)set).clone();
            //������hashset����clone����ķ��������ǿ�¡�����Ķ�������Object���Ա���ǿ��ת��
            //���Ҷ���hashset������ʹ����ǿforѭ������ʹ�õ������ñ��������������������������޸ĺ�
            //�������Ҳ����֮�޸ģ����Ա���ʹ��clone
            clone.add(list.get(n));
            newSet.add(clone);
        }
        return newSet;
    }
}
