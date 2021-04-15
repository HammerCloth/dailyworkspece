package cn.syx.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:syx
 * @date: 2021/4/15 17:12
 * @version:v1.0
 */
public class Case8DFS02 {
    public static void main(String[] args) {
        int[] a = {1,2,2,3};
        System.out.println(f(a, a.length-1));
    }
    public static List<List<Integer>>  f(int[] a,int n){
        // todo ³ö¿Ú
        if (n==0){
            List<List<Integer>> newList = new ArrayList<>();
            List<Integer> newSet = new ArrayList<>();
            newList.add(new ArrayList<Integer>());
            newSet.add(a[n]);
            newList.add(newSet);
            return newList;
        }
        // Ñ­»·
        List<List<Integer>> oldList = f(a,n-1);
        List<List<Integer>> newList = new ArrayList<>();
        for (List<Integer> set:oldList){
            newList.add(set);
            List<Integer> newSet = new ArrayList<>(set);
            newSet.add(a[n]);
            newList.add(newSet);
        }
        return newList;
    }

}
