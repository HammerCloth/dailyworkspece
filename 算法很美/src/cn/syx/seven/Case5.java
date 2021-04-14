package cn.syx.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * ȫ����
 * ���ַ��������ȫ����
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
        //��str����ַ�����
        char[] strList = str.toCharArray();
        //�ѵ�һ���ַ���Ϊ��һ���ַ�������list��
        List<String> list = new ArrayList<>();
        list.add(strList[0]+"");
        //todo ���ڽ������������ַ�����������Ӧ��λ��
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
     * ���ַ������Ӧ���ַ�����λ��
     * �ַ���λ��0-str.length
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

    //ȫ���еĵݹ��
    private static List<String> f(char[] chars,int n){
        //������ڣ�n=0ʱ
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
