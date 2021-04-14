package cn.syx.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 对字符数组进行全排列
 * @author:syx
 * @date: 2021/4/14 16:04
 * @version:v1.0
 */
public class Case5 {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(insert('e',str,1));
        System.out.println(f("abc".toCharArray(),2).toString());

    }
    private static List<String> pl(String str) {
        //将str变成字符数组
        char[] strList = str.toCharArray();
        //把第一个字符作为第一个字符串输入list中
        List<String> list = new ArrayList<>();
        list.add(strList[0]+"");
        //todo 对于接下来的所有字符逐个插入相对应的位置
        List<String> newList = new ArrayList<>();
        for (int i=1;i< strList.length;i++){
            for (String str1:list){
                for (int k=0;k<=str1.length();k++){
                    newList.add(insert(strList[i],str1,k ));
                }
            }
            list.clear();
            list.addAll(newList);
            newList.clear();
        }
        return list;
    }

    /**
     * 将字符插入对应的字符串的位置
     * 字符串位置0-str.length
     * @return
     */
    private static String insert(char a,String str,int index){
        if (index==0){
            return a+str;
        }
        if (index == str.length()){
            return str+a;
        }
        return str.substring(0,1)+a+str.substring(1,str.length());
    }

    //全排列的递归版
    private static List<String> f(char[] chars,int n){
        //程序出口，n=0时
        if (n==0){
            List<String> newlist = new ArrayList<>();
            String str = ""+chars[0];
            newlist.add(str);
            return newlist;
        }
        List<String> oldlist = f(chars,n-1);
        List<String> newlist = new ArrayList<>();
        for (String str:oldlist){
            for(int i=0;i<=str.length();i++){
                newlist.add(insert(chars[n],str,i));
            }
        }
        return newlist;
    }
}
