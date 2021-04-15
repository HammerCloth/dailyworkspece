package cn.syx.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ݣ��������Լ�����һ����ʱ�򣬽�����һ��������Ȼ���Լ���ִ���෴�Ĳ���
 * ƽ�У�ͨ��ѭ��������ƽ�в���
 * ���ݵ��㷨��Ҳ���Ƕ�������������
 * @author:syx
 * @date: 2021/4/14 22:09
 * @version:v1.0
 */
public class Case6 {
    public static void main(String[] args) {
        List<List<Character>> result = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        chars.add('A');
        chars.add('B');
        chars.add('C');
        f(result,chars,0);
        System.out.println(result.toString());
    }

    /**
     *
     * @param chars
     * @param k 0-chars.size()-1
     * @return
     */
    public static void f(List<List<Character>> result,List<Character> chars, int k){
      // ѭ������
        if (k==chars.size()-1){
            List<Character> cha = new ArrayList<>();
            cha.addAll(chars);
            result.add(cha);
            return;
        }
      // DFS
        for(int i=k;i<chars.size();i++){
            swap(chars,k,i);//����
            f(result,chars,k+1);
            swap(chars,k,i);//����
        }
    }
    public static void swap(List<Character> chars,int k,int i){
        Character temp = chars.get(k);
        chars.set(k,chars.get(i));
        chars.set(i,temp);
        System.out.println(chars.toString());
    }
}
